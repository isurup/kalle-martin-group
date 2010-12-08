
package dk.sdu.mmmi.intellihome.execution.impl.standard;

import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.core.dataaccess.DataGenerator;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * This will be the base for a helper class to help identify the correct
 * eventTypes based on the device and dataPoint, and the counterEventType.
 *
 * @author jemr
 */
class ExecutorDataEventFactory implements DataGenerator {
	private static final ExecutorDataEventFactory instance = new ExecutorDataEventFactory();
	public static final ExecutorDataEventFactory getInstance() {
		return instance;
	}
	private ExecutorDataEventFactory() {
	}

	public DataEvent newEvent(String eventType, long timestamp, double value) {
		return new ExecutorDataEvent(eventType, timestamp, value);
	}

	private static class ExecutorDataEvent implements DataEvent {

		private final String eventType;
		private final long timestamp;
		private final double value;

		public ExecutorDataEvent(String eventType, long timestamp, double value) {
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
			return 2;
		}

		public List<String> getCounterTypes() {
			// XXX TODO
			return Collections.emptyList();
			//throw new UnsupportedOperationException("Not supported yet.");
		}

	}
}
