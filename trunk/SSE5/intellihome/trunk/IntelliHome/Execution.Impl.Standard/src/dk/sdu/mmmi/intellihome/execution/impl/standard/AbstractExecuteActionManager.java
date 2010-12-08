
package dk.sdu.mmmi.intellihome.execution.impl.standard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jemr
 */
abstract class AbstractExecuteActionManager {
	// <editor-fold defaultstate="collapsed" desc="Manager code">
	private final ArrayList<ExecutorAction> actions = new ArrayList<ExecutorAction>();

	protected void remove(ExecutorAction action) {
		actions.remove(action);
	}

	protected ExecutorAction add(ExecutorAction action) {
		actions.add(action);
		return action;
	}

	public boolean isEmpty() {
		return actions.isEmpty();
	}

	public List<ExecutorAction> getActions() {
		return Collections.unmodifiableList(actions);
	}
	// </editor-fold>
}
