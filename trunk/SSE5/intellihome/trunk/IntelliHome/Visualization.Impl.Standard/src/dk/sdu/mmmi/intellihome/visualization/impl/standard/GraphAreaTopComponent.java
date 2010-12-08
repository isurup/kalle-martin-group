package dk.sdu.mmmi.intellihome.visualization.impl.standard;

import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.visualization.impl.standard.graphs.AbstractGraph;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import org.netbeans.api.settings.ConvertAsProperties;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//dk.sdu.mmmi.intellihome.visualization.impl.standard//GraphArea//EN",
autostore = false)
public final class GraphAreaTopComponent extends TopComponent {

	/* ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** */
	/* *****                 Static TopComponent code                    ***** */
	/* ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** */

	private static GraphAreaTopComponent instance;
	private static final String PREFERRED_ID = "GraphAreaTopComponent";
	/** path to the icon used by the component and its open action */
//    static final String ICON_PATH = "SET/PATH/TO/ICON/HERE";

	/**
	 * Gets default instance. Do not use directly: reserved for *.settings files only,
	 * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
	 * To obtain the singleton instance, use {@link #findInstance}.
	 */
	public static synchronized GraphAreaTopComponent getDefault() {
		if (instance == null) {
			instance = new GraphAreaTopComponent();
		}
		return instance;
	}

	/**
	 * Obtain the GraphAreaTopComponent instance. Never call {@link #getDefault} directly!
	 */
	public static synchronized GraphAreaTopComponent findInstance() {
		TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
		if (win == null) {
			Logger.getLogger(GraphAreaTopComponent.class.getName()).warning(
				"Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
			return getDefault();
		}
		if (win instanceof GraphAreaTopComponent) {
			return (GraphAreaTopComponent)win;
		}
		Logger.getLogger(GraphAreaTopComponent.class.getName()).warning(
			"There seem to be multiple components with the '" + PREFERRED_ID
			+ "' ID. That is a potential source of errors and unexpected behavior.");
		return getDefault();
	}


	/* ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** */
	/* *****                   TopComponent code                         ***** */
	/* ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** */

	public GraphAreaTopComponent() {
		initComponents();
		setName(NbBundle.getMessage(GraphAreaTopComponent.class, "CTL_GraphAreaTopComponent"));
		setToolTipText(NbBundle.getMessage(GraphAreaTopComponent.class, "HINT_GraphAreaTopComponent"));
//        setIcon(ImageUtilities.loadImage(ICON_PATH, true));
		putClientProperty(TopComponent.PROP_CLOSING_DISABLED, Boolean.TRUE);
		putClientProperty(TopComponent.PROP_DRAGGING_DISABLED, Boolean.TRUE);
		putClientProperty(TopComponent.PROP_MAXIMIZATION_DISABLED, Boolean.TRUE);
		putClientProperty(TopComponent.PROP_UNDOCKING_DISABLED, Boolean.TRUE);

	}

	@Override
	public int getPersistenceType() {
		return TopComponent.PERSISTENCE_ALWAYS;
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

	/* ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** */
	/* *****                 Component initialization                    ***** */
	/* ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** */

	private final JPanel graphPanel = new JPanel();
	private final JLabel labelStartDate = new JLabel("Start time");
	private final JLabel labelEndDate = new JLabel("End time");
	private final JCheckBox checkboxLiveUpdate = new JCheckBox("Live");

    private void initComponents() {
		setLayout(new BorderLayout());
		add(new JScrollPane(graphPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
        BoxLayout layout = new BoxLayout(graphPanel, BoxLayout.Y_AXIS);
		graphPanel.setBackground(Color.black);
		graphPanel.setOpaque(true);
        graphPanel.setLayout(layout);

		JPanel datePanel = new JPanel(new GridBagLayout());
		datePanel.setPreferredSize(new Dimension(200, 35));
		add(datePanel, BorderLayout.NORTH);

		JPanel scrollPanel = new JPanel(new GridBagLayout());
		scrollPanel.setPreferredSize(new Dimension(200, 35));
		add(scrollPanel, BorderLayout.SOUTH);
		JButton buttonJumpBack = new JButton("<<");
		JButton buttonStepBack = new JButton("<");
		JButton buttonStepForward = new JButton(">");
		JButton buttonJumpForward = new JButton(">>");
		labelStartDate.setHorizontalAlignment(SwingConstants.LEFT);
		labelEndDate.setHorizontalAlignment(SwingConstants.RIGHT);

		Dimension dimButtons = new Dimension(32, 32);
		buttonJumpBack.setPreferredSize(dimButtons);
		buttonStepBack.setPreferredSize(dimButtons);
		buttonStepForward.setPreferredSize(dimButtons);
		buttonJumpForward.setPreferredSize(dimButtons);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(3, 3, 3, 3);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		scrollPanel.add(buttonJumpBack, gbc);
		gbc.gridx++;
		scrollPanel.add(buttonStepBack, gbc);
		gbc.gridx++;
		gbc.weightx = 1;
		scrollPanel.add(labelStartDate, gbc);
		gbc.gridx++;
		scrollPanel.add(labelEndDate, gbc);
		gbc.gridx++;
		gbc.weightx = 0;
		scrollPanel.add(buttonStepForward, gbc);
		gbc.gridx++;
		scrollPanel.add(buttonJumpForward, gbc);
		buttonJumpBack.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { moveTimeline(true, true); } });
		buttonStepBack.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { moveTimeline(true, false); } });
		buttonStepForward.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { moveTimeline(false, false); } });
		buttonJumpForward.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { moveTimeline(false, true); } });

		final JComboBox combo = new JComboBox(new ComboValue[] {
			new ComboValue("4 minutes", 4 * 60 * 1000L),
			new ComboValue("16 minutes", 16 * 60 * 1000L),
			new ComboValue("30 minutes", 30 * 60 * 1000L),
			new ComboValue("1 hour", 60 * 60 * 1000L),
			new ComboValue("4 hours", 4 * 60 * 60 * 1000L),
			new ComboValue("12 hours", 12 * 60 * 60 * 1000L),
			new ComboValue("24 hours", 24 * 60 * 60 * 1000L),
			new ComboValue("4 days", 4 * 24 * 60 * 60 * 1000L),
			new ComboValue("1 week", 7 * 24 * 60 * 60 * 1000L),
			new ComboValue("4 weeks", 4 * 7 * 24 * 60 * 60 * 1000L),
		});
		combo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Object item = combo.getSelectedItem();
				if (item instanceof ComboValue) {
					ComboValue val = (ComboValue)item;
					updateTime(endTime - val.value, endTime);
				}
			}
		});
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx = 0;
		gbc2.gridy = 0;
		gbc2.anchor = GridBagConstraints.EAST;
		gbc2.weightx = 1;
		datePanel.add(combo, gbc2);

		checkboxLiveUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeLiveUpdateState(checkboxLiveUpdate.isSelected());
			}
		});

		gbc2.gridx++;
		gbc2.weightx = 0;
		datePanel.add(checkboxLiveUpdate, gbc2);
	}

	private Timer liveTimer;
	private void changeLiveUpdateState(boolean active) {
		if (!active && liveTimer != null) {
			liveTimer.cancel();
			liveTimer = null;
		}
		else if (active && liveTimer == null) {
			liveTimer = new Timer(true);
			liveTimer.schedule(new TimerTask() {
				@Override
				public void run() {
					long timeSpan = endTime - startTime;
					long now = System.currentTimeMillis();
					updateTime(now - timeSpan, now);
				}
			}, 0, 5000);
		}
	}

	private static class ComboValue {
		final String label;
		final long value;

		public ComboValue(String label, long value) {
			this.label = label;
			this.value = value;
		}

		@Override
		public String toString() {
			return label;
		}


	}

	/* ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** */
	/* *****                      User code                              ***** */
	/* ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** */

	void addGraph(final AbstractGraph graph) {
		JButton button = new JButton("X");
		button.setPreferredSize(new Dimension(16, 16));
		button.setFocusable(false);
		button.setForeground(Color.white);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorder(BorderFactory.createLineBorder(Color.white));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				graphPanel.remove(graph);
				graphPanel.validate();
				graphPanel.repaint();
			}
		});
		graph.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.anchor = GridBagConstraints.NORTHEAST;
		graph.add(button, gbc);
		
		graphPanel.add(graph);
		updateTime(startTime, endTime);
		graphPanel.revalidate();
	}

	void resetGraphs() {
		graphPanel.removeAll();
		graphPanel.revalidate();
		checkboxLiveUpdate.setSelected(false);
	}

	private long endTime = System.currentTimeMillis();
	private long startTime = endTime - 4 * 60 * 1000L;

	private void moveTimeline(boolean backward, boolean jump) {
		long distance = (endTime - startTime) / (jump ? 1 : 4) * (backward ? -1 : 1);
		updateTime(startTime + distance, endTime + distance);
	}

	private DateFormat dateFormat = DateFormat.getDateTimeInstance();
	
	private void updateTime(long start, long end) {
		long timespan = (end - start);
		if (end > System.currentTimeMillis())
			end = System.currentTimeMillis();
		endTime = end;
		startTime = end - timespan;

		labelStartDate.setText(dateFormat.format(new Date(startTime)));
		labelEndDate.setText(dateFormat.format(new Date(endTime)));

		for (Component comp: graphPanel.getComponents()) {
			if (comp instanceof AbstractGraph) {
				((AbstractGraph)comp).updateTime(startTime, endTime);
			}
		}

		graphPanel.repaint();
	}

	void update(DataEvent event) {
		//throw new UnsupportedOperationException("Not yet implemented");
	}
}
