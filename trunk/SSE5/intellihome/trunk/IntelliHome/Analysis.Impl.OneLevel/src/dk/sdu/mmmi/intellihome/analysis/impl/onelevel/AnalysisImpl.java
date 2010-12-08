
package dk.sdu.mmmi.intellihome.analysis.impl.onelevel;

import dk.sdu.mmmi.intellihome.analysis.Analysis;
import dk.sdu.mmmi.intellihome.analysis.AnalysisEvent;
import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.core.pipe.Pipe;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
@ServiceProvider(service=Analysis.class, position=1)
public class AnalysisImpl implements Analysis {
	private static class Value {
		int count = 0;
		long distance = 0;
	}

	private static class Result {
		TreeMap<String, Value> forward = new TreeMap<String, Value>();
		TreeMap<String, Value> backward = new TreeMap<String, Value>();
	}

	private HashMap<String, ArrayList<AnalysisDataEvent>> events = new HashMap<String, ArrayList<AnalysisDataEvent>>();
	private HashMap<String, Result> analysisResult = new HashMap<String, Result>();
	private Pipe pipe;

	private int totalEvents = 0;
	private int bindings = 0;
	private long lastAdded = 0;

	@Override
	public String getName() {
		return "One Level Analysis";
	}

	@Override
	public boolean incomingEvent(DataEvent event) {
		if (event.getDiscreteLevels() != 0) {
			addEvent(new AnalysisDataEvent(event));
			analyze();
		}
		return true;
	}

	@Override
	public void initialize(Pipe pipe) {
		this.pipe = pipe;
		Set<String> eventTypes = pipe.getEventTypes();
		Calendar start = Calendar.getInstance();
		start.set(1970, Calendar.JANUARY, 1);
		Calendar end = Calendar.getInstance();
		end.setTimeInMillis(System.currentTimeMillis());
		ArrayList<DataEvent> data = new ArrayList<DataEvent>();
		for (String eventType: eventTypes)
			data.addAll(pipe.getEvents(eventType, start, end));

		Collections.sort(data, new Comparator<DataEvent>() {
			@Override
			public int compare(DataEvent o1, DataEvent o2) {
				long o1Time = o1.getTimeInMillis();
				long o2Time = o2.getTimeInMillis();
				return (o1Time < o2Time ? -1 : (o1Time == o2Time ? 0 : 1));
			}
		});

		for (DataEvent event: data) {
			addEvent(new AnalysisDataEvent(event));
		}

		analyze();
	}

	@Override
	public void cleanup() {
		System.out.println("Cleaning");
		for (Result result: analysisResult.values()) {
			result.backward.clear();
			result.forward.clear();
		}
		analysisResult.clear();
		events.clear();
	}

	@Override
	public Set<AnalysisEvent> performAnalysis(List<DataEvent> data) {
		System.out.println("OneLevel[" + this.hashCode() + "].performAnalysis");
		if (data == null || data.isEmpty()) {
			System.out.println("Empty data!?");
			return Collections.emptySet();
		}
		else {
			DataEvent dataEvent = data.get(data.size() - 1);
			Result result = analysisResult.get(dataEvent.getType());
			if (result == null) {
				System.out.println("Result null for " + dataEvent.getType());
				System.out.println(analysisResult.keySet());
				return Collections.emptySet();
			}

			Set<AnalysisEvent> set = new HashSet<AnalysisEvent>();
			for (Map.Entry<String, Value> entry: result.forward.entrySet()) {
				set.add(new AnalysisEventImpl(entry.getKey(), entry.getValue().distance, entry.getValue().count));
			}

			System.out.println(set);
			return set;
		}
	}

	void addEvent(AnalysisDataEvent event) {
		// Make sure events are added in chronological order
		if (event.getTimestamp() < lastAdded)
			throw new IllegalArgumentException("Events must follow in chronological order");

		String eventType = event.getEventType();

		// Generate list to contain events of that type, if needed
		if (!events.containsKey(eventType))
			events.put(eventType, new ArrayList<AnalysisDataEvent>());

		// Add the event to the list containing events of that type
		events.get(eventType).add(event);
		totalEvents++;

		// Events are added to the end of the list
		// Loop through all lists, and register the new event with the newest
		// of all other event-types, unless the other event doesn't accept
		// the new event (in case that event is already registered with another
		// event of this type).
		for (ArrayList<AnalysisDataEvent> eventList: events.values()) {
			AnalysisDataEvent otherEvent = eventList.get(eventList.size() - 1);
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
		System.out.println("OneLevel[" + this.hashCode() + "].analyze2");
		for (Map.Entry<String, ArrayList<AnalysisDataEvent>> entry: events.entrySet()) {
			System.out.println("Performing analysis on " + entry.getKey() + " with event count of " + entry.getValue().size());
			if (!analysisResult.containsKey(entry.getKey())) 
				analysisResult.put(entry.getKey(), new Result());
			analyze(analysisResult.get(entry.getKey()), entry.getValue());
		}
	}

	private void analyze(Result result, List<AnalysisDataEvent> events) {
		if (events.size() < 3) {
			System.out.println("Not enough events to analyze ");
			return;
		}

		result.forward.clear();
		result.backward.clear();

		// Skip first and last events since they are most likely incomplete (missing backward/forward data)
		// They will still count as forward or backward events for other events though.
		events = events.subList(1, events.size() - 1);
		for (AnalysisDataEvent event: events) {
			for (AnalysisDataEvent forEvent: event.getForwardEvents()) {
				Value value = result.forward.get(forEvent.getEventType());
				if (value == null) {
					value = new Value();
					result.forward.put(forEvent.getEventType(), value);
				}
				value.distance = (value.distance * value.count + (forEvent.getTimestamp() - event.getTimestamp())) / (value.count + 1);
				value.count++;
			}

			for (AnalysisDataEvent backEvent: event.getBackwardEvents()) {
				Value value = result.backward.get(backEvent.getEventType());
				if (value == null) {
					value = new Value();
					result.backward.put(backEvent.getEventType(), value);
				}
				value.distance = (value.distance * value.count + (event.getTimestamp() - backEvent.getTimestamp())) / (value.count + 1);
				value.count++;
			}
		}

		/*
		int count = events.size();
		System.out.println(" ===== ===== " + eventType + " ===== ===== ");
		for (String forEventType: forward.keySet()) {
			double pXY = 1.0 * forward.get(forEventType) / count;
			double pYX = calculateBayes(pXY, forEventType, eventType);
			System.out.printf("          P(%s|%s): %6.2f%% (%s followed by %s)\n", forEventType, eventType, 100.0 * pXY, eventType, forEventType);
			System.out.printf("    Bayes-P(%s|%s): %6.2f%% (Chance that %s follows %s)\n", eventType, forEventType, 100.0 * pYX, eventType, forEventType);
			//clusterTest(events, forEventType, true);
		}

		System.out.println("");
		for (String backEventType: backward.keySet()) {
			double pXY = 1.0 * backward.get(backEventType) / count;
			double pYX = calculateBayes(pXY, eventType, backEventType);
			System.out.printf("          P(%s|%s): %6.2f%% (%s preceded by %s)\n", eventType, backEventType, 100.0 * pXY, eventType, backEventType);
			System.out.printf("    Bayes-P(%s|%s): %6.2f%% (Chance that %s precedes %s)\n", backEventType, eventType, 100.0 * pYX, eventType, backEventType);
			//clusterTest(events, backEventType, false);
		}
		 *
		 */
	}

	private double calculateBayes(double pXY, String typeX, String typeY) {
		double pX = (double)events.get(typeX).size() / totalEvents;
		double pY = (double)events.get(typeY).size() / totalEvents;

		double pYX = (pXY * pY) / pX;

		return pYX;
	}
}
