
package dk.sdu.mmmi.intellihome.decision.impl;

import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author jemr
 */
public class DecisionPath {

	private List<DecisionPathNode> paths = new ArrayList<DecisionPathNode>();
	private final DecisionImpl decision;

	public DecisionPath(DecisionImpl decision, DataEvent parent) {
		this.decision = decision;
		paths.add(new DecisionPathNode(decision, parent));
	}

	List<DataEvent> getParents() {
		ArrayList<DataEvent> parents = new ArrayList<DataEvent>();
		for (DecisionPathNode path: paths)
			parents.add(path.getParent());
		return parents;
	}

	DecisionPathNode getLatest() {
		return paths.get(paths.size() - 1);
	}

	void confirmEvent(DataEvent event) {
		if (getLatest().confirm(event))
			paths.add(new DecisionPathNode(decision, event));
	}

	boolean negateEvent(DataEvent event, DataEvent negatedBy) {
		// XXX TODO XXX negative feedback check ?
		DecisionPathNode pathToNegate = getLatest();
		if (pathToNegate.getParent().equals(event)) {
			pathToNegate.cancel(negatedBy);
			paths.remove(paths.size() - 1);
			if (paths.isEmpty())
				return true;
			getLatest().removeLeaf(pathToNegate.getParent().getType());
		}
		return false;
	}

	void scheduleEvent(DecisionEventImpl event) {
		getLatest().scheduleEvent(event);
	}

	boolean isExpected(DataEvent event) {
		return getLatest().isExpected(event);
	}

	Set<DecisionEventImpl> getLeaves() {
		return getLatest().getLeaves();
	}

	void setLeaves(Set<DecisionEventImpl> newLeaves) {
		getLatest().setLeaves(newLeaves);
	}

	boolean isTimedOut() {
		return getLatest().isTimedOut();
	}

	boolean isScheduled(DataEvent event) {
		return getLatest().isScheduled(event);
	}

}
