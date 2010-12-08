package dk.sdu.mmmi.intellihome.visualization.impl.standard;

//import dk.sdu.mmmi.zcommand.Main;
//import dk.sdu.mmmi.zcommand.model.Device;
//import dk.sdu.mmmi.zcommand.model.DeviceManager;
//import dk.sdu.mmmi.zcommand.model.DeviceManagerEventListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author jemr
 */
public class ScrollingDeviceList extends JScrollPane {
	/*

    private static final Color LIGHT_BACKGROUND_COLOR = Color.decode(Main.getSettings().getProperty("sidebar.light.backgroundColor"));
    private static final Color LIGHT_TEXT_COLOR = Color.decode(Main.getSettings().getProperty("sidebar.light.textColor"));
    private static final Color LIGHT_SELECTION_BACKGROUND_COLOR = Color.decode(Main.getSettings().getProperty("sidebar.light.selectionColor"));
    private static final Color LIGHT_SELECTION_TEXT_COLOR = Color.decode(Main.getSettings().getProperty("sidebar.light.selectionTextColor"));

    private static final Color DARK_BACKGROUND_COLOR = Color.decode(Main.getSettings().getProperty("sidebar.dark.backgroundColor"));
    private static final Color DARK_TEXT_COLOR = Color.decode(Main.getSettings().getProperty("sidebar.dark.textColor"));
    private static final Color DARK_SELECTION_BACKGROUND_COLOR = Color.decode(Main.getSettings().getProperty("sidebar.dark.selectionColor"));
    private static final Color DARK_SELECTION_TEXT_COLOR = Color.decode(Main.getSettings().getProperty("sidebar.dark.selectionTextColor"));


    public ScrollingDeviceList() {
        super(new DeviceList(), VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_NEVER);
        setPreferredSize(new Dimension(140, 300));
        setMinimumSize(new Dimension(140, 300));
    }

    public Device getSelectedDevice() {
        return (Device)((DeviceList)getViewport().getView()).getSelectedValue();
    }

    private static class DeviceList extends JList {
        DeviceList() {
            setCellRenderer(new DeviceListCellRenderer());
            setModel(new DeviceListDataModel());
            setFixedCellHeight(55);
            setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
    }

    private static class DeviceListDataModel implements ListModel, DeviceManagerEventListener {

        private ArrayList<Device> list = new ArrayList<Device>();
        private HashSet<ListDataListener> dataListeners = new HashSet<ListDataListener>();

        DeviceListDataModel() {
            DeviceManager.getInstance().addChangeListener(this);
        }

        public int getSize() {
            return list.size();
        }

        public Object getElementAt(int index) {
            return list.get(index);
        }

        public void addListDataListener(ListDataListener l) {
            dataListeners.add(l);
        }

        public void removeListDataListener(ListDataListener l) {
            dataListeners.remove(l);
        }

        public void deviceAdded(Device device) {
            System.out.println("Dev added");
            list = new ArrayList<Device>(DeviceManager.getInstance().getDevices());
            
            ListDataEvent event = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, list.size());
            for (ListDataListener listener: dataListeners) {
                try {
                    listener.contentsChanged(event);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class DeviceListCellRenderer extends JLabel implements ListCellRenderer {

        {
            setOpaque(true);
            setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        }

        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Device) {
                Device device = (Device) value;
                setText(String.format("<html><b>Device %s</b><br><font size=-2><i>%s<br>%s</i></font></html>", device.getId(), device.getName(), device.getType()));
            }
            else
                setText(String.format("<html><b>Device %s</b><br><font size=-2><i>%s<br>%s</i></font></html>", "[Unknown]", "[Unknown]", value));

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
	 *
	 */
}
