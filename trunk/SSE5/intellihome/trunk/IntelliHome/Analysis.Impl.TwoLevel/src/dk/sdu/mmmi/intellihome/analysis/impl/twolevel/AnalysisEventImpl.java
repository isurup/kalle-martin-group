
package dk.sdu.mmmi.intellihome.analysis.impl.twolevel;

import dk.sdu.mmmi.intellihome.analysis.AnalysisEvent;

/**
 *
 * @author jemr
 */
public class AnalysisEventImpl implements AnalysisEvent {

	private final String eventType;
	private final long distance;
	private final double probability;

	public AnalysisEventImpl(String eventType, long distance, double probability) {
		this.eventType = eventType;
		this.distance = distance;
		this.probability = probability;
	}

	@Override
	public String getEventType() {
		return eventType;
	}

	@Override
	public long getDistance() {
		return distance;
	}

	@Override
	public double getProbability() {
		return probability;
	}

	@Override
	public String toString() {
		return String.format("2LvlEvent{%s, %.1f%%}", getEventType(), getProbability()*100.0);
	}
}
