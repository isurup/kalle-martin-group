
package dk.sdu.mmmi.intellihome.persistance.impl.mysql;

import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.core.dataaccess.DataGenerator;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author jemr
 */
class DBDataEventFactory implements DataGenerator {
	private static final DBDataEventFactory instance = new DBDataEventFactory();
	public static DBDataEventFactory getInstance() {
		return instance;
	}

	private DBDataEventFactory() {
	}

	public DataEvent newEvent(String eventType, long timestamp, double value) {
		return new DBDataEvent(eventType, timestamp, value);
	}

	private static class DBDataEvent implements DataEvent {

		private final String eventType;
		private final long timestamp;
		private final double value;

		public DBDataEvent(String eventType, long timestamp, double value) {
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

		public DataGenerator getGenerator() {
			return getInstance();
		}

		public Object getMetaObject() {
			return null;
		}

		public int getDiscreteLevels() {
			// XXX TODO
			throw new UnsupportedOperationException("Not supported yet.");
		}

		public List<String> getCounterTypes() {
			// XXX TODO
			throw new UnsupportedOperationException("Not supported yet.");
		}

	}
}
