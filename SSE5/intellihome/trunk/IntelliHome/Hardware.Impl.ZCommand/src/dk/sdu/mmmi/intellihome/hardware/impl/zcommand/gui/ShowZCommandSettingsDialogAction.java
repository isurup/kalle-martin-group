package dk.sdu.mmmi.intellihome.hardware.impl.zcommand.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class ShowZCommandSettingsDialogAction implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        ZCommandSettingsDialog.showDialog();
    }
}
