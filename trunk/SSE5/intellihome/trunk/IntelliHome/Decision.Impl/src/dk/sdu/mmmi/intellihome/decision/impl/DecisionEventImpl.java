
package dk.sdu.mmmi.intellihome.decision.impl;

import dk.sdu.mmmi.intellihome.analysis.AnalysisEvent;
import dk.sdu.mmmi.intellihome.decision.DecisionEvent;

/**
 *
 * @author jemr
 */
public class DecisionEventImpl implements DecisionEvent, Comparable<DecisionEvent> {

	public static DecisionEventImpl getComparableEvent(final String eventType) {
		return new DecisionEventImpl(new AnalysisEvent() {

			@Override
			public String getEventType() {
				return eventType;
			}

			@Override
			public long getDistance() {
				return 0;
			}

			@Override
			public double getProbability() {
				return 0;
			}
		});
	}

	private final AnalysisEvent analysisEvent;

	public DecisionEventImpl(AnalysisEvent analysisEvent) {
		this.analysisEvent = analysisEvent;
	}

	@Override
	public String getEventType() {
		return analysisEvent.getEventType();
	}

	@Override
	public long getDistance() {
		return analysisEvent.getDistance();
	}

	public AnalysisEvent getAnalysisEvent() {
		return analysisEvent;
	}

	@Override
	public int compareTo(DecisionEvent o) {
		return getEventType().compareTo(o.getEventType());
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof DecisionEvent) && compareTo((DecisionEvent)obj) == 0;
	}

	@Override
	public int hashCode() {
		return getEventType().hashCode();
	}

	@Override
	public String toString() {
		return String.format("DecisionEvent{%s, %d, %.1f%%}", getEventType(), getDistance(), getAnalysisEvent().getProbability() * 100.0);
	}


}
