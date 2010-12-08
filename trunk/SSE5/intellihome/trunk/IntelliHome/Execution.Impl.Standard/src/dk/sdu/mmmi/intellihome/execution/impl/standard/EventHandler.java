
package dk.sdu.mmmi.intellihome.execution.impl.standard;

import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.core.api.ConfigurationManager;
import dk.sdu.mmmi.intellihome.decision.Decision;
import dk.sdu.mmmi.intellihome.decision.DecisionEvent;
import dk.sdu.mmmi.intellihome.decision.DecisionEventListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.openide.util.Lookup;

/**
 * Handles incomming events from the underlying DataSource, which is assumed to
 * be the source of "true" events.
 * 
 * If there are not listeners to the type of event that happens, it passes on the
 * event to the DataSink unharmed.
 * 
 * If any listeners is present, the listeners are informed of this, and the event
 * is NOT passed on to the DataSink.
 *
 * Rest is basically listener handling.
 *
 * @author jemr
 */
public class EventHandler implements DecisionEventListener {

	private final ExecutorDataFilter filter;

	EventHandler(ExecutorDataFilter filter) {
		this.filter = filter;
		// XXX TODO, Fix with Config
		Lookup.getDefault().lookup(Decision.class).addEventListener(this);
	}

	private HashMap<String, Set<ExecutorEventListener>> counterListeners = new HashMap<String, Set<ExecutorEventListener>>();

	public void handleEvent(DataEvent event) {
		// If no listeners for the event, let it pass through unharmed
		// If at least one even listener is present, then there must be something
		// that's delaying that event, so don't pass those events on to the next sink

		// TODO TODO This logic should probably be changed somehow, since we also need to
		// it to set up an ExecutorAction if there are none at the moment.

		// Only discrete events can trigger, so release non-discrete
		if (event.getDiscreteLevels() == 0) {
			filter.releaseEvent(event);
		}
		else {
			// If a counter listener exists for the current event, then it is
			// currently in the execution queue there, so inform the listerners

			Set<ExecutorEventListener> counterEventList = getListenersForEventType(event.getType());

			if (!counterEventList.isEmpty()) {
				for (ExecutorEventListener listener: counterEventList)
					listener.onEvent(event);
			}
			else {
				// XXX TODO, Fix with Config
				if (!Lookup.getDefault().lookup(Decision.class).confirmEvent(event))
					filter.releaseEvent(event);
			}
		}
	}

	/**
	 * Helper method, to ensure that a Set is created when needed, so we
	 * don't have to worry about null pointers being returned.
	 *
	 * Note: The set generated is thread-safe, and allows concurrent modification
	 * 
	 * @param eventType
	 * @return
	 */
	private synchronized Set<ExecutorEventListener> getListenersForEventType(String eventType) {
		HashMap<String, Set<ExecutorEventListener>> listenerMap = counterListeners;
		Set<ExecutorEventListener> set = listenerMap.get(eventType);
		if (set == null) {
			// Note: Set from a ConcurrentHashMap is used, so concurrent modification is possible
			// in case a listener is removed from an action firing, while we are iterating over the listener.
			set = Collections.newSetFromMap(new ConcurrentHashMap<ExecutorEventListener, Boolean>());
			listenerMap.put(eventType, set);
		}
		return set;
	}

	synchronized void addEventListener(String eventType, ExecutorEventListener listener) {
		getListenersForEventType(eventType).add(listener);
	}

	synchronized void removeEventListener(String eventType, ExecutorEventListener listener) {
		getListenersForEventType(eventType).remove(listener);
	}

	synchronized void addEventListener(List<String> eventTypes, ExecutorEventListener listener) {
		for (String eventType: eventTypes)
			addEventListener(eventType, listener);
	}
	synchronized void removeEventListener(List<String> eventTypes, ExecutorEventListener listener) {
		for (String eventType: eventTypes)
			removeEventListener(eventType, listener);
	}

	public void cancelEvent(DecisionEvent event, DataEvent triggerEvent) {
		ExecutorAction foundAction = null;
		for (ExecutorAction action:	ExecutorScheduledActionManager.getInstance().getActions()) {
			if (action.getEventType().equals(event.getEventType())) {
				foundAction = action;
				break;
			}
		}
		// cancel out of loop to eliminate modifying the list of actions while iterating it
		if (foundAction != null)
			foundAction.cancelAction(triggerEvent);
	}

	public void scheduleEvent(DecisionEvent event, DataEvent triggerEvent) {
		ExecutorScheduledActionManager.getInstance().newAction(event, triggerEvent, this);
	}

	ExecutorDataFilter getFilter() {
		return filter;
	}
}
