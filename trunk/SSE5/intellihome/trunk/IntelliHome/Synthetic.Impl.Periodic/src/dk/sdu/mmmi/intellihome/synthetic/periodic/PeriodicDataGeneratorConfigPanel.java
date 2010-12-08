
package dk.sdu.mmmi.intellihome.synthetic.periodic;

import dk.sdu.mmmi.intellihome.synthetic.simple.DataGenerator;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Dictionary;
import java.util.Hashtable;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.openide.util.Exceptions;

/**
 *
 * @author jemr
 */
public class PeriodicDataGeneratorConfigPanel extends JPanel {

	private final JPanel panelTop = new JPanel();
	private final JPanel panelUp = new JPanel();
	private final JPanel panelDown = new JPanel();

	private final JSlider sliderOffsetSeconds = new JSlider(0, 60 * 60);
	private final JSpinner spinnerOffsetDays = new JSpinner(new SpinnerNumberModel(0, 0, 8, 1.0));
	private final JSpinner spinnerOffsetHours = new JSpinner(new SpinnerNumberModel(0, 0, 23, 1.0));
	private final JCheckBox checkMultiply = new JCheckBox("Multiply");

	private final JSlider sliderUpPeriodSeconds = new JSlider(0, 60 * 60);
	private final JSpinner spinnerUpPeriodDays = new JSpinner(new SpinnerNumberModel(0, 0, 8, 1.0));
	private final JSpinner spinnerUpPeriodHours = new JSpinner(new SpinnerNumberModel(0, 0, 23, 1.0));
	private final JSpinner spinnerUpPeriodRepeat = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1.0));
	private final JSpinner spinnerUpOffset = new JSpinner(new SpinnerNumberModel(0.0, -1000.0, 1000.0, 1.0));
	private final JSpinner spinnerUpAmplitude = new JSpinner(new SpinnerNumberModel(0.0, -500.0, 500.0, 0.1));
	private final JSpinner spinnerUpFactor = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 200.0, 0.1));

	private final JSlider sliderDownPeriodSeconds = new JSlider(0, 60 * 60);
	private final JSpinner spinnerDownPeriodDays = new JSpinner(new SpinnerNumberModel(0, 0, 8, 1.0));
	private final JSpinner spinnerDownPeriodHours = new JSpinner(new SpinnerNumberModel(0, 0, 23, 1.0));
	private final JSpinner spinnerDownPeriodRepeat = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1.0));
	private final JSpinner spinnerDownOffset = new JSpinner(new SpinnerNumberModel(0.0, -1000.0, 1000.0, 1.0));
	private final JSpinner spinnerDownAmplitude = new JSpinner(new SpinnerNumberModel(0.0, -500.0, 500.0, 0.1));
	private final JSpinner spinnerDownFactor = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 200.0, 0.1));

	private final AbstractPeriodicDataGenerator generator;

	PeriodicDataGeneratorConfigPanel(AbstractPeriodicDataGenerator generator) {
		this.generator = generator;

		initComponents();
		initValues();
		initListeners();
		layoutComponents();
	}

	private void initComponents() {
		panelTop.setBorder(BorderFactory.createTitledBorder("Offset"));
		panelUp.setBorder(BorderFactory.createTitledBorder("Up"));
		panelDown.setBorder(BorderFactory.createTitledBorder("Down"));

		Dictionary<Integer, JComponent> timeLabelTabel = new Hashtable<Integer, JComponent>();
		for (int i = 0; i <= 60; i += 15) timeLabelTabel.put(i * 60, new JLabel(String.format("%d min", i)));

		initSlider(sliderOffsetSeconds, 15 * 60, 60, timeLabelTabel);
		initSpinner(spinnerOffsetDays);
		initSpinner(spinnerOffsetHours);

		initSlider(sliderUpPeriodSeconds, 15 * 60, 60, timeLabelTabel);
		initSpinner(spinnerUpPeriodDays);
		initSpinner(spinnerUpPeriodHours);
		initSpinner(spinnerUpPeriodRepeat);
		initSpinner(spinnerUpOffset);
		initSpinner(spinnerUpAmplitude);
		initSpinner(spinnerUpFactor);

		initSlider(sliderDownPeriodSeconds, 15 * 60, 60, timeLabelTabel);
		initSpinner(spinnerDownPeriodDays);
		initSpinner(spinnerDownPeriodHours);
		initSpinner(spinnerDownPeriodRepeat);
		initSpinner(spinnerDownOffset);
		initSpinner(spinnerDownAmplitude);
		initSpinner(spinnerDownFactor);
	}

	private void layoutSlider(JPanel panel, JSlider slider, JSpinner spinnerDays, JSpinner spinnerHours) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(3, 3, 3, 3);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.gridx = 1; gbc.gridy = 1; gbc.weighty = 1; gbc.weightx = 0; gbc.gridheight = 2;
		panel.add(new JLabel("Period: "), gbc);
		gbc.gridx = 2; gbc.gridy = 1; gbc.weighty = 1; gbc.weightx = 1; gbc.gridheight = 2;
		panel.add(slider, gbc);
		gbc.gridx = 3; gbc.gridy = 1; gbc.weighty = 0; gbc.weightx = 0; gbc.gridheight = 1;
		panel.add(new JLabel(" + Days: "), gbc);
		gbc.gridx = 4; gbc.gridy = 1; gbc.weighty = 0; gbc.weightx = 0; gbc.gridheight = 1;
		panel.add(spinnerDays, gbc);
		gbc.gridx = 5; gbc.gridy = 1; gbc.weighty = 0; gbc.weightx = 0; gbc.gridheight = 1;
		panel.add(new JLabel(" Hours: "), gbc);
		gbc.gridx = 6; gbc.gridy = 1; gbc.weighty = 0; gbc.weightx = 0; gbc.gridheight = 1;
		panel.add(spinnerHours, gbc);
	}

	private void layoutPanel(JPanel panel, JSlider sliderPeriod, JSpinner spinnerPeriodDays, JSpinner spinnerPeriodHours, JSpinner spinnerPeriodRepeat, JSpinner spinnerOffset, JSpinner spinnerAmplitude, JSpinner spinnerFactor) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(3, 3, 3, 3);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		panel.setLayout(new GridBagLayout());
		layoutSlider(panel, sliderPeriod, spinnerPeriodDays, spinnerPeriodHours);
		gbc.gridx = 7; gbc.gridy = 1; gbc.weighty = 0; gbc.weightx = 0; gbc.gridheight = 1;
		panel.add(new JLabel(" Repeat: "), gbc);
		gbc.gridx = 8; gbc.gridy = 1; gbc.weighty = 0; gbc.weightx = 0; gbc.gridheight = 1;
		panel.add(spinnerPeriodRepeat, gbc);
		gbc.gridx = 3; gbc.gridy = 2; gbc.weighty = 0; gbc.weightx = 0; gbc.gridheight = 1;
		panel.add(new JLabel(" Offset: "), gbc);
		gbc.gridx = 4; gbc.gridy = 2; gbc.weighty = 0; gbc.weightx = 0; gbc.gridheight = 1;
		panel.add(spinnerOffset, gbc);
		gbc.gridx = 5; gbc.gridy = 2; gbc.weighty = 0; gbc.weightx = 0; gbc.gridheight = 1;
		panel.add(new JLabel(" Amplitude: "), gbc);
		gbc.gridx = 6; gbc.gridy = 2; gbc.weighty = 0; gbc.weightx = 0; gbc.gridheight = 1;
		panel.add(spinnerAmplitude, gbc);
		gbc.gridx = 7; gbc.gridy = 2; gbc.weighty = 0; gbc.weightx = 0; gbc.gridheight = 1;
		panel.add(new JLabel(" Factor: "), gbc);
		gbc.gridx = 8; gbc.gridy = 2; gbc.weighty = 0; gbc.weightx = 0; gbc.gridheight = 1;
		panel.add(spinnerFactor, gbc);
	}

	private void layoutTopPanel(JPanel panel, JSlider sliderPeriod, JSpinner spinnerPeriodDays, JSpinner spinnerPeriodHours, JCheckBox checkMult) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(3, 3, 3, 3);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		panel.setLayout(new GridBagLayout());
		layoutSlider(panel, sliderPeriod, spinnerPeriodDays, spinnerPeriodHours);
		gbc.gridx = 5; gbc.gridy = 2; gbc.weighty = 0; gbc.weightx = 0; gbc.gridheight = 1;
		panel.add(new JLabel(" Multiply: "), gbc);
		gbc.gridx = 6; gbc.gridy = 2; gbc.weighty = 0; gbc.weightx = 0; gbc.gridheight = 1;
		panel.add(checkMult, gbc);
	}

	private void layoutComponents() {
		setLayout(new GridLayout(3, 1));
		add(panelTop);
		add(panelUp);
		add(panelDown);

		layoutTopPanel(panelTop, sliderOffsetSeconds, spinnerOffsetDays, spinnerOffsetHours, checkMultiply);
		layoutPanel(panelUp, sliderUpPeriodSeconds, spinnerUpPeriodDays, spinnerUpPeriodHours, spinnerUpPeriodRepeat, spinnerUpOffset, spinnerUpAmplitude, spinnerUpFactor);
		layoutPanel(panelDown, sliderDownPeriodSeconds, spinnerDownPeriodDays, spinnerDownPeriodHours, spinnerDownPeriodRepeat, spinnerDownOffset, spinnerDownAmplitude, spinnerDownFactor);
	}

	private void initSlider(final JSlider slider, int major, int minor, Dictionary<Integer, JComponent> labelTable) {
		slider.setMajorTickSpacing(major);
		slider.setMinorTickSpacing(minor);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		if (labelTable != null)
			slider.setLabelTable(labelTable);

		slider.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				slider.setSnapToTicks((e.getModifiersEx() & InputEvent.SHIFT_DOWN_MASK) == InputEvent.SHIFT_DOWN_MASK);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				slider.setSnapToTicks(false);
			}
		});
	}

	private void updateSlider(long period, JSlider slider, JSpinner spinnerDays, JSpinner spinnerHours) {
		int seconds = (int)((period / (1000L)) % 60);
		int hours = (int)((period / (60 * 60 * 1000L)) % 24);
		int days = (int)((period / (24 * 60 * 60 * 1000L)));

		slider.setValue(seconds);
		spinnerHours.setValue((double)hours);
		spinnerDays.setValue((double)days);
	}

	private void initSpinner(JSpinner spinner) {
		spinner.setMinimumSize(new Dimension(75, spinner.getMinimumSize().height));
		spinner.setPreferredSize(new Dimension(75, spinner.getPreferredSize().height));
		spinner.setEditor(new JSpinner.NumberEditor(spinner, "0.00"));
	}

	private long getSliderValue(JSlider slider, JSpinner spinnerDays, JSpinner spinnerHours) {
		return slider.getValue() * 1000L +
			(long)(((SpinnerNumberModel)spinnerDays.getModel()).getNumber().doubleValue() * (24 * 60 * 60 * 1000L)) +
			(long)(((SpinnerNumberModel)spinnerHours.getModel()).getNumber().doubleValue() * (60 * 60 * 1000L));
	}

	private void initSliderListeners(final JSlider slider, final JSpinner spinnerDays, final JSpinner spinnerHours, String methodName) {
		try {
			final Method method = AbstractPeriodicDataGenerator.class.getDeclaredMethod(methodName, long.class);
			method.setAccessible(true);
			ChangeListener listener = new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					try {
						method.invoke(generator, getSliderValue(slider, spinnerDays, spinnerHours));
						firePropertyChange(DataGenerator.property, 0, System.currentTimeMillis());
					}
					catch (Exception ex) {
						Exceptions.printStackTrace(ex);
					}
				}
			};
			slider.addChangeListener(listener);
			spinnerDays.addChangeListener(listener);
			spinnerHours.addChangeListener(listener);
		}
		catch (Exception ex) {
			Exceptions.printStackTrace(ex);
		}
	}

	private void initListeners() {
		initSliderListeners(sliderOffsetSeconds, spinnerOffsetDays, spinnerOffsetHours, "setOffset");
		initSliderListeners(sliderUpPeriodSeconds, spinnerUpPeriodDays, spinnerUpPeriodHours, "setUpPeriod");
		initSliderListeners(sliderDownPeriodSeconds, spinnerDownPeriodDays, spinnerDownPeriodHours, "setDownPeriod");


		// Up misc listener
		spinnerUpPeriodRepeat.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				generator.setUpRepeat(((SpinnerNumberModel)(spinnerUpPeriodRepeat.getModel())).getNumber().intValue());
				firePropertyChange(DataGenerator.property, 0, System.currentTimeMillis());
			}
		});

		spinnerUpOffset.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				generator.setUpOffset(((SpinnerNumberModel)(spinnerUpOffset.getModel())).getNumber().doubleValue());
				firePropertyChange(DataGenerator.property, 0, System.currentTimeMillis());
			}
		});
		
		spinnerUpAmplitude.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				generator.setUpAmplitude(((SpinnerNumberModel)(spinnerUpAmplitude.getModel())).getNumber().doubleValue());
				firePropertyChange(DataGenerator.property, 0, System.currentTimeMillis());
			}
		});

		spinnerUpFactor.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				generator.setUpModifier(((SpinnerNumberModel)(spinnerUpFactor.getModel())).getNumber().doubleValue());
				firePropertyChange(DataGenerator.property, 0, System.currentTimeMillis());
			}
		});

		// Down misc listeners
		spinnerDownPeriodRepeat.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				generator.setDownRepeat(((SpinnerNumberModel)(spinnerDownPeriodRepeat.getModel())).getNumber().intValue());
				firePropertyChange(DataGenerator.property, 0, System.currentTimeMillis());
			}
		});

		spinnerDownOffset.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				generator.setDownOffset(((SpinnerNumberModel)(spinnerDownOffset.getModel())).getNumber().doubleValue());
				firePropertyChange(DataGenerator.property, 0, System.currentTimeMillis());
			}
		});
		
		spinnerDownAmplitude.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				generator.setDownAmplitude(((SpinnerNumberModel)(spinnerDownAmplitude.getModel())).getNumber().doubleValue());
				firePropertyChange(DataGenerator.property, 0, System.currentTimeMillis());
			}
		});

		spinnerDownFactor.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				generator.setDownModifier(((SpinnerNumberModel)(spinnerDownFactor.getModel())).getNumber().doubleValue());
				firePropertyChange(DataGenerator.property, 0, System.currentTimeMillis());
			}
		});

		checkMultiply.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				generator.setMultiply(checkMultiply.isSelected());
				firePropertyChange(DataGenerator.property, 0, System.currentTimeMillis());
			}
		});
	}

	private void initValues() {
		updateSlider(generator.getOffset(), sliderOffsetSeconds, spinnerOffsetDays, spinnerOffsetHours);
		checkMultiply.setSelected(generator.isMultiply());

		updateSlider(generator.getUpPeriod(), sliderUpPeriodSeconds, spinnerUpPeriodDays, spinnerUpPeriodHours);
		spinnerUpPeriodRepeat.setValue(generator.getUpRepeat());
		spinnerUpOffset.setValue(generator.getUpOffset());
		spinnerUpAmplitude.setValue(generator.getUpAmplitude());
		spinnerUpFactor.setValue(generator.getUpModifier());

		updateSlider(generator.getDownPeriod(), sliderDownPeriodSeconds, spinnerDownPeriodDays, spinnerDownPeriodHours);
		spinnerDownPeriodRepeat.setValue(generator.getDownRepeat());
		spinnerDownOffset.setValue(generator.getDownOffset());
		spinnerDownAmplitude.setValue(generator.getDownAmplitude());
		spinnerDownFactor.setValue(generator.getDownModifier());
	}
}
