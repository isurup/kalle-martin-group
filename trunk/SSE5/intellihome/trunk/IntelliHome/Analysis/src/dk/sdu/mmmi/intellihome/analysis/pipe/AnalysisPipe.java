
package dk.sdu.mmmi.intellihome.analysis.pipe;

import dk.sdu.mmmi.intellihome.analysis.Analysis;
import dk.sdu.mmmi.intellihome.core.pipe.Pipe;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */

@ServiceProvider(service=Pipe.class, position=4000)
public class AnalysisPipe extends Pipe<Analysis> {

	@Override
	public Class<Analysis> getAPI() {
		return Analysis.class;
	}

	@Override
	public String getName() {
		return "Analysis";
	}
}
