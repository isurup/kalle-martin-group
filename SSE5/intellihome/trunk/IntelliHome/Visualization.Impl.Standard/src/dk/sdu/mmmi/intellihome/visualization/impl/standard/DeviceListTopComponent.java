package dk.sdu.mmmi.intellihome.visualization.impl.standard;

import dk.sdu.mmmi.intellihome.visualization.impl.standard.graphs.GraphFactory;
import dk.sdu.mmmi.intellihome.core.pipe.Pipe;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.util.Lookup;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//dk.sdu.mmmi.intellihome.visualization.impl.standard//DeviceList//EN",
autostore = false)
public final class DeviceListTopComponent extends TopComponent {
	private static DeviceListTopComponent instance;
	private static final String PREFERRED_ID = "DeviceListTopComponent";

	private static class EventTypeListModel extends AbstractListModel {

		private List<String> eventTypes = new ArrayList<String>();

		public int getSize() {
			return eventTypes.size();
		}

		public Object getElementAt(int index) {
			return eventTypes.get(index);
		}

		public void addEventType(String eventType) {
			if (!eventTypes.contains(eventType)) {
				eventTypes.add(eventType);
				fireIntervalAdded(this, eventTypes.size() - 1, eventTypes.size() - 1);
			}
		}

		public void setEventTypes(Collection<String> newEventTypes) {
			int oldSize = eventTypes.size();
			eventTypes.clear();
			eventTypes.addAll(newEventTypes);

			if (eventTypes.size() < oldSize)
				fireIntervalRemoved(this, eventTypes.size(), oldSize - 1);
			if (eventTypes.size() > oldSize)
				fireIntervalAdded(this, oldSize, eventTypes.size() - 1);
			if (eventTypes.size() > 0 && oldSize > 0)
				fireContentsChanged(this, 0, Math.min(oldSize, eventTypes.size()) - 1);
		}
	}

	private EventTypeListModel listModel = new EventTypeListModel();
    private JList eventTypeList;

	public DeviceListTopComponent() {
		initComponents();
		setName(NbBundle.getMessage(DeviceListTopComponent.class, "CTL_DeviceListTopComponent"));
		setToolTipText(NbBundle.getMessage(DeviceListTopComponent.class, "HINT_DeviceListTopComponent"));
//        setIcon(ImageUtilities.loadImage(ICON_PATH, true));
		putClientProperty(TopComponent.PROP_CLOSING_DISABLED, Boolean.TRUE);
		putClientProperty(TopComponent.PROP_DRAGGING_DISABLED, Boolean.TRUE);
		putClientProperty(TopComponent.PROP_MAXIMIZATION_DISABLED, Boolean.TRUE);
		putClientProperty(TopComponent.PROP_UNDOCKING_DISABLED, Boolean.TRUE);
	}

    private void initComponents() {
        eventTypeList = new JList(listModel);
		eventTypeList.setCellRenderer(new DeviceListCellRenderer());
        JScrollPane scrollPane = new JScrollPane(eventTypeList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		final JPopupMenu listPopup = new JPopupMenu();

		eventTypeList.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					if (!eventTypeList.isSelectedIndex(eventTypeList.locationToIndex(e.getPoint())))
						eventTypeList.setSelectedIndex(eventTypeList.locationToIndex(e.getPoint()));

					final String eventType = (String)eventTypeList.getSelectedValue();

					listPopup.removeAll();
					for (final GraphFactory factory: Lookup.getDefault().lookupAll(GraphFactory.class)) {
						listPopup.add(new AbstractAction(factory.getName()) {
							public void actionPerformed(ActionEvent e) {
								GraphAreaTopComponent.getDefault().addGraph(factory.newInstance(eventType, getPipe()));
							}
						});
					}
					listPopup.show(eventTypeList, e.getX(), e.getY());
				}
			}
		});


        scrollPane.setMinimumSize(new java.awt.Dimension(140, 6));
        scrollPane.setPreferredSize(new java.awt.Dimension(140, 100));

		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
    }

	/**
	 * Gets default instance. Do not use directly: reserved for *.settings files only,
	 * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
	 * To obtain the singleton instance, use {@link #findInstance}.
	 */
	public static synchronized DeviceListTopComponent getDefault() {
		if (instance == null) {
			instance = new DeviceListTopComponent();
		}
		return instance;
	}

	/**
	 * Obtain the DeviceListTopComponent instance. Never call {@link #getDefault} directly!
	 */
	public static synchronized DeviceListTopComponent findInstance() {
		TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
		if (win == null) {
			Logger.getLogger(DeviceListTopComponent.class.getName()).warning(
				"Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
			return getDefault();
		}
		if (win instanceof DeviceListTopComponent) {
			return (DeviceListTopComponent)win;
		}
		Logger.getLogger(DeviceListTopComponent.class.getName()).warning(
			"There seem to be multiple components with the '" + PREFERRED_ID
			+ "' ID. That is a potential source of errors and unexpected behavior.");
		return getDefault();
	}

	@Override
	public int getPersistenceType() {
		return TopComponent.PERSISTENCE_ALWAYS;
	}

	@Override
	public void componentOpened() {
		// TODO add custom code on component opening
	}

	@Override
	public void componentClosed() {
		// TODO add custom code on component closing
	}

	void writeProperties(java.util.Properties p) {
		// better to version settings since initial version as advocated at
		// http://wiki.apidesign.org/wiki/PropertyFiles
		p.setProperty("version", "1.0");
		// TODO store your settings
	}

	Object readProperties(java.util.Properties p) {
		if (instance == null) {
			instance = this;
		}
		instance.readPropertiesImpl(p);
		return instance;
	}

	private void readPropertiesImpl(java.util.Properties p) {
		String version = p.getProperty("version");
		// TODO read your settings according to their version
	}

	@Override
	protected String preferredID() {
		return PREFERRED_ID;
	}

	void addEventType(String eventType) {
		listModel.addEventType(eventType);
	}

	void setEventTypes(Set<String> eventTypes) {
		listModel.setEventTypes(eventTypes);
	}
	
	private Pipe pipe;
	void setPipe(Pipe pipe) {
		this.pipe = pipe;
	}

	Pipe getPipe() {
		return pipe;
	}

	private static class DeviceListCellRenderer extends JLabel implements ListCellRenderer {

		private Color LIGHT_BACKGROUND_COLOR;
		private Color LIGHT_TEXT_COLOR;
		private Color LIGHT_SELECTION_BACKGROUND_COLOR;
		private Color LIGHT_SELECTION_TEXT_COLOR;

		private Color DARK_BACKGROUND_COLOR;
		private Color DARK_TEXT_COLOR;
		private Color DARK_SELECTION_BACKGROUND_COLOR;
		private Color DARK_SELECTION_TEXT_COLOR;

        {
            setOpaque(true);
            setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
			
			ResourceBundle bundle = NbBundle.getBundle(DeviceListTopComponent.class);

			LIGHT_BACKGROUND_COLOR = Color.decode(bundle.getString("sidebar.light.backgroundColor"));
			LIGHT_TEXT_COLOR = Color.decode(bundle.getString("sidebar.light.textColor"));
			LIGHT_SELECTION_BACKGROUND_COLOR = Color.decode(bundle.getString("sidebar.light.selectionColor"));
			LIGHT_SELECTION_TEXT_COLOR = Color.decode(bundle.getString("sidebar.light.selectionTextColor"));

			DARK_BACKGROUND_COLOR = Color.decode(bundle.getString("sidebar.dark.backgroundColor"));
			DARK_TEXT_COLOR = Color.decode(bundle.getString("sidebar.dark.textColor"));
			DARK_SELECTION_BACKGROUND_COLOR = Color.decode(bundle.getString("sidebar.dark.selectionColor"));
			DARK_SELECTION_TEXT_COLOR = Color.decode(bundle.getString("sidebar.dark.selectionTextColor"));

        }

        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			setText(String.format("<html><b>Event: %s</b></html>", value));

            boolean light = index % 2 == 0;

            if (isSelected) {
                setBackground(light ? LIGHT_SELECTION_BACKGROUND_COLOR : DARK_SELECTION_BACKGROUND_COLOR);
                setForeground(light ? LIGHT_SELECTION_TEXT_COLOR : DARK_SELECTION_TEXT_COLOR);
            }
            else {
                setBackground(light ? LIGHT_BACKGROUND_COLOR : DARK_BACKGROUND_COLOR);
                setForeground(light ? LIGHT_TEXT_COLOR : DARK_TEXT_COLOR);
            }

            return this;
        }

    }
}
