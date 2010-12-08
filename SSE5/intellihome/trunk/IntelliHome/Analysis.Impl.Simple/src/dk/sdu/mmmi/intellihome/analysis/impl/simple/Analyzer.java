
package dk.sdu.mmmi.intellihome.analysis.impl.simple;

import dk.sdu.mmmi.intellihome.analysis.Analysis;
import dk.sdu.mmmi.intellihome.analysis.impl.simple.cluster.DBSCAN;
import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.core.pipe.Pipe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
@ServiceProvider(service=Analysis.class)
public class Analyzer implements Analysis {

	private HashMap<String, ArrayList<AnalysisEvent>> events = new HashMap<String, ArrayList<AnalysisEvent>>();
	private int totalEvents = 0;
	private int bindings = 0;
	private long lastAdded = 0;

	void addEvent(DataEvent event) {
		if (event.getDiscreteLevels() != 0)
			addEvent(new AnalysisEvent(event));
		else {
			//addMeta(event);
		}
	}

	void addEvent(AnalysisEvent event) {
		// Make sure events are added in chronological order
		if (event.getTimestamp() < lastAdded)
			throw new IllegalArgumentException("Events must follow in chronological order");

		String eventType = event.getType();

		// Generate list to contain events of that type, if needed
		if (!events.containsKey(eventType))
			events.put(eventType, new ArrayList<AnalysisEvent>());

		// Add the event to the list containing events of that type
		events.get(eventType).add(event);
		totalEvents++;

		// Events are added to the end of the list
		// Loop through all lists, and register the new event with the newest
		// of all other event-types, unless the other event doesn't accept
		// the new event (in case that event is already registered with another
		// event of this type).
		for (ArrayList<AnalysisEvent> eventList: events.values()) {
			AnalysisEvent otherEvent = eventList.get(eventList.size() - 1);
			if (otherEvent == event)
				continue;

			if (otherEvent.acceptsForward(event)) {
				otherEvent.registerForward(event);
				event.registerBackward(otherEvent);

				bindings++;
			}
		}
	}

	int getBindings() {
		return bindings;
	}

	void analyze() {
		for (Map.Entry<String, ArrayList<AnalysisEvent>> entry: events.entrySet()) {
			analyze(entry.getKey(), entry.getValue());
		}
	}

	private void analyze(String eventType, List<AnalysisEvent> events) {
		if (events.size() < 3) {
			System.out.println("Not enough events to analyze " + eventType);
			return;
		}

		TreeMap<String, Integer> forward = new TreeMap<String, Integer>();
		TreeMap<String, Integer> backward = new TreeMap<String, Integer>();
		
		// Skip first and last events since they are most likely incomplete (missing backward/forward data)
		// They will still count as forward or backward events for other events though.
		events = events.subList(1, events.size() - 1);
		for (AnalysisEvent event: events) {
			for (AnalysisEvent forEvent: event.getForwardEvents()) {
				Integer value = forward.get(forEvent.getType());
				if (value == null)
					value = 0;
				forward.put(forEvent.getType(), value + 1);
			}

			for (AnalysisEvent backEvent: event.getBackwardEvents()) {
				Integer value = backward.get(backEvent.getType());
				if (value == null)
					value = 0;
				backward.put(backEvent.getType(), value + 1);
			}
		}

		int count = events.size();
		System.out.println(" ===== ===== " + eventType + " ===== ===== ");
		for (String forEventType: forward.keySet()) {
			double pXY = 1.0 * forward.get(forEventType) / count;
			double pYX = calculateBayes(pXY, forEventType, eventType);
			System.out.printf("          P(%s|%s): %6.2f%% (%s followed by %s)\n", forEventType, eventType, 100.0 * pXY, eventType, forEventType);
			System.out.printf("    Bayes-P(%s|%s): %6.2f%% (Chance that %s follows %s)\n", eventType, forEventType, 100.0 * pYX, eventType, forEventType);
			clusterTest(events, forEventType, true);
		}
		
		System.out.println("");
		for (String backEventType: backward.keySet()) {
			double pXY = 1.0 * backward.get(backEventType) / count;
			double pYX = calculateBayes(pXY, eventType, backEventType);
			System.out.printf("          P(%s|%s): %6.2f%% (%s preceded by %s)\n", eventType, backEventType, 100.0 * pXY, eventType, backEventType);
			System.out.printf("    Bayes-P(%s|%s): %6.2f%% (Chance that %s precedes %s)\n", backEventType, eventType, 100.0 * pYX, eventType, backEventType);
			clusterTest(events, backEventType, false);
		}		
	}

	private double calculateBayes(double pXY, String typeX, String typeY) {
		double pX = (double)events.get(typeX).size() / totalEvents;
		double pY = (double)events.get(typeY).size() / totalEvents;

		double pYX = (pXY * pY) / pX;

		return pYX;
	}

	static double getTime(long timestamp) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timestamp);

		return cal.get(Calendar.MILLISECOND) / 1000.0 +
			cal.get(Calendar.SECOND) +
			cal.get(Calendar.MINUTE) * 60.0 +
			cal.get(Calendar.HOUR_OF_DAY) * 60 * 60.0;
	}

	@Override
	public Set<dk.sdu.mmmi.intellihome.analysis.AnalysisEvent> performAnalysis(List<DataEvent> data) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public String getName() {
		return "Analysis Simple";
	}

	@Override
	public boolean incomingEvent(DataEvent event) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void initialize(Pipe pipe) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void cleanup() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	private static class Cluster<E> {
		private boolean enabled = true;
		private E centerValue;
		private ArrayList<E> values;
		private ArrayList<E> prevValues;

		Cluster(E initCenterValue) {
			centerValue = initCenterValue;
		}

		void newIteration() {
			if (!enabled)
				return;
			prevValues = values;
			values = new ArrayList<E>();

			if (prevValues != null) {
				if (prevValues.size() == 0) {
					enabled = false;
					return;
				}

				centerValue = prevValues.get(prevValues.size() / 2);

			}
		}

		boolean hasChanged() {
			if (!enabled)
				return false;

			if (prevValues == null || values == null)
				return true;
			
			if (prevValues.size() != values.size())
				return true;

			for (int i = 0; i < values.size(); i++)
				if (!values.get(i).equals(prevValues.get(i)))
					return true;

			return false;
		}

		void add(E val) {
			values.add(val);
		}

		E getCenter() {
			return centerValue;
		}

		boolean isEnabled() {
			return enabled;
		}
	}

	private void clusterTest(List<AnalysisEvent> events, String eventType, boolean forward) {
		ArrayList<DBSCAN.DataPoint> points = new ArrayList<DBSCAN.DataPoint>();
		for (AnalysisEvent event: events) {
			for (AnalysisEvent otherEvent: forward ? event.getForwardEvents() : event.getBackwardEvents()) {
				if (!otherEvent.getType().equals(eventType))
					continue;

				double dist = otherEvent.getTimestamp() - event.getTimestamp();
				double time = getTime(event.getTimestamp());

				points.add(new DBSCAN.DataPoint(dist, time));
			}
		}

		DBSCAN db = new DBSCAN(points, 100, 10, events.get(0).getType());
		db.analyze();
		for (DBSCAN.Cluster c: db.getClusters()) {
			double x = 0;
			double y = 0;
			for (DBSCAN.DataPoint p: c.getPoints()) {
				x += p.distance;
				y += p.time;
			}
			System.out.printf("Cluster found with %d entries around [%.1f; %.2f]\n",
				c.getPoints().size(),
				x / c.getPoints().size(),
				y / c.getPoints().size());
		}
	}

	private void _clusterTest(List<AnalysisEvent> events, String eventType, boolean forward) {
		long[] distances = new long[events.size()];
		int maxDistIndex = 0;
		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;
		for (AnalysisEvent event: events) {
			for (AnalysisEvent otherEvent: forward ? event.getForwardEvents() : event.getBackwardEvents()) {
				if (!otherEvent.getType().equals(eventType))
					continue;
				long dist = otherEvent.getTimestamp() - event.getTimestamp();
				min = Math.min(min, dist);
				max = Math.max(max, dist);
				distances[maxDistIndex++] = dist;
				Calendar c = Calendar.getInstance();
				c.setTimeInMillis(event.getTimestamp());
				System.out.printf("%d;%d\n", c.get(Calendar.HOUR_OF_DAY) * 60 + c.get(Calendar.MINUTE), dist);
			}
		}
		distances = Arrays.copyOf(distances, maxDistIndex);
		Arrays.sort(distances);
		ArrayList<Cluster<Long>> clusters = new ArrayList<Cluster<Long>>(10);
		for (int i = 0; i < 10; i++)
			clusters.add(new Cluster<Long>(min + i * (max - min) / 10));

		for (int i = 0; i < 10; i++) { // limit to 10 iterations
			for (Cluster<Long> cluster: clusters)
				cluster.newIteration();

			for (int dIndex = 0; dIndex < maxDistIndex; dIndex++) {
				long d = distances[dIndex];
				long dist = Long.MAX_VALUE;
				int index = 0;

				for (int c = 0; c < 10; c++) {
					if (clusters.get(c).isEnabled()) {
						long newDist = Math.abs(clusters.get(c).getCenter() - d);
						if (newDist < dist) {
							dist = newDist;
							index = c;
						}
					}
				}

				clusters.get(index).add(d);
			}

			boolean changed = false;
			for (Cluster<Long> cluster: clusters)
				changed |= cluster.hasChanged();

			if (!changed)
				break;
		}

		for (Cluster<Long> cluster: clusters) {
			if (cluster.isEnabled()) {
				System.out.printf("                                         dist: %s, size: %4d (%5.1f%%) [%s to %s]\n", timeToHours(cluster.getCenter()), cluster.values.size(), 100.0 / maxDistIndex * cluster.values.size(), timeToHours(cluster.values.get(0)), timeToHours(cluster.values.get(cluster.values.size() - 1)));
			}
		}
	}

	private static String timeToHours(long time) {
		long hours = time / (60 * 60 * 1000L);
		long minutes = (time - hours * (60 * 60 * 1000L)) / (60 * 1000L);
		long seconds = (time - (((hours * 60) + minutes) * 60 * 1000L)) / (1000L);

		return String.format("%3d:%02d:%02d", hours, minutes, seconds);
	}
}
