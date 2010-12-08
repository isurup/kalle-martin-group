
package dk.sdu.mmmi.intellihome.synthetic.periodic;

import dk.sdu.mmmi.intellihome.synthetic.simple.DataGenerator;
import dk.sdu.mmmi.intellihome.synthetic.simple.DataGeneratorFactory;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
public class TrianglePeriodicDataGenerator extends AbstractPeriodicDataGenerator {

	@ServiceProvider(service=DataGeneratorFactory.class)
	public static class TrianglePeriodicDataGeneratorFactory implements DataGeneratorFactory {
		public DataGenerator newInstance() {
			return new TrianglePeriodicDataGenerator();
		}

		public String getName() {
			return "Triangle generator";
		}
	}

	@Override
	protected double generatePeriodData(double x, boolean isUp) {
		return 1.0 - Math.abs(1.0 - x / ((isUp ? getUpPeriod() : getDownPeriod()) / 2.0));
	}
}
