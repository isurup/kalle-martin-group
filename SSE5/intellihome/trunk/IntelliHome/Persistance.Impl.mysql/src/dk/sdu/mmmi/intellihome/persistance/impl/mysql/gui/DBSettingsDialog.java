
package dk.sdu.mmmi.intellihome.persistance.impl.mysql.gui;

import dk.sdu.mmmi.intellihome.persistance.impl.mysql.DBManager;
import dk.sdu.mmmi.intellihome.persistance.impl.mysql.DBSettings;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle;

/**
 *
 * @author jemr
 */
public class DBSettingsDialog extends JPanel {
    private JTextField txtProvider;
    private JTextField txtDriver;
    private JTextField txtHost;
    private JTextField txtPort;
    private JTextField txtScheme;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private final ResourceBundle bundle;

    public DBSettingsDialog() {
        bundle = NbBundle.getBundle(DBSettingsDialog.class);

        initComponents();		
    }

    private void initComponents() {
        Container container = this;
        container.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.anchor = GridBagConstraints.EAST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        container.add(new JLabel(bundle.getString("DLG_Settings.label.Driver")), gbc);
        gbc.gridy++;
        container.add(new JLabel(bundle.getString("DLG_Settings.label.Provider")), gbc);
        gbc.gridy++;
        container.add(new JLabel(bundle.getString("DLG_Settings.label.Host")), gbc);
        gbc.gridy++;
        container.add(new JLabel(bundle.getString("DLG_Settings.label.Port")), gbc);
        gbc.gridy++;
        container.add(new JLabel(bundle.getString("DLG_Settings.label.Scheme")), gbc);
        gbc.gridy++;
        container.add(new JLabel(bundle.getString("DLG_Settings.label.Username")), gbc);
        gbc.gridy++;
        container.add(new JLabel(bundle.getString("DLG_Settings.label.Password")), gbc);

        txtProvider = new JTextField(DBSettings.getProvider()); txtProvider.setEditable(false);
        txtDriver = new JTextField(DBSettings.getDriver()); txtDriver.setEditable(false);
        txtHost = new JTextField(DBSettings.getHost());
        txtPort = new JTextField(Integer.toString(DBSettings.getPort()));
        txtScheme = new JTextField(DBSettings.getScheme());
        txtUsername = new JTextField(DBSettings.getUsername());
        txtPassword = new JPasswordField(DBSettings.getPassword());
		txtPassword.setPreferredSize(new Dimension(300, txtPassword.getPreferredSize().height));
		
        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1;

        container.add(txtDriver, gbc);
        gbc.gridy++;
        container.add(txtProvider, gbc);
        gbc.gridy++;
        container.add(txtHost, gbc);
        gbc.gridy++;
        container.add(txtPort, gbc);
        gbc.gridy++;
        container.add(txtScheme, gbc);
        gbc.gridy++;
        container.add(txtUsername, gbc);
        gbc.gridy++;
        container.add(txtPassword, gbc);
    }

	public static void showDialog() {
		showDialog(null, null);
	}
	public static void showDialog(String message, String title) {
		DBSettingsDialog config = new DBSettingsDialog();

		if (message != null)
			JOptionPane.showMessageDialog(config, message, title, JOptionPane.ERROR_MESSAGE);

        NotifyDescriptor nd = new NotifyDescriptor(config, config.bundle.getString("DLG_Settings.Title"), NotifyDescriptor.OK_CANCEL_OPTION, NotifyDescriptor.PLAIN_MESSAGE, null, NotifyDescriptor.OK_OPTION);

        if (DialogDisplayer.getDefault().notify(nd) == NotifyDescriptor.OK_OPTION) {

			DBSettings.setProvider(config.txtProvider.getText());
			DBSettings.setDriver(config.txtDriver.getText());
			DBSettings.setHost(config.txtHost.getText());
			DBSettings.setScheme(config.txtScheme.getText());
			DBSettings.setUsername(config.txtUsername.getText());
			DBSettings.setPassword(new String(config.txtPassword.getPassword()));

			try {
				int port = Integer.parseInt(config.txtPort.getText());
				if (port < 1 || port > 65535)
					throw new NumberFormatException();
				DBSettings.setPort(port);
				DBManager.getInstance().closeConnection();
			}
			catch (SQLException ex) {
				Exceptions.printStackTrace(ex);
			}
			catch (NumberFormatException e) {
				showDialog(config.bundle.getString("DLG_Settings.error.PortNaN"), config.bundle.getString("DLG_Settings.error.PortNaN.Title"));
			}
        }
	}
}
