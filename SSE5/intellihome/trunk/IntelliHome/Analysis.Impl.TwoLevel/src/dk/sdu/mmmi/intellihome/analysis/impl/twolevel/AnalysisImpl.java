
package dk.sdu.mmmi.intellihome.analysis.impl.twolevel;

import dk.sdu.mmmi.intellihome.analysis.Analysis;
import dk.sdu.mmmi.intellihome.analysis.AnalysisEvent;
import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.core.dataaccess.DataGenerator;
import dk.sdu.mmmi.intellihome.core.pipe.Pipe;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
@ServiceProvider(service=Analysis.class)
public class AnalysisImpl implements Analysis {
	private final AnalysisNodeManager nodeManager = new AnalysisNodeManager();
	private Pipe pipe;

	@Override
	public String getName() {
		return "Analysis Two Level";
	}

	@Override
	public Set<AnalysisEvent> performAnalysis(List<DataEvent> data) {
		return nodeManager.getCandidates(data);
	}

	@Override
	public boolean incomingEvent(DataEvent event) {
		if (nodeManager.isEmpty()) {
			// XXX Reenable
			//loadHistory();
			fakeHistory();
		}
		analyseEvent(event);

		return false;
	}

	@Override
	public void initialize(Pipe pipe) {
		cleanup();
		this.pipe = pipe;
	}

	@Override
	public void cleanup() {
		nodeManager.reset();
	}

	private void loadHistory() {
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

		for (DataEvent event: data)
			analyseEvent(event);
	}

	private void analyseEvent(DataEvent event) {
		nodeManager.incomingEvent(event);
	}


	private void fakeHistory() {
		Random r = new Random();
		for (int day = 0; day < 365; day++) {
			Calendar c = Calendar.getInstance();
			c.set(Calendar.YEAR, 2009);
			c.set(Calendar.DAY_OF_YEAR, day);
			c.set(Calendar.HOUR_OF_DAY, 17);
			c.set(Calendar.MINUTE, 0);
			
			boolean dark = (day < 55 || day > 300) ||
				((day < 100 || day > 260) && r.nextInt(10) < 3);

			analyseEvent(new FakeDataEvent("9", c.getTimeInMillis(), dark ? r.nextInt(10) + 5 : 180 + r.nextInt(60), 0));
			c.add(Calendar.MINUTE, 10);
			analyseEvent(new FakeDataEvent("4[8]", c.getTimeInMillis(), 85, 10));
			if (dark) {
				c.add(Calendar.SECOND, 5);
				analyseEvent(new FakeDataEvent("2[1]", c.getTimeInMillis(), 255, 2));
				c.add(Calendar.SECOND, 3);
				analyseEvent(new FakeDataEvent("9", c.getTimeInMillis(), 100 + r.nextInt(20), 0));
			}

			c.add(Calendar.MINUTE, 45);
			analyseEvent(new FakeDataEvent("4[0]", c.getTimeInMillis(), 0, 10));
			if (dark) {
				c.add(Calendar.SECOND, 5);
				analyseEvent(new FakeDataEvent("2[0]", c.getTimeInMillis(), 0, 2));
				c.add(Calendar.SECOND, 3);
				analyseEvent(new FakeDataEvent("9", c.getTimeInMillis(), r.nextInt(10) + 5, 0));
			}
		}
	}

	private static class FakeDataEvent implements DataEvent {
		private String type;
		private long timestamp;
		private double val;
		private int dis;

		public FakeDataEvent(String type, long timestamp, double val, int dis) {
			this.type = type;
			this.timestamp = timestamp;
			this.val = val;
			this.dis = dis;
		}

		@Override
		public String getType() {
			return type;
		}

		@Override
		public long getTimeInMillis() {
			return timestamp;
		}

		@Override
		public Calendar getTime() {
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(getTimeInMillis());
			return cal;
		}

		@Override
		public double getValue() {
			return val;
		}

		@Override
		public DataGenerator getGenerator() {
			return null;
		}

		@Override
		public Object getMetaObject() {
			return null;
		}

		@Override
		public int getDiscreteLevels() {
			return dis;
		}

		@Override
		public List<String> getCounterTypes() {
			return Collections.emptyList();
		}

	}

}
