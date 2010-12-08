
package dk.sdu.mmmi.intellihome.execution.impl.standard;

import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;

/**
 *
 * @author jemr
 */
interface ExecutorEventListener {
	void onEvent(DataEvent event);
}
