
package dk.sdu.mmmi.intellihome.synthetic.climate.datasources;

import dk.sdu.mmmi.intellihome.synthetic.SyntheticDataSource;
import dk.sdu.mmmi.intellihome.synthetic.climate.ClimateDataSource;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
@ServiceProvider(service = SyntheticDataSource.class)
public class ClimateUC3 extends ClimateDataSource {

	public ClimateUC3() {
		super(3, "log_c1_uc3", -94608000000L);
	}

}
