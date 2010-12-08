
package dk.sdu.mmmi.intellihome.synthetic.climate.datasources;

import dk.sdu.mmmi.intellihome.synthetic.SyntheticDataSource;
import dk.sdu.mmmi.intellihome.synthetic.climate.ClimateDataSource;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
@ServiceProvider(service = SyntheticDataSource.class)
public class ClimateUC1 extends ClimateDataSource {

	public ClimateUC1() {
		super(1, "log_c1_uc1", -94608000000L);
	}

}
