
package dk.sdu.mmmi.intellihome.dataconfiguration;

import dk.sdu.mmmi.intellihome.core.api.API;
import dk.sdu.mmmi.intellihome.core.pipe.Pipe;
import dk.sdu.mmmi.intellihome.core.api.ConfigurationManager;
import dk.sdu.mmmi.intellihome.dataconfiguration.gui.SelectAPIDialog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.prefs.Preferences;
import org.openide.util.NbPreferences;
import org.openide.util.lookup.ServiceProvider;
import org.openide.windows.WindowManager;

/**
 *
 * @author jemr
 */
@ServiceProvider(service=ConfigurationManager.class)
public class ConfigurationManagerImpl implements ConfigurationManager {
	public static final String EMPTY_API = "<Empty>";

	private ArrayList<Pipe> pipeList = new ArrayList<Pipe>();
	private Preferences preferences = NbPreferences.forModule(ConfigurationManagerImpl.class);

	void buildPipe(final Collection<? extends Pipe> pipes) {
		WindowManager.getDefault().invokeWhenUIReady(new Runnable() {
			public void run() {
				ArrayList<Pipe> newPipes = new ArrayList<Pipe>(pipes);
				newPipes.removeAll(pipeList);
				for (Pipe p: newPipes)
					initPipe(p);

				pipeList.clear();
				pipeList.addAll(pipes);

				// Rebuild the list
				Pipe prev = null;
				for (Pipe p: pipeList) {
					p.setSource(prev);
					initPipe(p);
					prev = p;
				}
			}
		});
	}

	private void initPipe(final Pipe p) {
		String storedApi = preferences.get(p.getName(), null);
		final Collection<API> apis = p.getAPIImplementations();
		if (EMPTY_API.equals(storedApi)) {
			setAPI(p, null);
			return;
		}
		else if(storedApi != null) {
			for (API api: apis) {
				if (storedApi.equals(api.getClass().getName())) {
					setAPI(p, api);
					return;
				}
			}
			// Previously stored api wasn't found, fall through to default handling
		}

		if (apis.size() == 1)
			setAPI(p, apis.iterator().next());
		else {
			setAPI(p, SelectAPIDialog.showDialog(p, apis));
		}
	}

	private void setAPI(Pipe pipe, API api) {
		pipe.setAPIImplementation(api);
		preferences.put(pipe.getName(), api != null ? api.getClass().getName() : EMPTY_API);
	}

	public <T extends API> T getAPIImplementation(Class<T> clazz) {
		for (Pipe<T> p: pipeList) {
			if (p.getAPI().equals(clazz))
				return p.getAPIImplementation();
		}
		return null;
	}
}
