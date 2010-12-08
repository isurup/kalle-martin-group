
package dk.sdu.mmmi.intellihome.analysis.impl.simple;

import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author jemr
 */
class AnalysisEvent {
	private final DataEvent dataEvent;

	private HashMap<String, AnalysisEvent> forwardEvents = new HashMap<String, AnalysisEvent>();
	private HashMap<String, AnalysisEvent> backwardEvents = new HashMap<String, AnalysisEvent>();

	AnalysisEvent(DataEvent dataEvent) {
		this.dataEvent = dataEvent;
	}

	String getType() {
		return dataEvent.getType();
	}

	long getTimestamp() {
		return dataEvent.getTimeInMillis();
	}

	double getValue() {
		return dataEvent.getValue();
	}

	DataEvent getDataEvent() {
		return dataEvent;
	}

	void registerForward(AnalysisEvent event) {
		forwardEvents.put(event.getType(), event);
	}

	void registerBackward(AnalysisEvent event) {
		backwardEvents.put(event.getType(), event);
	}

	boolean acceptsForward(AnalysisEvent event) {
		return !forwardEvents.containsKey(event.getType());
	}

	boolean acceptsBackward(AnalysisEvent event) {
		return !backwardEvents.containsKey(event.getType());
	}

	Collection<AnalysisEvent> getForwardEvents() {
		return forwardEvents.values();
	}

	Collection<AnalysisEvent> getBackwardEvents() {
		return backwardEvents.values();
	}


}
