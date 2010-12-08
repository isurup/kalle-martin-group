package dk.sdu.mmmi.intellihome.hardware.impl.zcommand;

import _1._0._0._127.ZwaveDevice;
import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.hardware.Hardware;
import dk.sdu.mmmi.intellihome.core.pipe.Pipe;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
@ServiceProvider(service=Hardware.class)
public class ZCommandHardware implements Hardware {
	private Pipe pipe;
    private HashMap<String, DataEvent> cache = new HashMap<String, DataEvent>();

	@Override
	public String getResourceId(String eventId) {
		return ZCommandDeviceInfoManager.getInstance().getDeviceFromEventType(eventId);
	}

	@Override
	public Map<String, Object> getResourceInfo(String resourceId) {
		try {
			ZwaveDevice device = ZCommandPoller.getInstance().getZCommandControlDevices().getDevice(resourceId);
			if (device != null) {
				Map<String, Object> result = new HashMap<String, Object>();
				for (Method m : ZwaveDevice.class.getMethods()) {
					try {
						String methodName = m.getName();
						if (methodName.startsWith("get") && m.getParameterTypes().length == 0)
							result.put(methodName.substring(3), m.invoke(device));
					}
					catch (Exception ex) {
						Logger.getLogger(ZCommandHardware.class.getName()).log(Level.SEVERE, null, ex);
					}
				}

				return result;
			}
		}
		catch (RemoteException ex) {
			Logger.getLogger(ZCommandHardware.class.getName()).log(Level.SEVERE, null, ex);
		}
		return Collections.emptyMap();

	}

	@Override
	public void setValue(String resourceId, double value) {
		try {
			ZCommandPoller.getInstance().getZCommandControlDevices().setDeviceLevel(resourceId, (int)value);
		}
		catch (RemoteException ex) {
			Logger.getLogger(ZCommandHardware.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void fireEvent(String eventId, double defaultValue) {
		String resourceId = getResourceId(eventId);
		double value = ZCommandDeviceInfoManager.getInstance().getValueFromEventType(eventId, defaultValue);

		setValue(resourceId, value);
	}

	@Override
	public Set<String> getEventTypes() {
		return Collections.unmodifiableSet(cache.keySet());
	}

	@Override
	public boolean incomingEvent(DataEvent event) {
		return true;
	}

	public void zcommandIncomingEvent(final DataEvent event) {
		String resId = getResourceId(event.getType());
		DataEvent cachedEvent = cache.get(resId);
		cache.put(resId, event);

		// If no data point was previously cached, then don't forward this event
		if (cachedEvent != null) {
			// If this is a discrete resource, and it's trying to fire the same
			// event type again, ignore it.
			if (event.getDiscreteLevels() > 0 && event.getType().equals(cachedEvent.getType()))
				return;

			System.out.printf("[ZCommand] [%tT] Event: %s - %f\n", System.currentTimeMillis(), event.getType(), event.getValue());

			if (pipe != null) {
				new Thread() {
					public void run() {
						pipe.incomingEvent(event);
					}
				}.start();
			}
		}
	}

	@Override
	public List<DataEvent> getEvents(String eventType, Calendar startTime, Calendar endTime) {
		DataEvent data = cache.get(eventType);

		if (data == null || data.getTimeInMillis() > endTime.getTimeInMillis() || data.getTimeInMillis() < startTime.getTimeInMillis())
			return Collections.emptyList();

		return Collections.singletonList(data);
	}

	public String getName() {
		return "ZCommand Name";
	}

	public void initialize(Pipe pipe) {
		cleanup();
		this.pipe = pipe;
		ZCommandPoller.getInstance().startPolling(this);
	}

	public void cleanup() {
		ZCommandPoller.getInstance().stopPolling();
		this.pipe = null;
	}
}
