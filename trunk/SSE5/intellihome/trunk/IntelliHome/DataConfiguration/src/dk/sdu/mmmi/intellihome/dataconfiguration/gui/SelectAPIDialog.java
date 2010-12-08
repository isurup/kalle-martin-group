
package dk.sdu.mmmi.intellihome.dataconfiguration.gui;

import dk.sdu.mmmi.intellihome.core.api.API;
import dk.sdu.mmmi.intellihome.core.pipe.Pipe;
import dk.sdu.mmmi.intellihome.dataconfiguration.ConfigurationManagerImpl;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Collection;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;

/**
 *
 * @author jemr
 */
public class SelectAPIDialog extends JPanel {
    private JLabel lblHeader;
    private JComboBox listApis;
	private final Pipe pipe;
	private final Collection<API> apis;

    public SelectAPIDialog(Pipe p, Collection<API> apis) {
		this.pipe = p;
		this.apis = apis;

        initComponents();		
    }

    private void initComponents() {
        Container container = this;
        container.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.BOTH;

		lblHeader = new JLabel("Select implementation for " + pipe.getName());
		Object[] ar = apis.toArray(new Object[apis.size() + 1]);
		ar[ar.length - 1] = ConfigurationManagerImpl.EMPTY_API;
		listApis = new JComboBox(ar);
		listApis.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				return super.getListCellRendererComponent(list, value instanceof API ? ((API)value).getName() : value.toString(), index, isSelected, cellHasFocus);
			}
		});

        gbc.gridx = 0;
        gbc.gridy = 0;
        container.add(lblHeader, gbc);
        gbc.gridy++;
        container.add(listApis, gbc);
    }

	public static API showDialog(Pipe p, Collection<API> apis) {
		SelectAPIDialog config = new SelectAPIDialog(p, apis);

        NotifyDescriptor nd = new NotifyDescriptor(config, "Select implementation", NotifyDescriptor.OK_CANCEL_OPTION, NotifyDescriptor.PLAIN_MESSAGE, null, NotifyDescriptor.OK_OPTION);

        if (DialogDisplayer.getDefault().notify(nd) == NotifyDescriptor.OK_OPTION) {
			Object selected = config.listApis.getSelectedItem();
			return (selected instanceof API) ? (API)selected : null;
        }
		else
			return showDialog(p, apis);
	}
}
