
package dk.sdu.mmmi.intellihome.execution.impl.standard;

import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.execution.Execution;
import dk.sdu.mmmi.intellihome.core.pipe.Pipe;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
@ServiceProvider(service=Execution.class)
public class ExecutorDataFilter implements Execution {

	private EventHandler handler = new EventHandler(this);

	private LinkedHashMap<DataEvent, Boolean> withheldEvents = new LinkedHashMap<DataEvent, Boolean>();
	private Pipe pipe;

	synchronized void withholdEvent(DataEvent event) {
		withheldEvents.put(event, Boolean.FALSE);
	}

	synchronized void removeWithheldEvent(DataEvent event) {
		System.out.println("[REMOVE] " + event);
		withheldEvents.remove(event);
		releaseEvents();
	}

	synchronized void releaseEvent(DataEvent event) {
		System.out.println("[RELEASE] " + event);
		withheldEvents.put(event, Boolean.TRUE);
		releaseEvents();
	}

	synchronized void releaseEvents() {
		boolean forceReleaseAll = ExecutorScheduledActionManager.getInstance().isEmpty();
		for (Iterator<Map.Entry<DataEvent, Boolean>> it = withheldEvents.entrySet().iterator(); it.hasNext(); ) {
			Map.Entry<DataEvent, Boolean> entry = it.next();
			if (!forceReleaseAll && !entry.getValue())
				break;
			if (pipe != null && pipe.getSink() != null)
				pipe.getSink().incomingEvent(entry.getKey());
			it.remove();
		}
	}

	public String getName() {
		return "Execution Default";
	}

	public boolean incomingEvent(DataEvent event) {
		if (event.getDiscreteLevels() == 0)
			return true;
		else {
			withholdEvent(event);
			handler.handleEvent(event);
			return false;
		}
	}

	public void initialize(Pipe pipe) {
		this.pipe = pipe;
	}

	public void cleanup() {
		this.pipe = null;
	}
}
