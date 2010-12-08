
package dk.sdu.mmmi.intellihome.analysis.impl.simple;

import dk.sdu.mmmi.intellihome.analysis.impl.simple.cluster.DBSCAN.Cluster;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author jemr
 */
public class AnalysisStructure {

	public static class AnalysisResult {
		private final String eventType;
		private final double distance;
		private final double probability;

		public AnalysisResult(String eventType, double distance, double probability) {
			this.eventType = eventType;
			this.distance = distance;
			this.probability = probability;
		}

		public String getEventType() {
			return eventType;
		}

		public double getDistance() {
			return distance;
		}

		public double getProbability() {
			return probability;
		}
	}

	private HashMap<String, EventData> events = new HashMap<String, EventData>();

	private static class EventData {
		private List<Cluster> clusters = new ArrayList<Cluster>();

		List<Cluster> findClusters(long timestamp) {
			ArrayList<Cluster> result = new ArrayList<Cluster>();
			double time = Analyzer.getTime(timestamp);
			for (Cluster cluster: clusters) {
				if (cluster.getMinimumTime() <= time && cluster.getMaximumTime() >= time) {
					result.add(cluster);
				}
			}
			return result;
		}
	}


	List<AnalysisResult> getProbableNextEvent(AnalysisEvent event, long time) {
		List<Cluster> clusters = findClusters(event, time);
		
		ArrayList<AnalysisResult> result = new ArrayList<AnalysisResult>(clusters.size());
		int count = 0;
		for (Cluster c: clusters)
			count += c.getPoints().size();

		for (Cluster cluster: clusters)
			result.add(new AnalysisResult(cluster.getEventType(), cluster.getAverageDistance(), (double)cluster.getPoints().size() / count));
		
		return result;
	}

	private List<Cluster> findClusters(AnalysisEvent event, long time) {
		EventData data = events.get(event.getType());
		if (data == null)
			return Collections.emptyList();
		return data.findClusters(time);
	}
}
