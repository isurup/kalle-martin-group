
package dk.sdu.mmmi.intellihome.synthetic.periodic;

import dk.sdu.mmmi.intellihome.synthetic.simple.DataGenerator;
import dk.sdu.mmmi.intellihome.synthetic.simple.DataGeneratorFactory;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
public class ThresholdPeriodicDataGenerator implements DataGenerator {

	@ServiceProvider(service=DataGeneratorFactory.class)
	public static class ThresholdPeriodicDataGeneratorFactory implements DataGeneratorFactory {
		public DataGenerator newInstance() {
			return new ThresholdPeriodicDataGenerator();
		}

		public String getName() {
			return "Threshold";
		}
	}

	private double threshold = 1.0;
	private double lowValue = 0;
	private double highValue = 1.0;

	public double getData(long timest, double prevValue) {
		return prevValue < getThreshold() ? getLowValue() : getHighValue();
	}

	public boolean terminate() {
		return false;
	}

	private transient JPanel configurationPanel;
	public synchronized JComponent getConfigurationControls() {
		if (configurationPanel == null)
			configurationPanel = generateConfigPanel();

		return configurationPanel;
	}

	private JPanel generateConfigPanel() {
		final JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(3, 3, 3, 3);

		final JSpinner spinnerThreshold = new JSpinner(new SpinnerNumberModel(getThreshold(), 0.0, Double.MAX_VALUE, 0.1));
		final JSpinner spinnerLowValue = new JSpinner(new SpinnerNumberModel(getLowValue(), -Double.MAX_VALUE, Double.MAX_VALUE, 0.1));
		final JSpinner spinnerHighValue = new JSpinner(new SpinnerNumberModel(getHighValue(), -Double.MAX_VALUE, Double.MAX_VALUE, 0.1));

		Dimension prefSize = new Dimension(120, spinnerThreshold.getPreferredSize().height);
		spinnerThreshold.setPreferredSize(prefSize);
		spinnerLowValue.setPreferredSize(prefSize);
		spinnerHighValue.setPreferredSize(prefSize);

		spinnerThreshold.setEditor(new JSpinner.NumberEditor(spinnerThreshold, "0.00"));
		spinnerLowValue.setEditor(new JSpinner.NumberEditor(spinnerLowValue, "0.00"));
		spinnerHighValue.setEditor(new JSpinner.NumberEditor(spinnerHighValue, "0.00"));

		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(new JLabel(" Threshold: "), gbc);
		gbc.gridx++;
		panel.add(spinnerThreshold, gbc);
		gbc.gridx++;
		panel.add(new JLabel(" Low value: "), gbc);
		gbc.gridx++;
		panel.add(spinnerLowValue, gbc);
		gbc.gridx++;
		panel.add(new JLabel(" High value: "), gbc);
		gbc.gridx++;
		panel.add(spinnerHighValue, gbc);

		spinnerThreshold.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				setThreshold(((SpinnerNumberModel)spinnerThreshold.getModel()).getNumber().doubleValue());
				panel.firePropertyChange(DataGenerator.property, 0, System.currentTimeMillis());
			}
		});
		spinnerLowValue.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				setLowValue(((SpinnerNumberModel)spinnerLowValue.getModel()).getNumber().doubleValue());
				panel.firePropertyChange(DataGenerator.property, 0, System.currentTimeMillis());
			}
		});
		spinnerHighValue.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				setHighValue(((SpinnerNumberModel)spinnerHighValue.getModel()).getNumber().doubleValue());
				panel.firePropertyChange(DataGenerator.property, 0, System.currentTimeMillis());
			}
		});

		return panel;
	}

	protected double getThreshold() {
		return threshold;
	}

	protected void setThreshold(double threshold) {
		this.threshold = threshold;
	}

	protected double getLowValue() {
		return lowValue;
	}

	protected void setLowValue(double lowValue) {
		this.lowValue = lowValue;
	}

	protected double getHighValue() {
		return highValue;
	}

	protected void setHighValue(double highValue) {
		this.highValue = highValue;
	}
}
