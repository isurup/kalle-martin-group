
package dk.sdu.mmmi.intellihome.synthetic.simple;

import dk.sdu.mmmi.intellihome.datagraphs.graphs.AbstractGraph;
import dk.sdu.mmmi.intellihome.datagraphs.graphs.SquareGraph;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ResourceBundle;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;

/**
 *
 * @author jemr
 */
class CreateSyntheticDeviceDialog extends JPanel {
	private static final class ComboValue {
		final String name;
		final long value;
		final long resolution;
		public ComboValue(String name, long value, long resolution) {
			this.name = name;
			this.value = value;
			this.resolution = resolution;
		}

		@Override
		public String toString() {
			return name;
		}
	}
	
    private final ResourceBundle bundle = NbBundle.getBundle(CreateSyntheticDeviceDialog.class);

	private final SimpleSyntheticDataSource dataSource;

	private final JLabel labelName = new JLabel(" Name: ");
	private final JTextField textName = new JTextField();

	private final JPanel panelUnits = new JPanel();
	private final JPanel panelGeneratorConfig = new JPanel(new BorderLayout());
	
	private final AbstractGraph panelGraph;

	private final DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
	private final JComboBox comboUnits = new JComboBox(comboModel);
	private final JButton buttonAddUnit = new JButton();
	private final JButton buttonRemoveUnit = new JButton();
	private final JComboBox comboGraphTime = new JComboBox(new ComboValue[] {
			new ComboValue("1 hour", 60 * 60 * 1000L, 5000L),
			new ComboValue("4 hours", 4 * 60 * 60 * 1000L, 5000L),
			new ComboValue("12 hours", 12 * 60 * 60 * 1000L, 5000L),
			new ComboValue("24 hours", 24 * 60 * 60 * 1000L, 15000L),
			new ComboValue("4 days", 4 * 24 * 60 * 60 * 1000L, 60000L),
			new ComboValue("1 week", 7 * 24 * 60 * 60 * 1000L, 60000L),
			new ComboValue("4 weeks", 4 * 7 * 24 * 60 * 60 * 1000L, 300000L),
		});

	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

    public CreateSyntheticDeviceDialog(SimpleSyntheticDataSource dataSource) {
		this.dataSource = dataSource;
		panelGraph = new SquareGraph.Factory().newInstance(dataSource.getEventType(), dataSource);

		initComponents();
    }

	/**
	 * Initializes the components of the dialog
	 */
	private void initComponents() {
		initGeneralComponents();
		initUnitComponents();

		layoutUnitComponents();
		layoutGeneralComponents();

		panelGeneratorConfig.add(tabbedPane, BorderLayout.CENTER);
		panelGeneratorConfig.setPreferredSize(new Dimension(600, 300));
	}

	/**
	 * Initializes the general components of the dialog
	 */
	private void initGeneralComponents() {
		panelGraph.setPreferredSize(new Dimension(1000, 300));
	}

	/**
	 * Initializes the unit components of the dialog
	 */
	private void initUnitComponents() {

		comboModel.removeAllElements();
		for (DataGeneratorFactory factory: Lookup.getDefault().lookupAll(DataGeneratorFactory.class))
			comboModel.addElement(factory);

		comboUnits.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				return super.getListCellRendererComponent(list, ((DataGeneratorFactory)value).getName(), index, isSelected, cellHasFocus);
			}
		});

		final PropertyChangeListener changeListener = new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				refreshGraph();
			}
		};

		buttonAddUnit.setText("Add");
		buttonAddUnit.setPreferredSize(new Dimension(75, buttonAddUnit.getPreferredSize().height));
		buttonAddUnit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DataGenerator generator = ((DataGeneratorFactory)comboUnits.getSelectedItem()).newInstance();
					dataSource.addDataGenerator(generator);
					tabbedPane.addTab(generator.getClass().getSimpleName(), generator.getConfigurationControls());
					generator.getConfigurationControls().addPropertyChangeListener(DataGenerator.property, changeListener);
					refreshGraph();
				}
				catch (Exception ex) {
					Exceptions.printStackTrace(ex);
				}
			}
		});
		buttonRemoveUnit.setText("Remove");
		buttonRemoveUnit.setPreferredSize(new Dimension(75, buttonRemoveUnit.getPreferredSize().height));
		buttonRemoveUnit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.getSelectedComponent().removePropertyChangeListener(changeListener);
				dataSource.removeDataGenerator(tabbedPane.getSelectedIndex());
				tabbedPane.remove(tabbedPane.getSelectedIndex());
				refreshGraph();
			}
		});

		comboGraphTime.setPreferredSize(new Dimension(120, comboGraphTime.getPreferredSize().height));
		comboGraphTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshGraph();
			}
		});
	}

	/**
	 * Lays out the unit components of the dialog
	 */
	private void layoutUnitComponents() {
		panelUnits.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(3, 3, 3, 3);
		gbc.fill = GridBagConstraints.BOTH;

		gbc.gridx = 1; gbc.gridy = 1; gbc.weighty = 0; gbc.weightx = 1; gbc.gridwidth = 1;
		panelUnits.add(comboUnits, gbc);
		gbc.gridx = 2; gbc.gridy = 1; gbc.weighty = 0; gbc.weightx = 0; gbc.gridwidth = 1;
		panelUnits.add(buttonAddUnit, gbc);
		gbc.gridx = 3; gbc.gridy = 1; gbc.weighty = 0; gbc.weightx = 0; gbc.gridwidth = 1;
		panelUnits.add(buttonRemoveUnit, gbc);
		gbc.gridx = 4; gbc.gridy = 1; gbc.weighty = 0; gbc.weightx = 0; gbc.gridwidth = 1;
		panelUnits.add(comboGraphTime, gbc);
	}

	/**
	 * Lays out the general components of the dialog
	 */
	private void layoutGeneralComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(3, 3, 3, 3);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 0; gbc.weighty = 0; gbc.gridwidth = 1; gbc.gridheight = 1;
		add(labelName, gbc);
		gbc.gridx = 2; gbc.gridy = 1; gbc.weightx = 1; gbc.weighty = 0; gbc.gridwidth = 1; gbc.gridheight = 1;
		add(textName, gbc);
		gbc.gridx = 1; gbc.gridy = 2; gbc.weightx = 0; gbc.weighty = 0; gbc.gridwidth = 2; gbc.gridheight = 1;
		add(panelUnits, gbc);
		gbc.gridx = 1; gbc.gridy = 3; gbc.weightx = 0; gbc.weighty = 0; gbc.gridwidth = 2; gbc.gridheight = 1;
		add(panelGeneratorConfig, gbc);
		gbc.gridx = 1; gbc.gridy = 4; gbc.weightx = 0; gbc.weighty = 1; gbc.gridwidth = 2; gbc.gridheight = 1;
		add(panelGraph, gbc);
	}

	private void refreshGraph() {
		long start = 0;
		long end = ((ComboValue)comboGraphTime.getSelectedItem()).value;
		dataSource.setResolution(((ComboValue)comboGraphTime.getSelectedItem()).resolution);
		panelGraph.updateTime(start, end);
		panelGraph.repaint();
	}

	static void showDialog() {
		SimpleSyntheticDataSource dataSource = SimpleSyntheticDeviceManager.getInstance().newDataSource();
		CreateSyntheticDeviceDialog config = new CreateSyntheticDeviceDialog(dataSource);

        NotifyDescriptor nd = new NotifyDescriptor(config, config.bundle.getString("DLG_Settings.Title"), NotifyDescriptor.OK_CANCEL_OPTION, NotifyDescriptor.PLAIN_MESSAGE, null, NotifyDescriptor.OK_OPTION);

        if (DialogDisplayer.getDefault().notify(nd) == NotifyDescriptor.OK_OPTION) {
			SimpleSyntheticDeviceManager.getInstance().addConfiguration(dataSource);
        }
		else {
			SimpleSyntheticDeviceManager.getInstance().resetConfiguration(dataSource);
		}
	}

}

