
package dk.sdu.mmmi.intellihome.analysis.impl.onelevel;

import dk.sdu.mmmi.intellihome.analysis.AnalysisEvent;
import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author jemr
 */
class AnalysisDataEvent {
	private final DataEvent dataEvent;

	private HashMap<String, AnalysisDataEvent> forwardEvents = new HashMap<String, AnalysisDataEvent>();
	private HashMap<String, AnalysisDataEvent> backwardEvents = new HashMap<String, AnalysisDataEvent>();

	AnalysisDataEvent(DataEvent dataEvent) {
		this.dataEvent = dataEvent;
	}

	public String getEventType() {
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

	void registerForward(AnalysisDataEvent event) {
		forwardEvents.put(event.getEventType(), event);
	}

	void registerBackward(AnalysisDataEvent event) {
		backwardEvents.put(event.getEventType(), event);
	}

	boolean acceptsForward(AnalysisDataEvent event) {
		return !forwardEvents.containsKey(event.getEventType());
	}

	boolean acceptsBackward(AnalysisDataEvent event) {
		return !backwardEvents.containsKey(event.getEventType());
	}

	Collection<AnalysisDataEvent> getForwardEvents() {
		return forwardEvents.values();
	}

	Collection<AnalysisDataEvent> getBackwardEvents() {
		return backwardEvents.values();
	}
}
