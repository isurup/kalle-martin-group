package dk.sdu.mmmi.intellihome.persistance.impl.mysql.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class ShowDBSettingsDialogAction implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        DBSettingsDialog.showDialog();
    }
}
