package dk.sdu.mmmi.intellihome.synthetic.simple;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class CreateSyntheticDeviceAction implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		CreateSyntheticDeviceDialog.showDialog();
	}
}
