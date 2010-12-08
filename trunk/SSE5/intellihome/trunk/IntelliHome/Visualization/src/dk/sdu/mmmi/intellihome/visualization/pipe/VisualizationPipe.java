
package dk.sdu.mmmi.intellihome.visualization.pipe;

import dk.sdu.mmmi.intellihome.core.pipe.Pipe;
import dk.sdu.mmmi.intellihome.visualization.Visualization;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
@ServiceProvider(service=Pipe.class, position=5000)
public class VisualizationPipe extends Pipe<Visualization> {

	@Override
	public Class<Visualization> getAPI() {
		return Visualization.class;
	}

	@Override
	public String getName() {
		return "Visualization";
	}

}
