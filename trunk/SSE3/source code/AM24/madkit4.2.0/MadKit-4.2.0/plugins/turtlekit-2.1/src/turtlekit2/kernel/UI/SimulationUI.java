package turtlekit2.kernel.UI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import net.infonode.docking.RootWindow;
import net.infonode.docking.TabWindow;
import net.infonode.docking.View;
import net.infonode.docking.properties.RootWindowProperties;
import net.infonode.docking.theme.DockingWindowsTheme;
import net.infonode.docking.theme.SoftBlueIceDockingTheme;
import net.infonode.docking.util.DockingUtil;
import net.infonode.docking.util.ViewMap;
import net.infonode.util.Direction;


public class SimulationUI extends JPanel {
	private static final long serialVersionUID = 1L;

	public static final int EDITOR_ZONE = 0;
	public static final int CONSOLE_ZONE = 1;
	public static final int VIEWER_ZONE = 2;
	public static final int BUTTON_ZONE = 3;
	
	/** Graphical **/
	private RootWindow viewersDock;
	private RootWindow consolesDock;
	private RootWindow editorsDock;
	private RootWindowProperties viewersDockProperties = new RootWindowProperties();
	private RootWindowProperties consolesDockProperties = new RootWindowProperties();
	private RootWindowProperties editorsDockProperties = new RootWindowProperties();
	private ViewMap staticViewers = new ViewMap();
	private ViewMap staticConsoles = new ViewMap();
	private ViewMap staticEditors = new ViewMap();
	private TabWindow viewers = new TabWindow();
	private TabWindow consoles = new TabWindow();
	private TabWindow editors = new TabWindow();
	private DockingWindowsTheme currentTheme = new SoftBlueIceDockingTheme();
	private JPanel buttons = new JPanel();
	private JPanel leftPanel = new JPanel();
	
	View fake1;
	View fake2;
	View fake3;
	
	
	public SimulationUI() {
		initDocks();
		dispatchViews();
		initLayouts();
	}



	private void dispatchViews() {
		fake1 = new View("", null, null);
		fake2 = new View("", null, null);
		fake3 = new View("", null, null);
		editors.addTab(fake1);
		consoles.addTab(fake2);
		viewers.addTab(fake3);
		
	}

	
	
	public void addTabbedComponent(JComponent c, int zone, String name){
		View newView = new View(name, null, c);
		newView.getWindowProperties().setCloseEnabled(false);
		switch (zone) {
		case EDITOR_ZONE:
			editors.addTab(newView);
			if(fake1 != null){fake1.close(); fake1 = null;}
			break;
		case CONSOLE_ZONE:
			consoles.addTab(newView);
			if(fake2 != null){ fake2.close(); fake2 = null;}
			break;
		case VIEWER_ZONE:
			viewers.addTab(newView);
			if(fake3 != null){ fake3.close(); fake3 = null;}
			break;
		case BUTTON_ZONE:
			buttons.add(c);
			break;
		default:
			break;
		}
		this.validate();
	}

	private void initDocks() {
		this.setLayout(new BorderLayout());
		viewersDock = DockingUtil.createRootWindow(staticViewers, false);
		viewersDock.getRootWindowProperties().addSuperObject(viewersDockProperties);
		viewersDockProperties.addSuperObject(currentTheme.getRootWindowProperties());
		viewersDock.getWindowBar(Direction.DOWN).setEnabled(true); 
		viewersDock.getRootWindowProperties().setRecursiveTabsEnabled(false); 
		viewersDock.getRootWindowProperties().getSplitWindowProperties().setDividerLocationDragEnabled(false);
		viewersDock.getRootWindowProperties().setRecursiveTabsEnabled(false);

		consolesDock = DockingUtil.createRootWindow(staticConsoles, false);
		consolesDock.getRootWindowProperties().addSuperObject(consolesDockProperties);
		consolesDockProperties.addSuperObject(currentTheme.getRootWindowProperties());
		consolesDock.getWindowBar(Direction.DOWN).setEnabled(true); 
		consolesDock.getRootWindowProperties().setRecursiveTabsEnabled(false); 
		consolesDock.getRootWindowProperties().getSplitWindowProperties().setDividerLocationDragEnabled(false);
		consolesDock.getRootWindowProperties().setRecursiveTabsEnabled(false);

		editorsDock = DockingUtil.createRootWindow(staticEditors, false);
		editorsDock.getRootWindowProperties().addSuperObject(editorsDockProperties);
		editorsDockProperties.addSuperObject(currentTheme.getRootWindowProperties());
		editorsDock.getWindowBar(Direction.LEFT).setEnabled(true); 
		editorsDock.getRootWindowProperties().setRecursiveTabsEnabled(false); 
		editorsDock.getRootWindowProperties().getSplitWindowProperties().setDividerLocationDragEnabled(false);
		editorsDock.getRootWindowProperties().setRecursiveTabsEnabled(false);
		editors.getTabWindowProperties().getTabbedPanelProperties().setTabAreaOrientation(Direction.DOWN);
	}

	private void initLayouts() {
		JSplitPane lateral = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		lateral.setOneTouchExpandable(true);
		lateral.setDividerSize(7);
		lateral.setResizeWeight(0.22);
		JSplitPane vertical = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		vertical.setOneTouchExpandable(true);
		vertical.setDividerSize(7);
		vertical.setResizeWeight(0.7);

		leftPanel.setLayout(new BorderLayout());
		leftPanel.add(editorsDock, BorderLayout.CENTER);
		lateral.setLeftComponent(leftPanel);
		lateral.setRightComponent(vertical);
		vertical.setLeftComponent(viewersDock);
		vertical.setRightComponent(consolesDock);

		viewersDock.setWindow(viewers);
		consolesDock.setWindow(consoles);
		editorsDock.setWindow(editors);
		editors.getTabWindowProperties().getTabbedPanelProperties().setTabAreaOrientation(Direction.DOWN);

		this.add(lateral, BorderLayout.CENTER);
		buttons.setMinimumSize(new Dimension(200,200));
		this.add(buttons, BorderLayout.NORTH);
		this.validate();
	}



//	private JPanel getScroll(int initValue) {
//		JPanel panel = new JPanel();
//		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
//		final JLabel speed = new JLabel(new Integer(simu.speed).toString()
//				+ "% ");
//		JScrollBar scrollBar = new JScrollBar(Scrollbar.HORIZONTAL, initValue,
//				1, 1, 100);
//		scrollBar.addAdjustmentListener(new AdjustmentListener() {
//			public void adjustmentValueChanged(AdjustmentEvent e) {
//				simu.speed = 100 - ((JScrollBar) e.getSource()).getValue();
//				speed.setText(new Integer(100 - simu.speed).toString() + "% ");
//			}
//		});
//		scrollBar.setSize(300, 50);
//		panel.add(new JLabel("Speed: "));
//		panel.add(speed);
//		panel.add(scrollBar);
//		return panel;
//	}


//	private JPanel getActions() {
//		JPanel actions = new JPanel();
//
//		startButton = new JButton("Run");
//		actions.add(startButton);
//
//		resetButton = new JButton("Reset");
//		actions.add(resetButton);
//
//		batch = new JCheckBox("Batch");
//		actions.add(batch);
//
//		final Component thisComponent = this;
//		final SimulationUI thisUI = this;
//		batch.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent e) {
//				if (((JCheckBox) e.getSource()).isSelected()) {
//					editors.setSelectedTab(1);
//					attributeEditor.setVisible(false);
//					batchEditor.setVisible(true);
//					JFileChooser jChooser = new JFileChooser(System
//							.getProperty("home"));
//					jChooser.setDialogTitle("Save batch data in folder");
//					jChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//					int returnVal = jChooser.showSaveDialog(thisComponent);
//					if (returnVal == JFileChooser.APPROVE_OPTION) {
//						manager = new SimulationManager(jChooser.getSelectedFile().getAbsolutePath(), thisUI);
//						if(!charterCheck.isSelected()) charterCheck.doClick();
//					}else{
//						batchOff();
//					}
//				} else {
//					batchOff();
//				}
//			}
//		});
//
//
//		startButton.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				play(((JButton) (e.getSource())));
//			}
//		});
//		
//		resetButton.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				startButton.setEnabled(false);
//				reset(null);
//			}
//		});
//		
//		
//		
//		JCheckBox viewer3DCheck = new JCheckBox("3D");
//		actions.add(viewer3DCheck);
//		viewer3DCheck.setSelected(true);
//		charterCheck = new JCheckBox("Chart");
//		actions.add(charterCheck);
//		charterCheck.setSelected(true);
//		
//		viewer3DCheck.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent e) {
//				if (((JCheckBox) e.getSource()).isSelected()) {
//					viewer.viewOn = true;
//					viewer.reset();
//				} else {
//					viewer.viewOn = false;
//					viewer.disconnect();
//				}
//			}
//		});
//
//		
//		charterCheck.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent e) {
//				if (((JCheckBox) e.getSource()).isSelected()) {
//					charter.reset(false);
//				} else {
//					charter.disconnect();
//				}
//			}
//		});
//		
//		return actions;
//	}


	


	public void setTheme(DockingWindowsTheme theme) {
		consolesDockProperties.replaceSuperObject(currentTheme.getRootWindowProperties(),
				theme.getRootWindowProperties());
		viewersDockProperties.replaceSuperObject(currentTheme.getRootWindowProperties(),
				theme.getRootWindowProperties());
		editorsDockProperties.replaceSuperObject(currentTheme.getRootWindowProperties(),
				theme.getRootWindowProperties());
		currentTheme = theme;
	}


}
