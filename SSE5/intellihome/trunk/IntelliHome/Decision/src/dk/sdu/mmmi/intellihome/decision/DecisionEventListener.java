
package dk.sdu.mmmi.intellihome.decision;

import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;

/**
 *
 * @author jemr
 */
public interface DecisionEventListener {
	public void cancelEvent(DecisionEvent event, DataEvent triggerEvent);
	public void scheduleEvent(DecisionEvent event, DataEvent triggerEvent);
}
