
package dk.sdu.mmmi.intellihome.analysis.impl.twolevel;

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
		private double minX;
		private double maxX;
		private double meanX;
		private double minY;
		private double maxY;
		private double meanY;

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
				minX = Double.MAX_VALUE;
				maxX = 0;
				meanX = 0;

				minY = Double.MAX_VALUE;
				maxY = 0;
				meanY = 0;

				double count = points.size();
				for (DataPoint p: points) {
					minX = Math.min(minX, p.x);
					maxX = Math.max(maxX, p.x);
					meanX += p.x / count;

					minY = Math.min(minY, p.y);
					maxY = Math.max(maxY, p.y);
					meanY += p.y / count;
				}

				modified = false;
			}
		}

		public List<DataPoint> getPoints() {
			return points;
		}

		public double getMinX() {
			evaluateStatistics();
			return minX;
		}

		public double getMaxX() {
			evaluateStatistics();
			return maxX;
		}

		public double getMeanX() {
			evaluateStatistics();
			return meanX;
		}

		public double getMinY() {
			evaluateStatistics();
			return minY;
		}

		public double getMaxY() {
			evaluateStatistics();
			return maxY;
		}

		public double getMeanY() {
			evaluateStatistics();
			return meanY;
		}

		public String getEventType() {
			return eventType;
		}
	}

	public static class DataPoint {
		public final double x;
		public final double y;
		boolean visited = false;
		boolean noise = false;
		Cluster cluster;
		List<DataPoint> neighbours;

		public DataPoint(double x, double y) {
			this.x = x;
			this.y = y;
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

	private void analyze() {
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
		if (clusters.isEmpty())
			analyze();
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
			Math.pow(point1.x - point2.x, 2) +
			Math.pow(point1.y - point2.y, 2)
		);

		return distance < eps;
	}
}
