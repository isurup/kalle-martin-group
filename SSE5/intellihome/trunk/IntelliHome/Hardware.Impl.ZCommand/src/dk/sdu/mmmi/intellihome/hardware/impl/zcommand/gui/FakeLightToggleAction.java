package dk.sdu.mmmi.intellihome.hardware.impl.zcommand.gui;

import _1._0._0._127.ZwaveDeviceMultiSensor;
import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.hardware.impl.zcommand.ZCommandDataEventFactory;
import dk.sdu.mmmi.intellihome.hardware.impl.zcommand.ZCommandHardware;
import dk.sdu.mmmi.intellihome.hardware.impl.zcommand.ZCommandPoller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public final class FakeLightToggleAction implements ActionListener {
	private int level = 0;

	public void actionPerformed(ActionEvent e) {
		level++;
		if (level > 2)
			level = 0;
		
		ZwaveDeviceMultiSensor lightOn = new ZwaveDeviceMultiSensor();
		lightOn.setLevel(10 + level * 100);
		lightOn.setLevelTimeStamp(Calendar.getInstance());
		lightOn.setNodeID("9");

		DataEvent event = ZCommandDataEventFactory.getInstance().createEvent(lightOn);
		System.out.println("The light is now " + lightOn.getLevel());
		ZCommandHardware hardware = ZCommandPoller.getInstance().getHardware();
		if (hardware != null)
			hardware.zcommandIncomingEvent(event);
	}
}
