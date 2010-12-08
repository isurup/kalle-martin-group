
package dk.sdu.mmmi.intellihome.synthetic.periodic;

import dk.sdu.mmmi.intellihome.synthetic.simple.DataGenerator;
import dk.sdu.mmmi.intellihome.synthetic.simple.DataGeneratorFactory;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
public class SquarePeriodicDataGenerator extends AbstractPeriodicDataGenerator {

	@ServiceProvider(service=DataGeneratorFactory.class)
	public static class SquarePeriodicDataGeneratorFactory implements DataGeneratorFactory {
		public DataGenerator newInstance() {
			return new SquarePeriodicDataGenerator();
		}

		public String getName() {
			return "Square generator";
		}
	}

	public SquarePeriodicDataGenerator() {
		setUpAmplitude(1);
		setDownAmplitude(0);
	}


	@Override
	protected double generatePeriodData(double x, boolean isUp) {
		return 1.0;
	}

}
