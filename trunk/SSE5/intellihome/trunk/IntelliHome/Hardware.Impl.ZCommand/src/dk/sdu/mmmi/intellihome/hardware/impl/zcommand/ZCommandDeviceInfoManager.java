
package dk.sdu.mmmi.intellihome.hardware.impl.zcommand;

import _1._0._0._127.ZwaveDevice;
import _1._0._0._127.ZwaveDeviceBinarySensor;
import _1._0._0._127.ZwaveDeviceBinarySwitch;
import _1._0._0._127.ZwaveDeviceMultiSensor;
import _1._0._0._127.ZwaveDeviceMultiSwitch;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openide.util.Exceptions;
import org.openide.util.NbPreferences;

/**
 *
 * @author jemr
 */
public class ZCommandDeviceInfoManager {
	private static final ZCommandDeviceInfoManager instance = new ZCommandDeviceInfoManager();
	public static final ZCommandDeviceInfoManager getInstance() {
		return instance;
	}

	public static class DeviceInfo implements Serializable {
		private final String deviceId;
		private final int discreteLevels;
		private final int maxValue;

		public DeviceInfo(String deviceId, int discreteLevels, int maxValue) {
			this.deviceId = deviceId;
			this.discreteLevels = discreteLevels;
			this.maxValue = maxValue;
		}

		public String getDeviceId() {
			return deviceId;
		}

		public int getDiscreteLevels() {
			return discreteLevels;
		}

		public int getMaxValue() {
			return maxValue;
		}
	}
	
	private final HashMap<String, DeviceInfo> deviceInfo = new HashMap<String, DeviceInfo>();
	private final Preferences preferences = NbPreferences.forModule(ZCommandDeviceInfoManager.class);

	private ZCommandDeviceInfoManager() {
		try {
			for (String deviceId : preferences.keys()) {
				if (deviceId.startsWith("deviceInfo.")) {
					String[] args = preferences.get(deviceId, "0;0").split(";");
					deviceInfo.put(deviceId.substring(11), new DeviceInfo(deviceId.substring(11), Integer.parseInt(args[0]), Integer.parseInt(args[1])));
				}
			}
		}
		catch (BackingStoreException ex) {
			Exceptions.printStackTrace(ex);
		}
	}

	private DeviceInfo createDefaultInfo(ZwaveDevice device) {
		if (device instanceof ZwaveDeviceBinarySwitch) {
			return saveDeviceInfo(device.getNodeID(), 2, 255);
		}
		else if (device instanceof ZwaveDeviceMultiSwitch) {
			return saveDeviceInfo(device.getNodeID(), 10, 99);
		}
		else
			return saveDeviceInfo(device.getNodeID(), 0, 255);
	}

	private DeviceInfo saveDeviceInfo(String deviceId, int discreteLevel, int maxValue) {
		DeviceInfo result = new DeviceInfo(deviceId, discreteLevel, maxValue);
		deviceInfo.put(deviceId, result);
		preferences.put("deviceInfo." + deviceId, discreteLevel + ";" + maxValue);
		return result;
	}

	public DeviceInfo getInfo(String deviceId) {
		return deviceInfo.get(deviceId);
	}

	private String getEventString(String deviceId, int level) {
		return String.format("%s[%d]", deviceId, level);
	}
	
	private final Pattern pattern = Pattern.compile("(.*)\\[(\\d+)\\]");

	public String getDeviceFromEventType(String eventType) {
		Matcher m = pattern.matcher(eventType);
		return m.matches() ? m.group(1) : eventType;
	}

	public int getLevelFromEventType(String eventType) {
		Matcher m = pattern.matcher(eventType);
		return m.matches() ? Integer.parseInt(m.group(2)) : -1;
	}

	public double getValueFromEventType(String eventType, double defaultValue) {
		String deviceId = getDeviceFromEventType(eventType);
		int level = getLevelFromEventType(eventType);
		DeviceInfo info = ZCommandDeviceInfoManager.getInstance().getInfo(deviceId);
		return (level > -1 && info != null) ?
			(double)level * (double)info.getMaxValue() / (info.getDiscreteLevels() - 1.0) :
			defaultValue;
	}


	public List<String> getCounterTypes(String eventType) {
		String deviceId = getDeviceFromEventType(eventType);
		int level = getLevelFromEventType(eventType);
		if (level > -1) {
			DeviceInfo info = ZCommandDeviceInfoManager.getInstance().getInfo(deviceId);
			if (info == null)
				return Collections.emptyList();
			else {
				List<String> result = new ArrayList<String>();
				for (int i = 0; i < info.getDiscreteLevels(); i++) {
					if (i != level)
						result.add(getEventString(info.getDeviceId(), i));
				}
				return result;
			}
		}
		else
			return Collections.emptyList();
	}

	public DeviceInfo getInfo(ZwaveDevice device) {
		DeviceInfo info = getInfo(device.getNodeID());
		if (info == null)
			info = createDefaultInfo(device);
		return info;
	}

	public String findEventTypeFromDevice(ZwaveDevice device) {
		DeviceInfo info = getInfo(device);
		if (info.getDiscreteLevels() == 0)
			return info.getDeviceId();
		else {
			int level = (int)Math.round(device.getLevel() * (info.getDiscreteLevels() - 1.0) / (double)info.getMaxValue());
			return getEventString(info.getDeviceId(), level);
		}
	}

	public int findDiscreteLevelsFromDevice(ZwaveDevice device) {
		return getInfo(device).getDiscreteLevels();
	}

	public int findDiscreteLevelsFromDevice(String deviceId) {
		DeviceInfo info = getInfo(deviceId);
		return (info == null) ? 0 : info.getDiscreteLevels();
	}
}
