
package dk.sdu.mmmi.intellihome.hardware.impl.zcommand;

import _1._0._0._127.ZwaveDevice;
import _1._0._0._127.ZwaveDeviceController;
import _1._0._0._127.ZwaveDeviceMultiSwitch;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author jemr
 */
public class ZCommandPoller {
	private static final ZCommandPoller instance = new ZCommandPoller();
	public static ZCommandPoller getInstance() {
		return instance;
	}

	private static class InternalPoller extends TimerTask {
		private ZCommandControlDevices zcommandControl = null;
		private final ZCommandHardware hardware;
		private HashSet<String> querySet = new HashSet<String>();
		private HashMap<String, Double> multiMap = new HashMap<String, Double>();

		private InternalPoller(ZCommandHardware hardware) {
			this.hardware = hardware;
		}

		private void init() {
			try {
				zcommandControl = new ZCommandControlDevices(ZCommandSettings.getHost(), ZCommandSettings.getPort(), ZCommandSettings.getUsername(), ZCommandSettings.getPassword());
				if (!zcommandControl.testConnection()) {
					zcommandControl = null;
					System.out.println("[FAILED] Error connection to zcommand");
				}
				else
					System.out.println("[SUCCESS] Connected to zcommand!");

			}
			catch (Exception e) {
				zcommandControl = null;
				System.out.println("Connection to zcommand failed");
			}
		}


		public void run() {
			// If the control unit is null, try to reinit it
			if (zcommandControl == null) {
				init();
				return;
			}

			try {
				for (ZwaveDevice device: zcommandControl.getDevices()) {
					// Ignore controller pulses
					if (device instanceof ZwaveDeviceController)
						continue;

					// Some MultiSwitch devices send intermediate values as well, so
					// keep polling the value until it stabilizes
					if (device instanceof ZwaveDeviceMultiSwitch) {
						Double val = multiMap.get(device.getNodeID());
						if (val == null)
							multiMap.put(device.getNodeID(), device.getLevel());
						else if (val.doubleValue() != device.getLevel()) {
							zcommandControl.queryDevice(device.getNodeID());
							multiMap.put(device.getNodeID(), device.getLevel());
							continue;
						}
					}

					// Hack - some of the sensors sends value 32 when they are changing state
					// so if this value is seen, add that node query the device and wait for
					// next event from it. Also eat the event so we don't get two in a row
					if (device.getLevel() == 32 && !querySet.contains(device.getNodeID())) {
						zcommandControl.queryDevice(device.getNodeID());
						querySet.add(device.getNodeID());
						continue;
					}
					else
						querySet.remove(device.getNodeID());
					hardware.zcommandIncomingEvent(ZCommandDataEventFactory.getInstance().createEvent(device));
				}
			}
			catch (Exception ex) {
				// Ignore errors, there will be a lot of "Software caused connection abort: recv failed"
				// Since the .net web server can be a bit weird with rapid requests
				//System.out.println("[ERROR] ZCommand failed with " + ex.getLocalizedMessage());
				//ex.printStackTrace();
				ex.printStackTrace();
			}
		}
	}

	private Timer timer;
	private InternalPoller poller;

	private ZCommandPoller() {
	}

	private ZCommandHardware hardware;
	public ZCommandHardware getHardware() {
		return hardware;
	}
	
	public void startPolling(ZCommandHardware hardware) {
		stopPolling();
		
		timer = new Timer(true);
		poller = new InternalPoller(hardware);
		timer.schedule(poller, 1000, 1000);
		this.hardware = hardware;
	}

	public void stopPolling() {
		if (timer != null) {
			timer.cancel();
			timer = null;
			poller = null;
			hardware = null;
		}
	}

	void reinit() {
		if (poller != null) {
			ZCommandHardware hardware = poller.hardware;
			stopPolling();
			startPolling(hardware);
		}
	}

	public ZCommandControlDevices getZCommandControlDevices() {
		return poller != null ? poller.zcommandControl : null;
	}
}
