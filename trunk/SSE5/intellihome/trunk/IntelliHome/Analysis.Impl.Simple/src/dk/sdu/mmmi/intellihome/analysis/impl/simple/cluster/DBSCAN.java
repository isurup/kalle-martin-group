
package dk.sdu.mmmi.intellihome.analysis.impl.simple.cluster;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author jemr
 */
public class DBSCAN {

	public static class Cluster {
		List<DataPoint> points = new ArrayList<DataPoint>();
		private String eventType;
		private boolean modified = false;
		private double minimumTime;
		private double maximumTime;
		private double averageTime;
		private double minimumDistance;
		private double maximumDistance;
		private double averageDistance;

		Cluster(String eventType) {
			this.eventType = eventType;
		}

		void add(DataPoint point) {
			if (point.cluster == null) {
				point.cluster = this;
				points.add(point);
				modified = true;
			}
		}

		private void evaluateStatistics() {
			if (modified) {
				minimumTime = Double.MAX_VALUE;
				maximumTime = 0;
				averageTime = 0;

				minimumDistance = Double.MAX_VALUE;
				maximumDistance = 0;
				averageDistance = 0;

				double count = points.size();
				for (DataPoint p: points) {
					minimumTime = Math.min(minimumTime, p.distance);
					maximumTime = Math.max(maximumTime, p.distance);
					averageTime += p.distance / count;

					minimumDistance = Math.min(minimumDistance, p.time);
					maximumDistance = Math.max(maximumDistance, p.time);
					averageDistance += p.time / count;
				}

				modified = false;
			}
		}

		public List<DataPoint> getPoints() {
			return points;
		}

		public double getMinimumTime() {
			evaluateStatistics();
			return minimumTime;
		}

		public double getMaximumTime() {
			evaluateStatistics();
			return maximumTime;
		}

		public double getAverageTime() {
			evaluateStatistics();
			return averageTime;
		}

		public double getMinimumDistance() {
			evaluateStatistics();
			return minimumDistance;
		}

		public double getMaximumDistance() {
			evaluateStatistics();
			return maximumDistance;
		}

		public double getAverageDistance() {
			evaluateStatistics();
			return averageDistance;
		}

		public String getEventType() {
			return eventType;
		}
	}

	public static class DataPoint {
		public final double distance;
		public final double time;
		boolean visited = false;
		boolean noise = false;
		Cluster cluster;
		List<DataPoint> neighbours;

		public DataPoint(double distance, double time) {
			this.distance = distance;
			this.time = time;
		}


	}

	private final List<Cluster> clusters = new ArrayList<Cluster>();
	private final List<DataPoint> dataPoints;
	private final double eps;
	private final int minPoints;
	private final String eventType;

	public DBSCAN(List<DataPoint> dataPoints, double eps, int minPoints, String eventType) {
		this.dataPoints = dataPoints;
		this.eps = eps;
		this.minPoints = minPoints;
		this.eventType = eventType;
		buildNeighbours();
	}

	public void analyze() {
		for (DataPoint point: dataPoints) {
			if (!point.visited) {
				point.visited = true;
				List<DataPoint> neighbours = point.neighbours;
				if (neighbours.size() < minPoints)
					point.noise = true;
				else {
					createCluster(point, neighbours);
				}
			}
		}
	}

	public List<Cluster> getClusters() {
		return clusters;
	}

	private void createCluster(DataPoint point, List<DataPoint> neighbours) {
		Cluster cluster = new Cluster(eventType);
		clusters.add(cluster);
		cluster.add(point);

		ArrayList<DataPoint> points = new ArrayList<DataPoint>(neighbours);

		for (int i = 0; i < points.size(); i++) {
			DataPoint neighbourPoint = points.get(i);
			if (!neighbourPoint.visited) {
				neighbourPoint.visited = true;
				List<DataPoint> neighbourNeighbours = neighbourPoint.neighbours;
				if (neighbourNeighbours.size() >= minPoints)
					points.addAll(neighbourNeighbours);
			}

			cluster.add(neighbourPoint);
		}
	}

	private void buildNeighbours() {
		int size = dataPoints.size();
		for (int i = 0; i < size; i++)
			dataPoints.get(i).neighbours = new ArrayList<DataPoint>();

		for (int i = 0; i < size; i++) {
			DataPoint point1 = dataPoints.get(i);
			for (int j = i + 1; j < size; j++) {
				DataPoint point2 = dataPoints.get(j);
				if (isInDistance(point1, point2)) {
					point1.neighbours.add(point2);
					point2.neighbours.add(point1);
				}
			}
		}
	}


	private boolean isInDistance(DataPoint point1, DataPoint point2) {
		if (point1 == point2)
			return false;

		double distance = Math.sqrt(
			Math.pow(point1.distance - point2.distance, 2) +
			Math.pow(point1.time - point2.time, 2)
		);

		return distance < eps;
	}
}
