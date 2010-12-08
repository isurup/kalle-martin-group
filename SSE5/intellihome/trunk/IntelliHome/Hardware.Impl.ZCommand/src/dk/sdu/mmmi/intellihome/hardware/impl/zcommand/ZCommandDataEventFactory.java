
package dk.sdu.mmmi.intellihome.hardware.impl.zcommand;

import _1._0._0._127.ZwaveDevice;
import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.core.dataaccess.DataGenerator;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jemr
 */
public class ZCommandDataEventFactory implements DataGenerator {
	private static final ZCommandDataEventFactory instance = new ZCommandDataEventFactory();
	public static ZCommandDataEventFactory getInstance() {
		return instance;
	}

	public DataEvent createEvent(ZwaveDevice device) {
		return new ZCommandDataEvent(device);
	}

	private static class ZCommandDataEvent implements DataEvent {
		private final String eventType;
		private final ZwaveDevice device;
		private final long timeInMillis;
		private final int discrete;

		private ZCommandDataEvent(ZwaveDevice device) {
			this.eventType = ZCommandDeviceInfoManager.getInstance().findEventTypeFromDevice(device);
			this.discrete = ZCommandDeviceInfoManager.getInstance().findDiscreteLevelsFromDevice(device);
			this.device = device;
			this.timeInMillis = device.getLevelTimeStamp().getTimeInMillis();
		}

		public String getType() {
			return eventType;
		}

		public long getTimeInMillis() {
			return timeInMillis;
		}

		public Calendar getTime() {
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(timeInMillis);
			return cal;
		}

		public double getValue() {
			return device.getLevel();
		}

		public DataGenerator getGenerator() {
			return ZCommandDataEventFactory.getInstance();
		}

		public Map<String, Object> getMetaData() {
			return Collections.emptyMap();
		}

		public int getDiscreteLevels() {
			return discrete;
		}

		public List<String> getCounterTypes() {
			return ZCommandDeviceInfoManager.getInstance().getCounterTypes(getType());
		}

		@Override
		public String toString() {
			try {
				return String.format("DataEvent{%s [%tT]}", getType(), getTimeInMillis());
			}
			catch (Exception e) {
				return String.format("DataEvent{%s}", getType());
			}
		}
	}
}
