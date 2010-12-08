package dk.sdu.mmmi.intellihome.analysis.impl.twolevel;

import dk.sdu.mmmi.intellihome.analysis.AnalysisEvent;
import dk.sdu.mmmi.intellihome.analysis.impl.twolevel.DBSCAN.DataPoint;
import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author jemr
 */
class AnalysisNode {
	private static enum MetaDataLevel { YES, NO, MAYBE; }

	private MetaDataLevel getMetaDataLevel(ArrayList<NodeData> nodes, AnalysisMetaData metaData) {
		for (String metaDataType : metaData.getMetaDataTypes()) {
			System.out.printf("Scanning for metadata %s with value %.1f\n", metaDataType, metaData.getValue(metaDataType));
			List<DBSCAN.DataPoint> clusterPoints = new ArrayList<DBSCAN.DataPoint>(nodes.size());
			double max = 255;
			double min = 0;//Double.MAX_VALUE;
			for (NodeData n : nodes) {
				double metaValue = n.metaData.getValue(metaDataType);
				//max = Math.max(max, metaValue);
				//min = Math.min(min, metaValue);
				clusterPoints.add(new DBSCAN.DataPoint(metaValue, 1));
			}

			double eps = (max - min) / 20.0;
			System.out.println("Cluster points before: " + clusterPoints.size());
			clusterPoints = filterPoints(clusterPoints, min, max, 0.025);
			System.out.println("Cluster points after: " + clusterPoints.size());
			DBSCAN dbscan = new DBSCAN(clusterPoints, 5, 8, metaDataType);
			List<DBSCAN.Cluster> clusters = dbscan.getClusters();
			double totalClusterSpan = 0;
			for (DBSCAN.Cluster cluster: clusters) {
				System.out.printf("Found cluster: [%.1f; %.1f]\n", cluster.getMinX(), cluster.getMaxX());
				totalClusterSpan += (cluster.getMaxX() - cluster.getMinX());
			}

			if (totalClusterSpan == 0 || (totalClusterSpan / (max - min)) > 0.5) {
				// The clusters fill over 50% of the space, we can't really say
				// anything decisesive based on this information
				System.out.printf("Total clusters span: %.1f (%.2f)\n", totalClusterSpan, (totalClusterSpan / (max - min)));
				continue;
			}

			System.out.printf("Found %d cluster\n", clusters.size());

			for (DBSCAN.Cluster cluster: clusters) {
				double val = metaData.getValue(metaDataType);
				if (val < cluster.getMaxX() && val > cluster.getMinX()) {
					System.out.printf("Found a sure cluster [%.2f; %.2f] - Meta was: %.2f\n", cluster.getMinX(), cluster.getMaxX(), val);
					return MetaDataLevel.YES;
				}
			}
			return MetaDataLevel.NO;
		}

		return MetaDataLevel.MAYBE;

	}

	private List<DataPoint> filterPoints(List<DataPoint> clusterPoints, double min, double max, double limit) {
		Collections.sort(clusterPoints, new Comparator<DBSCAN.DataPoint>() {
			@Override
			public int compare(DataPoint o1, DataPoint o2) {
				return Double.compare(o1.x, o2.x);
			}
		});

		int minCountPerBlock = (int)(clusterPoints.size() * limit);
		double eps = (max - min) / 20.0;
		double next = min + eps;
		int count = 0;
		List<DataPoint> currentBlock = new ArrayList<DataPoint>();
		List<DataPoint> clusterPoints2 = new ArrayList<DataPoint>();
		for (DataPoint p : clusterPoints) {
			if (p.x < next) {
				currentBlock.add(p);
				count++;
			}
			else {
				if (count >= minCountPerBlock)
					clusterPoints2.addAll(currentBlock);
				currentBlock.clear();
				currentBlock.add(p);
				count = 1;
			}
		}
		if (count >= minCountPerBlock)
			clusterPoints2.addAll(currentBlock);

		return clusterPoints2;
	}

	private static class NodeData {
		final DataEvent event;
		final AnalysisMetaData metaData;
		final long distance;

		public NodeData(DataEvent event, AnalysisMetaData metaData, long distance) {
			this.event = event;
			this.metaData = metaData;
			this.distance = distance;
		}
	}
	private HashMap<String, ArrayList<NodeData>> data = new HashMap<String, ArrayList<NodeData>>();
	private int counter = 0;
	private int max = 0;
	private String key;

	public AnalysisNode(String key) {
		this.key = key;
	}

	Set<AnalysisEvent> getCandidates(AnalysisMetaData metaData) {
		Set<String> metaDataTypes = metaData.getMetaDataTypes();
		Set<AnalysisEvent> result = new HashSet<AnalysisEvent>();

		for (Map.Entry<String, ArrayList<NodeData>> entry : data.entrySet()) {
			if (entry.getValue().size() < 2)
				continue;

			double prob = (double)(entry.getValue().size() / max);

			if (entry.getValue().size() > 20 && !metaDataTypes.isEmpty()) {
				MetaDataLevel level = getMetaDataLevel(entry.getValue(), metaData);
				switch (level) {
					case YES:
						prob = 1.0;
						break;
					case NO:
						continue;
				}
			}

			// fallback is a simple scan
			long sum = 0;
			for (NodeData n : entry.getValue())
				sum += n.distance;
			result.add(new AnalysisEventImpl(entry.getKey(), sum / entry.getValue().size(), prob));
		}

		return result;
	}

	void add(DataEvent event, AnalysisMetaData metaData, long distance) {
		ArrayList<NodeData> list = data.get(event.getType());
		if (list == null) {
			list = new ArrayList<NodeData>();
			data.put(event.getType(), list);
		}
		list.add(new NodeData(event, metaData, distance));
		max = Math.max(max, list.size());
		counter++;
	}

	@Override
	public String toString() {
		return String.format("AnalysisNode{%s}", key);
	}
}
