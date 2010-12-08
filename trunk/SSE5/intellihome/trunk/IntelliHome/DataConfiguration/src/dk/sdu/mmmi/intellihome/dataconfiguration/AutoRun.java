
package dk.sdu.mmmi.intellihome.dataconfiguration;

import dk.sdu.mmmi.intellihome.core.pipe.Pipe;
import dk.sdu.mmmi.intellihome.core.api.ConfigurationManager;
import org.openide.modules.ModuleInstall;
import org.openide.util.Lookup;
import org.openide.util.Lookup.Result;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;

/**
 *
 * @author jemr
 */
public class AutoRun extends ModuleInstall {

	@Override
	public void restored() {
		final Result<Pipe> result = Lookup.getDefault().lookupResult(Pipe.class);
		Lookup.getDefault().lookup(ConfigurationManager.class);
		Lookup.getDefault().lookup(ConfigurationManagerImpl.class).buildPipe(result.allInstances());
		
		result.addLookupListener(new LookupListener() {
			public void resultChanged(LookupEvent le) {
				Lookup.getDefault().lookup(ConfigurationManagerImpl.class).buildPipe(result.allInstances());
			}
		});
	}
}
