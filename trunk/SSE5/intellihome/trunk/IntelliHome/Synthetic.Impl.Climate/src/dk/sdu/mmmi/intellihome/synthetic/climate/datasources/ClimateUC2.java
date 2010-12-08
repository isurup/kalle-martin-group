
package dk.sdu.mmmi.intellihome.synthetic.climate.datasources;

import dk.sdu.mmmi.intellihome.synthetic.SyntheticDataSource;
import dk.sdu.mmmi.intellihome.synthetic.climate.ClimateDataSource;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
@ServiceProvider(service = SyntheticDataSource.class)
public class ClimateUC2 extends ClimateDataSource {

	public ClimateUC2() {
		super(2, "log_c1_uc2", -94608000000L);
	}

}
