
package dk.sdu.mmmi.intellihome.decision.impl;

import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author jemr
 */
class DecisionPathNode {
	private DataEvent parent;
	private Set<DecisionEventImpl> leaves = new HashSet<DecisionEventImpl>();
	
	private final DecisionImpl decision;
	private DecisionEventImpl scheduledLeaf;
	private long timeout;

	public DecisionPathNode(DecisionImpl decision, DataEvent parent) {
		this.decision = decision;
		this.parent = parent;
	}

	boolean isExpected(DataEvent event) {
		return isExpected(DecisionEventImpl.getComparableEvent(event.getType()));
	}

	boolean isExpected(DecisionEventImpl event) {
		return leaves.contains(event);
	}

	void scheduleEvent(DecisionEventImpl event) {
		if (isExpected(event)) {
			scheduledLeaf = event;
		}
	}

	DecisionEventImpl getScheduledEvent() {
		return scheduledLeaf;
	}

	boolean isScheduled(DataEvent event) {
		return scheduledLeaf != null && scheduledLeaf.getEventType().equals(event.getType());
	}

	boolean confirm(DataEvent event) {
		if (isExpected(event)) {
			cancel(event);
			return true;
		}
		return false;
	}

	void cancel(DataEvent triggerEvent) {
		if (scheduledLeaf != null) {
			decision.cancelEvent(scheduledLeaf, triggerEvent);
		}
		scheduledLeaf = null;
	}

	Set<DecisionEventImpl> getLeaves() {
		return Collections.unmodifiableSet(leaves);
	}

	DataEvent getParent() {
		return parent;
	}

	void setLeaves(Set<DecisionEventImpl> newLeaves) {
		leaves.clear();
		long maxDistance = 0;
		for (DecisionEventImpl event: newLeaves) {
			maxDistance = Math.max(maxDistance, event.getDistance());
			leaves.add(event);
		}
		timeout = System.currentTimeMillis() + maxDistance * 2;
	}

	boolean isTimedOut() {
		return timeout < System.currentTimeMillis();
	}

	void removeLeaf(String eventType) {
		for (Iterator<DecisionEventImpl> it = leaves.iterator(); it.hasNext(); )
			if (it.next().getEventType().equals(eventType))
				it.remove();
	}
}
