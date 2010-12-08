
package dk.sdu.mmmi.intellihome.execution.impl.standard;

import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;

/**
 *
 * @author jemr
 */
interface ExecutorAction {
	public String getEventType();
	public void cancelAction(DataEvent event);
}
