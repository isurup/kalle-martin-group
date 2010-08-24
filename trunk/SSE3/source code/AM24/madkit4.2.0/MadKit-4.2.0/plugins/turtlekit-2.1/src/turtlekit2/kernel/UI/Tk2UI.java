package turtlekit2.kernel.UI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.EmptyBorder;

import madkit.kernel.AbstractAgent;
import net.infonode.docking.theme.BlueHighlightDockingTheme;
import net.infonode.docking.theme.ClassicDockingTheme;
import net.infonode.docking.theme.DefaultDockingTheme;
import net.infonode.docking.theme.DockingWindowsTheme;
import net.infonode.docking.theme.GradientDockingTheme;
import net.infonode.docking.theme.LookAndFeelDockingTheme;
import net.infonode.docking.theme.ShapedGradientDockingTheme;
import net.infonode.docking.theme.SlimFlatDockingTheme;
import net.infonode.docking.theme.SoftBlueIceDockingTheme;
import net.infonode.gui.colorprovider.FixedColorProvider;
import net.infonode.tabbedpanel.TabDropDownListVisiblePolicy;
import net.infonode.tabbedpanel.TabLayoutPolicy;
import net.infonode.tabbedpanel.TabbedPanel;
import net.infonode.tabbedpanel.theme.BlueHighlightTheme;
import net.infonode.tabbedpanel.theme.ClassicTheme;
import net.infonode.tabbedpanel.theme.DefaultTheme;
import net.infonode.tabbedpanel.theme.GradientTheme;
import net.infonode.tabbedpanel.theme.LookAndFeelTheme;
import net.infonode.tabbedpanel.theme.ShapedGradientTheme;
import net.infonode.tabbedpanel.theme.SmallFlatTheme;
import net.infonode.tabbedpanel.theme.SoftBlueIceTheme;
import net.infonode.tabbedpanel.theme.TabbedPanelTitledTabTheme;
import net.infonode.tabbedpanel.titledtab.TitledTab;
import net.infonode.tabbedpanel.titledtab.TitledTabProperties;
import net.infonode.tabbedpanel.titledtab.TitledTabSizePolicy;
import net.infonode.util.Direction;

import org.w3c.dom.Document;

import turtlekit2.kernel.creators.SimulationLauncher;
import turtlekit2.kernel.creators.Tk2Launcher;
import turtlekit2.kernel.tools.SimuFilter;
import turtlekit2.tools.XMLLoader;


public class Tk2UI extends JFrame{

	private static final long serialVersionUID = 1L;
	private TitledTabProperties titledTabProperties = new TitledTabProperties();
	private int activeTheme;
	private TabbedPanel tabbedPanel = new TabbedPanel();
	private int tabId;
	private Tk2Launcher m;

	public Tk2UI(Tk2Launcher m) {
		this.m = m;
		initContent();
//		newSimulation("D:/-=Sources=-/workspace2/Tk2/Demo_Termites.xml");
	}

	
	void initContent(){
		this.setTitle(" * * * T U R T L E K I T   2 * * *  ");
		this.setSize(1200, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(createMenuBar());
		this.getContentPane().add(tabbedPanel, BorderLayout.CENTER);

		tabbedPanel.getProperties().setTabAreaOrientation(Direction.RIGHT);
		tabbedPanel.getProperties().setTabDropDownListVisiblePolicy(TabDropDownListVisiblePolicy.TABS_NOT_VISIBLE);
		tabbedPanel.getProperties().setShadowEnabled(true);
		tabbedPanel.getProperties().setTabLayoutPolicy(TabLayoutPolicy.SCROLLING);
		titledTabProperties.getNormalProperties().setDirection(Direction.DOWN);
		titledTabProperties.setSizePolicy(TitledTabSizePolicy.INDIVIDUAL_SIZE);
		tabbedPanel.getProperties().addSuperObject(tabbedPanelThemes[1].getTabbedPanelProperties());
		titledTabProperties.addSuperObject(tabbedPanelThemes[1].getTitledTabProperties());
		activeTheme = 1;
	}
	
	
	private Tk2Tab createTab(JComponent compo) {
		Tk2Tab tab = new Tk2Tab("Simu " + tabId, null, compo, null);
		tabId++;
		tab.validate();
		tab.setHighlightedStateTitleComponent(createCloseTabButton(tab));
		tab.getProperties().addSuperObject(titledTabProperties);
		return tab;
	}
	
	
	
	/**
	 * Creates the menu bar
	 */
	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(createTabbedPanelMenu());
		menuBar.add(createThemeMenu());
		menuBar.add(createAboutMenu());
		return menuBar;
	}

	/**
	 * Creates the Tabbed Panel menu
	 *
	 * @return the tabbed panel menu
	 */
	private JMenu createTabbedPanelMenu() {
		final Component thisComponent = this;
		JMenu tabbedPanelMenu = new JMenu("Simulation");
		
//		tabbedPanelMenu.add(createMenuItem("Save simulation", new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JFileChooser jChooser = new JFileChooser(System.getProperty("user.dir")+File.separator+"plugins");
//				SimuFilter filter = new SimuFilter();
//				jChooser.setFileFilter(filter);
//				int returnVal = jChooser.showOpenDialog(thisComponent);
//				if(returnVal == JFileChooser.APPROVE_OPTION) {
//					((SimulationUI)(tabbedPanel.getSelectedTab().getContentComponent())).saveXml(jChooser.getSelectedFile());
//				}
//			}
//		}));


		tabbedPanelMenu.add(createMenuItem("Load simulation", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jChooser = new JFileChooser(System.getProperty("user.dir"));
				SimuFilter filter = new SimuFilter();
				jChooser.setFileFilter(filter);
				int returnVal = jChooser.showOpenDialog(thisComponent);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					String fileName = (jChooser.getSelectedFile().getAbsolutePath());
					newSimulation(fileName);
				}
			}
		}));

		tabbedPanelMenu.addSeparator();

		tabbedPanelMenu.add(createMenuItem("Exit", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}));


		return tabbedPanelMenu;
	}

	/**
	 * Creates the theme menu
	 *
	 * @return the theme menu
	 */
	private JMenu createThemeMenu() {
		JMenu themeMenu = new JMenu("Theme");
		ButtonGroup buttonGroup = new ButtonGroup();

		for (int i = 0; i < tabbedPanelThemes.length; i++) {
			JMenuItem themeItem = new JRadioButtonMenuItem(tabbedPanelThemes[i].getName());
			buttonGroup.add(themeItem);
			final int k = i;
			themeItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					applyTheme(k);
				}
			});

			themeMenu.add(themeItem);
			themeItem.setSelected(i == 0);
		}

		return themeMenu;
	}
	
	private JMenu createAboutMenu() {
		JMenu themeMenu = new JMenu("About");
		themeMenu.add(createMenuItem("About", new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AboutBox().setVisible(true);
				}
			}));
		return themeMenu;
		}

	private JMenuItem createMenuItem(String text, ActionListener listener) {
		JMenuItem item = new JMenuItem(text);
		item.addActionListener(listener);
		return item;
	}

	private void applyTheme(int theme) {
		tabbedPanel.getProperties().removeSuperObject(tabbedPanelThemes[activeTheme].getTabbedPanelProperties());
		titledTabProperties.removeSuperObject(tabbedPanelThemes[activeTheme].getTitledTabProperties());
		tabbedPanel.getProperties().addSuperObject(tabbedPanelThemes[theme].getTabbedPanelProperties());
		titledTabProperties.addSuperObject(tabbedPanelThemes[theme].getTitledTabProperties());
		activeTheme = theme;

		int tabCount = tabbedPanel.getTabCount();
		for (int i = 0; i < tabCount; i++)
			((SimulationUI)(tabbedPanel.getTabAt(i).getContentComponent())).setTheme(dockingThemes[theme]);
	}

	

	/**
	 * Creates a JButton with an X
	 *
	 * @return the button
	 */
	private JButton createXButton() {
		JButton closeButton = new JButton("X");
		closeButton.setOpaque(false);
		closeButton.setMargin(null);
		closeButton.setFont(closeButton.getFont().deriveFont(Font.BOLD).deriveFont((float) 10));
		closeButton.setBorder(new EmptyBorder(1, 1, 1, 1));
		return closeButton;
	}

	/**
	 * Creates a close tab button that closes the given tab when the button is
	 * selected
	 *
	 * @param tab the tab what will be closed when the button is pressed
	 * @return the close button
	 */
	private JButton createCloseTabButton(final Tk2Tab tab) {
		JButton closeButton = createXButton();
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tab.getTabbedPanel().removeTab(tab);
				tab.l.end();
			}
		});
		return closeButton;
	}
	
	
	public void newSimulation(String fileName){
		Document doc = XMLLoader.getDocFromFile(fileName);
		
		String simulationGroup = m.getGroupName(doc);
		
		m.createGroup(false, Tk2Launcher.COMMUNITY, simulationGroup, null, null);
		
		System.err.println(simulationGroup + " loaded...");
		
		Tk2SimuUIManager uiManager = new Tk2SimuUIManager(simulationGroup);
		m.launchAgent(uiManager, simulationGroup + " UIManager", true);
		
		Tk2Tab newTab = createTab(uiManager.myGUI);
		tabbedPanel.addTab(newTab);
		tabbedPanel.setSelectedTab(newTab);
		uiManager.disposeMyGUI();
		
		System.err.println(uiManager.getName() + " loaded...");
		
		SimulationLauncher newLauncher = new SimulationLauncher(
				XMLLoader.getDocFromFile(fileName).getDocumentElement(),
				simulationGroup);
		m.launchAgent((AbstractAgent)newLauncher, simulationGroup + " launcher" ,true);
		newLauncher.disposeMyGUI();
		
		newTab.l = newLauncher;
		
		System.err.println(newLauncher.getName() + " loaded...");
		
//		TreeEditorUI treeEdit = new TreeEditorUI(doc);
//		
//		m.sendMessage(Tk2Launcher.COMMUNITY, simulationGroup, "UIManager", new GUIMessage<JComponent>(treeEdit, SimulationUI.EDITOR_ZONE, "Parameters"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	class Tk2Tab extends TitledTab{
		private static final long serialVersionUID = 1L;
		public SimulationLauncher l;
		
		public Tk2Tab(String arg0, Icon arg1, JComponent arg2, JComponent arg3) {
			super(arg0, arg1, arg2, arg3);
		}
		
	}
	
	
	
	
	
	
	
	
	
	/**********THEMES***********/
	
	
	
	
	private static DockingWindowsTheme[] dockingThemes = new DockingWindowsTheme[]{
		new DefaultDockingTheme(),
		new SoftBlueIceDockingTheme(),
		new SoftBlueIceDockingTheme(
				new FixedColorProvider(Color.BLUE), new FixedColorProvider(Color.GRAY), 3, true){
			public String getName() {
				return "Ice Modified";
			}
		},
		new LookAndFeelDockingTheme(), 
		new ClassicDockingTheme(), 
		new BlueHighlightDockingTheme(), 
		new SlimFlatDockingTheme(), 
		new GradientDockingTheme(),
		new GradientDockingTheme(true, true, false, false), 
		new ShapedGradientDockingTheme(), 
		new ShapedGradientDockingTheme(
				0f,
				0f,
				new FixedColorProvider(
						new Color(150, 150, 150)),
						null, true) {
			public String getName() {
				return super.getName() +
				" Flat with no Slopes";
			}
		}};
	private static TabbedPanelTitledTabTheme[] tabbedPanelThemes = new TabbedPanelTitledTabTheme[]{
		new DefaultTheme(),
		new SoftBlueIceTheme(),
		new SoftBlueIceTheme(new FixedColorProvider(Color.BLUE), new FixedColorProvider(Color.GRAY), 3){
			public String getName() {
				return "Ice Modified";
			}
		},
		new LookAndFeelTheme(), 
		new ClassicTheme(), 
		new BlueHighlightTheme(), 
		new SmallFlatTheme(), 
		new GradientTheme(),
		new GradientTheme(true, true), 
		new ShapedGradientTheme(), 
		new ShapedGradientTheme(
				0f,
				0f,
				new FixedColorProvider(
						new Color(150, 150, 150)),
						null) {
			public String getName() {
				return super.getName() +
				" Flat with no Slopes";
			}
		}};
}
