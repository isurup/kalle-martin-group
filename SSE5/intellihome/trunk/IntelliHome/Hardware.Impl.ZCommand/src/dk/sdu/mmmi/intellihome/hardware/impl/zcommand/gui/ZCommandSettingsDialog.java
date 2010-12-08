package dk.sdu.mmmi.intellihome.hardware.impl.zcommand.gui;

import dk.sdu.mmmi.intellihome.hardware.impl.zcommand.ZCommandSettings;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ResourceBundle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.util.NbBundle;

/**
 *
 * @author jemr
 */
public class ZCommandSettingsDialog extends JPanel {
    private JTextField txtHost;
    private JTextField txtPort;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private final ResourceBundle bundle;

    public ZCommandSettingsDialog() {
        bundle = NbBundle.getBundle(ZCommandSettingsDialog.class);
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.anchor = GridBagConstraints.EAST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel(bundle.getString("DLG_Settings.label.Host")), gbc);
        gbc.gridy++;
        add(new JLabel(bundle.getString("DLG_Settings.label.Port")), gbc);
        gbc.gridy++;
        add(new JLabel(bundle.getString("DLG_Settings.label.Username")), gbc);
        gbc.gridy++;
        add(new JLabel(bundle.getString("DLG_Settings.label.Password")), gbc);

        txtHost = new JTextField(ZCommandSettings.getHost());
        txtPort = new JTextField(Integer.toString(ZCommandSettings.getPort()));
        txtUsername = new JTextField(ZCommandSettings.getUsername());
        txtPassword = new JPasswordField(ZCommandSettings.getPassword());
		txtPassword.setPreferredSize(new Dimension(300, txtPassword.getPreferredSize().height));

        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1;

        add(txtHost, gbc);
        gbc.gridy++;
        add(txtPort, gbc);
        gbc.gridy++;
        add(txtUsername, gbc);
        gbc.gridy++;
        add(txtPassword, gbc);
    }

	public static void showDialog() {
		ZCommandSettingsDialog config = new ZCommandSettingsDialog();

        NotifyDescriptor nd = new NotifyDescriptor(config, config.bundle.getString("DLG_Settings.Title"), NotifyDescriptor.OK_CANCEL_OPTION, NotifyDescriptor.PLAIN_MESSAGE, null, NotifyDescriptor.OK_OPTION);

        if (DialogDisplayer.getDefault().notify(nd) == NotifyDescriptor.OK_OPTION) {

			ZCommandSettings.setHost(config.txtHost.getText());
			ZCommandSettings.setUsername(config.txtUsername.getText());
			ZCommandSettings.setPassword(new String(config.txtPassword.getPassword()));

			try {
				int port = Integer.parseInt(config.txtPort.getText());
				if (port < 1 || port > 65535)
					throw new NumberFormatException();
				ZCommandSettings.setPort(port);
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(config, config.bundle.getString("DLG_Settings.error.PortNaN"), config.bundle.getString("DLG_Settings.error.PortNaN.Title"), JOptionPane.ERROR_MESSAGE);
				showDialog();
			}
        }
	}

}
