
package dk.sdu.mmmi.intellihome.synthetic.periodic;

import dk.sdu.mmmi.intellihome.synthetic.simple.DataGenerator;
import dk.sdu.mmmi.intellihome.synthetic.simple.DataGeneratorFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
public class ReducerPeriodicDataGenerator implements DataGenerator {

	@ServiceProvider(service=DataGeneratorFactory.class)
	public static class ReducerPeriodicDataGeneratorFactory implements DataGeneratorFactory {
		public DataGenerator newInstance() {
			return new ReducerPeriodicDataGenerator();
		}

		public String getName() {
			return "Reducer";
		}
	}

	private double previousValue = 0;
	private long previousTime = Long.MAX_VALUE;

	public double getData(long timest, double prevValue) {
		if (timest < previousTime || this.previousValue != prevValue) {
			previousTime = timest;
			previousValue = prevValue;
			return prevValue;
		}
		else {
			previousTime = timest;
			return Double.NaN;
		}
	}

	public boolean terminate() {
		return false;
	}

	private transient JPanel configurationPanel = new JPanel();
	public synchronized JComponent getConfigurationControls() {
		return configurationPanel;
	}
}
