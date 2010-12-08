
package dk.sdu.mmmi.intellihome.analysis;

/**
 *
 * @author jemr
 */
public interface AnalysisEvent {
	public String getEventType();
	public long getDistance();
	public double getProbability();
}
