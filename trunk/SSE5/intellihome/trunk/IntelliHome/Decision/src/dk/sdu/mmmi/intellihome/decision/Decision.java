
package dk.sdu.mmmi.intellihome.decision;

import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;

/**
 *
 * @author jemr
 */
public abstract class Decision {

	public abstract void negateEvent(DataEvent event, DataEvent negatedBy);
	public abstract boolean confirmEvent(DataEvent event);

	public final void addEventListener(DecisionEventListener decisionEventListener) {
		DecisionEventHandler.getInstance().addEventListener(decisionEventListener);
	}

	public final void removeEventListener(DecisionEventListener decisionEventListener) {
		DecisionEventHandler.getInstance().removeEventListener(decisionEventListener);
	}

	protected final void fireCancelEvent(DecisionEvent event, DataEvent triggerEvent) {
		DecisionEventHandler.getInstance().fireCancelEvent(event, triggerEvent);
	}

	protected final void fireScheduleEvent(DecisionEvent event, DataEvent triggerEvent) {
		DecisionEventHandler.getInstance().fireScheduleEvent(event, triggerEvent);
	}
}
