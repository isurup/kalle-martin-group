
package dk.sdu.mmmi.intellihome.synthetic.climate.datasources;

import dk.sdu.mmmi.intellihome.synthetic.SyntheticDataSource;
import dk.sdu.mmmi.intellihome.synthetic.climate.ClimateDataSource;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
@ServiceProvider(service = SyntheticDataSource.class)
public class ClimateUC4 extends ClimateDataSource {

	public ClimateUC4() {
		super(4, "log_c1_uc4", -94608000000L);
	}

}
