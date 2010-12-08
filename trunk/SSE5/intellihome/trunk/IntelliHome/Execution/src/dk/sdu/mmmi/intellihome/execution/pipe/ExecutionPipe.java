
package dk.sdu.mmmi.intellihome.execution.pipe;

import dk.sdu.mmmi.intellihome.execution.Execution;
import dk.sdu.mmmi.intellihome.core.pipe.Pipe;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
@ServiceProvider(service=Pipe.class, position=2000)
public class ExecutionPipe extends Pipe<Execution> {

	@Override
	public Class<Execution> getAPI() {
		return Execution.class;
	}

	@Override
	public String getName() {
		return "Execution";
	}

}
