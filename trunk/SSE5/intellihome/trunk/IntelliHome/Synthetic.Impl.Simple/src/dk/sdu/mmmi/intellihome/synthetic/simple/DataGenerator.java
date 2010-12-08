
package dk.sdu.mmmi.intellihome.synthetic.simple;

import java.io.Serializable;
import javax.swing.JComponent;

/**
 *
 * @author jemr
 */
public interface DataGenerator extends Serializable {

	public double getData(long timest, double prevValue);
	public boolean terminate();

	public final String property = "DataGenerator";
	public JComponent getConfigurationControls();
}
