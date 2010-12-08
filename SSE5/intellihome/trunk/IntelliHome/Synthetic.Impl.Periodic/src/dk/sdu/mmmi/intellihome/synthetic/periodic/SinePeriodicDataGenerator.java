
package dk.sdu.mmmi.intellihome.synthetic.periodic;

import dk.sdu.mmmi.intellihome.synthetic.simple.DataGenerator;
import dk.sdu.mmmi.intellihome.synthetic.simple.DataGeneratorFactory;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
public class SinePeriodicDataGenerator extends AbstractPeriodicDataGenerator {

	@ServiceProvider(service=DataGeneratorFactory.class)
	public static class SinePeriodicDataGeneratorFactory implements DataGeneratorFactory {
		public DataGenerator newInstance() {
			return new SinePeriodicDataGenerator();
		}

		public String getName() {
			return "Sine generator";
		}
	}

	@Override
	protected double generatePeriodData(double x, boolean isUp) {
		return Math.sin(x / ((isUp ? getUpPeriod() : getDownPeriod()) / Math.PI));
	}
}
