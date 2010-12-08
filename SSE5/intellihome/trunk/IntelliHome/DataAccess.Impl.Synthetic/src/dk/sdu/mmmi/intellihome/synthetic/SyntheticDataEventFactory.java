
package dk.sdu.mmmi.intellihome.synthetic;

import dk.sdu.mmmi.intellihome.dataaccess.DataEvent;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author jemr
 */
public class SyntheticDataEventFactory implements dk.sdu.mmmi.intellihome.dataaccess.DataGenerator {
	private static final SyntheticDataEventFactory instance = new SyntheticDataEventFactory();
	public static SyntheticDataEventFactory getInstance() {
		return instance;
	}
	private SyntheticDataEventFactory() {
	}

	public DataEvent newEvent(String eventType, long timestamp, double value) {
		return new SyntheticDataEvent(eventType, timestamp, value);
	}

	private static class SyntheticDataEvent implements DataEvent {

		private final String eventType;
		private final long timestamp;
		private final double value;

		public SyntheticDataEvent(String eventType, long timestamp, double value) {
			this.eventType = eventType;
			this.timestamp = timestamp;
			this.value = value;
		}

		public String getType() {
			return eventType;
		}

		public long getTimeInMillis() {
			return timestamp;
		}

		public Calendar getTime() {
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(timestamp);
			return cal;
		}

		public double getValue() {
			return value;
		}

		public dk.sdu.mmmi.intellihome.dataaccess.DataGenerator getGenerator() {
			return getInstance();
		}

		public Object getMetaObject() {
			return null;
		}

		public int getDiscreteLevels() {
			return 0;
		}

		public List<String> getCounterTypes() {
			// XXX TODO
			throw new UnsupportedOperationException("Not supported yet.");
		}

	}
}
