
package dk.sdu.mmmi.intellihome.decision;

import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author jemr
 */
final class DecisionEventHandler {
	private static final DecisionEventHandler instance = new DecisionEventHandler();

	static DecisionEventHandler getInstance() {
		return instance;
	}
	
	private final Set<DecisionEventListener> listeners = new HashSet<DecisionEventListener>();

	synchronized void addEventListener(DecisionEventListener decisionEventListener) {
		listeners.add(decisionEventListener);
	}

	synchronized void removeEventListener(DecisionEventListener decisionEventListener) {
		listeners.remove(decisionEventListener);
	}

	synchronized void fireCancelEvent(DecisionEvent event, DataEvent triggerEvent) {
		for (DecisionEventListener listener : listeners)
			listener.cancelEvent(event, triggerEvent);
	}

	synchronized void fireScheduleEvent(DecisionEvent event, DataEvent triggerEvent) {
		for (DecisionEventListener listener : listeners)
			listener.scheduleEvent(event, triggerEvent);
	}
}
