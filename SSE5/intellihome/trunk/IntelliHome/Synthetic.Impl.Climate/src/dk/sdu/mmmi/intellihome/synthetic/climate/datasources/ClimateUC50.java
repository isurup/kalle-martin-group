
package dk.sdu.mmmi.intellihome.synthetic.climate.datasources;

import dk.sdu.mmmi.intellihome.synthetic.SyntheticDataSource;
import dk.sdu.mmmi.intellihome.synthetic.climate.ClimateDataSource;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
@ServiceProvider(service = SyntheticDataSource.class)
public class ClimateUC50 extends ClimateDataSource {

	public ClimateUC50() {
		super(50, "log_c1_uc50", -94608000000L);
	}

}
