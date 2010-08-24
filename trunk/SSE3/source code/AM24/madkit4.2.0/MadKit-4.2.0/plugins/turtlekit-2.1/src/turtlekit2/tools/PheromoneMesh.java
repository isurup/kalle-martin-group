package turtlekit2.tools;
import java.awt.Color;

import javax.media.j3d.Appearance;
import javax.media.j3d.Geometry;
import javax.media.j3d.GeometryArray;
import javax.media.j3d.GeometryUpdater;
import javax.media.j3d.IndexedGeometryStripArray;
import javax.media.j3d.IndexedTriangleStripArray;
import javax.media.j3d.Material;
import javax.media.j3d.PolygonAttributes;
import javax.media.j3d.Shape3D;
import javax.vecmath.Vector3f;

import turtlekit2.kernel.environment.Patch;

/*
 * Water is a Surface subclass that demonstrates how
 * to change Java3D geometry at runtime.  This 
 * implementation uses Perlin noise to create a geometry 
 * that appears to be water with gentle waves.
 */
public class PheromoneMesh extends Shape3D implements GeometryUpdater {
	protected float waveSize;
	private float red, green, blue;
	Patch[][] patchGrid;
	String pheromone;
	
	protected int divisions;
	protected int ticks;
	protected float metersPerDivision;
	IndexedTriangleStripArray geometry;
	
	public PheromoneMesh(Patch[][] patchGrid, String pheromone, int width, int height, float quality, Color color){
		
		
	}
	
	
	public PheromoneMesh(Patch[][] patchGrid, String pheromone, float sideLength, int divisions, float waveSize, float transparency, float seaLevel, float r, float g, float b){
		this.patchGrid = patchGrid;
		this.pheromone = pheromone;
		this.waveSize = waveSize;
		this.divisions = divisions;
		red = r;
		green = g;
		blue = b;		
		metersPerDivision = sideLength / divisions;
		setGeometry(createGeometry());
		setAppearance(createAppearance());
		setCapabilities();
	}
	
	public PheromoneMesh(Patch[][] patchGrid, String pheromone) {
		this(patchGrid, pheromone, 100, 100, 10f, 0f, 0f, 0.11f, 0.20f, 0.29f);

	}

	public PheromoneMesh(Patch[][] patchGrid, String pheromone, float r, float g, float b, float hei, float transparency) {
		this(patchGrid, pheromone, 100, 100, 10f, transparency, hei, r, g, b);

	}
	public void nextFrame(int ticks) {
		this.ticks = ticks;
		IndexedTriangleStripArray tsa =
			(IndexedTriangleStripArray) getGeometry();
		tsa.updateData(this);
	}
	
	
	
	public void updateData(Geometry geometry) {
		// Go through the entire surface and recalculate
		// the y component of each vertex.
		IndexedTriangleStripArray tsa = (IndexedTriangleStripArray) geometry;
		float[] coordinates = tsa.getCoordRefFloat();
		for (int row = 0; row < (divisions + 1); row++) {
			int width = row * (divisions + 1);
			for (int col = 0; col < (divisions + 1); col++) {
				int ci = (col + width) * 3;		
				float x = coordinates[ci + 0];
				float y = ticks;
				float z = coordinates[ci + 2];
				float nextValue = calculateHeight(x, y, z);
				// Change just the y value (the height)
				coordinates[ci + 1] = nextValue;
			}
		}
		generateNormals(tsa, coordinates);
	}
	
	

	
	protected float calculateHeight(double x, double y, double z) {
		int xx = (x < 100) ? new Double(x).intValue() : 99;
		int yy = (-z < 100) ? new Double(-z).intValue() : 99;
		
		double value = patchGrid[xx][yy].getVariableValue(pheromone);

		Patch[] neighbors = patchGrid[xx][yy].getNeighbors();
		double v = 0;
		for (int i = 0; i < neighbors.length; i++) {
			v += neighbors[i].getVariableValue(pheromone);
		}
		v /= neighbors.length;
		
		
		
		float answer = new Double((value + v)/2).floatValue() * 0.03f;
		if(answer > 20) answer = 20;
		
		// Transform from world space to noise space.
//		double s = x/NOISE_ZOOM;
//		double t = y/NOISE_ZOOM;
//		double r = z/NOISE_ZOOM;
//		float answer =  (float) (waveSize * ImprovedNoise.fBm(s, t, r, 3, 2));
		return answer;
	}

	protected Appearance createAppearance() {
		Appearance appearance = new Appearance();
		PolygonAttributes polyAttrib = new PolygonAttributes();
		polyAttrib.setCullFace(PolygonAttributes.CULL_NONE);
		polyAttrib.setPolygonMode(PolygonAttributes.POLYGON_FILL);
		// Setting back face normal flip to true allows backfacing
		// polygons to be lit (normal is facing wrong way) but only
		// if the normal is flipped.
		polyAttrib.setBackFaceNormalFlip(true);
		appearance.setPolygonAttributes(polyAttrib);
		
		
		Material material = new Material();
		material.setAmbientColor(red, green, blue);
		material.setSpecularColor(red, green, blue);
		material.setDiffuseColor(red, green, blue);
		material.setShininess(60);
		appearance.setMaterial(material);
		
//		TransparencyAttributes ta = new TransparencyAttributes();
//		ta.setTransparency(transparency);
//		ta.setTransparencyMode(TransparencyAttributes.FASTEST);
//		appearance.setTransparencyAttributes(ta);

		return appearance;
	}
	
	protected void setCapabilities() {
		setCapability(Shape3D.ALLOW_GEOMETRY_READ);
		setPickable(true);
		Geometry geometry = getGeometry();
		geometry.setCapability(GeometryArray.ALLOW_REF_DATA_READ);
		geometry.setCapability(GeometryArray.ALLOW_NORMAL_WRITE);
		geometry.setCapability(GeometryArray.ALLOW_REF_DATA_WRITE);
	}
	
	
	
	
	
	
	
	/**********SURFACE PARAM********/
	
	protected int getVertexFormat() {
		int vertexFormat =
		GeometryArray.COORDINATES
				| GeometryArray.NORMALS
				| GeometryArray.BY_REFERENCE;
		return vertexFormat;
	}
	
	
	protected Geometry createGeometry() {
		int vertexCount = (divisions + 1) * (divisions + 1);
		// The number of indices is based on the 
		// number of horizontal strips (height - 1) times the 
		// number of vertices per strip (width * 2).
		int indexCount = divisions * (divisions + 1) * 2;
		int[] stripCounts = new int[divisions];
		for (int strip = 0; strip < divisions; strip++) {
			stripCounts[strip] = (divisions + 1) * 2;
		}

		IndexedTriangleStripArray geometry =
			new IndexedTriangleStripArray(
				vertexCount,
				getVertexFormat(),
				indexCount,
				stripCounts);

		float[] coordinates = new float[vertexCount * 3];

		// Generate the world coordinates
		for (int row = 0; row < (divisions + 1); row++) {
			int width = row * (divisions + 1);
			for (int col = 0; col < (divisions + 1); col++) {
				// coordinate index is the column plus
				// the row times the width of a row times
				// three (one for each x, y, and z).
				int ci = (col + width) * 3;
				float x = metersPerDivision * col;
				float y = 0f;
				float z = -metersPerDivision * row;
				coordinates[ci + 0] = x;
				coordinates[ci + 1] = calculateHeight(x ,y, z);
				coordinates[ci + 2] = z;
			}
		}
		geometry.setCoordRefFloat(coordinates);

		int[] indices = new int[indexCount];
		/* The secret is that the strip vertices must be ordered 
		 * like this: NW, SW, NE, SE for each set of four corners 
		 * of a quad.  A convenient way to accomplish this is to 
		 * organize the landscape in horizontal strips and iterate 
		 * across the columns calculating two vertices at a time. 
		 */
		int pi = 0; // points index
		for (int row = 0; row < divisions; row++) {
			int width = row * (divisions + 1);
			for (int col = 0; col < (divisions + 1); col++) {
				int coordinateIndex = width + col;
				indices[pi] = coordinateIndex + (divisions + 1);
				indices[pi + 1] = coordinateIndex;
				pi = pi + 2;
			}
		}
		geometry.setCoordinateIndices(0, indices);
		geometry.setUserData(indices);
		// Normal indices never change so set them here. For
		// sanity's sake, the vertex normals are arranged just
		// like the coordinates so the indices are the same.
		geometry.setNormalIndices(0, indices);
		generateNormals(geometry, coordinates);
		return geometry;
	}
	
	protected void generateNormals(IndexedGeometryStripArray geometry, float[] coordinates) {
		int[] indices = (int[]) geometry.getUserData();

		int stripCount = divisions;
		int stripIndexCount = (divisions + 1) * 2;

		// The vertex normals are kept by reference within the 
		// geometry to reduce object creation overhead.
		float[] vertexNormals = geometry.getNormalRefFloat();
		if (vertexNormals == null) {
			vertexNormals = new float[coordinates.length];
			geometry.setNormalRefFloat(vertexNormals);
		}
		
		/* Loop through the coordinates via the indices
		 * indirection and calculate the facet normal for
		 * each triangle and vertex normal for each vertex.  
		 * Smooth shading depends on vertex normals to 
		 * interpolate shading intensities across a triangle.  
		 * A Gourand shading approach averages the 
		 * facet normals of the triangles sharing a vertex.  
		 * As the facet normal is determined, add the facet
		 * normal to each of the three vertex normals.  The
		 * vertex normals will be summed at the end of this
		 * loop and the average is completed later by
		 * normalizing the vector.
		 */
		Vector3f normal = new Vector3f();
		Vector3f v1 = new Vector3f();
		Vector3f v2 = new Vector3f();
		int triangleCount = 0;
		int stripOffset = 0;

		for (int strip = 0; strip < stripCount; strip++) {
			for (int i = 0; i < stripIndexCount - 2; i++) {
				int pi = i + stripOffset;

				// The first vertex is used as
				// the local origin for the vectors.
				int ci1 = 3 * indices[pi + 0];
				float x1 = coordinates[ci1 + 0];
				float y1 = coordinates[ci1 + 1];
				float z1 = coordinates[ci1 + 2];

				// The end point for the first vector
				int ci2 = 3 * indices[pi + 1];
				float x2 = coordinates[ci2 + 0];
				float y2 = coordinates[ci2 + 1];
				float z2 = coordinates[ci2 + 2];

				// The end point for the second vector
				int ci3 = 3 * indices[pi + 2];
				float x3 = coordinates[ci3 + 0];
				float y3 = coordinates[ci3 + 1];
				float z3 = coordinates[ci3 + 2];

				// Translate first vector to local origin
				v1.x = x2 - x1;
				v1.y = y2 - y1;
				v1.z = z2 - z1;

				// Translate second vector to local origin
				v2.x = x3 - x1;
				v2.y = y3 - y1;
				v2.z = z3 - z1;

				/* Calculate the normal for this triangle
				 * The iteration goes through the triangles
				 * and every other one has vertices in an 
				 * order that would result in the normal pointing
				 * the wrong way.  Alternate the cross product to
				 * compensate.
				 */
				if (triangleCount % 2 == 0) {
					normal.cross(v1, v2);
				} else {
					normal.cross(v2, v1);
				}
				/* Note that the normal is NOT normalized here as 
				 * you might expect.  Since the neighboring facet
				 * normals are going to be averaged, a normalize()
				 * would be a waste.  The NormalGenerator util class
				 * supports something called a crease angle.  This 
				 * angle essentially determines what is should be 
				 * smoothed, and what should have a definitive
				 * corner.  If you decide to add crease
				 * angle support in this code, you will need to
				 * normalize each normal.  The reason is that a dot
				 * product of two vectors u and v is:
				 * 		u*v = |u|||v|cos(theta)
				 * If the magnitude of both is one, then a dot product
				 * can be used to determine the angle between the 
				 * two vectors (theta) compared to a crease angle.
				 * I would take the cosine of the crease angle and
				 * compare it with the dot product (cosine of the 
				 * angle between the two normals) to determine if
				 * the crease angle has been met.
				 */

				/* Expand the facet normal to 3 vertex normals.  This is
				 * done by averaging the facet normals of the triangles
				 * that share a vertex.  The NormalGenerator uses a crease
				 * angle to decide if averaging can be done, but this
				 * code assumes it can always be done.  At this point,
				 * we only add the normals as they are encountered.  The
				 * divide (to complete the average) is done later when
				 * the vector is normalized.  The normals are not
				 * normalized yet.
				 */
				// First vertex of the triangle
				vertexNormals[3 * indices[pi + 0] + 0] = +normal.x;
				vertexNormals[3 * indices[pi + 0] + 1] = +normal.y;
				vertexNormals[3 * indices[pi + 0] + 2] = +normal.z;
				// Second vertex of the triangle
				vertexNormals[3 * indices[pi + 1] + 0] = +normal.x;
				vertexNormals[3 * indices[pi + 1] + 1] = +normal.y;
				vertexNormals[3 * indices[pi + 1] + 2] = +normal.z;
				// Third vertex of the triangle
				vertexNormals[3 * indices[pi + 2] + 0] = +normal.x;
				vertexNormals[3 * indices[pi + 2] + 1] = +normal.y;
				vertexNormals[3 * indices[pi + 2] + 2] = +normal.z;
				triangleCount++;
			}
			stripOffset = stripOffset + stripIndexCount;
		}

		/* The vertex normals currently hold the sum of the
		 * facet normals of the triangles sharing the vertex.
		 * Complete the averaging of the vertex normals.
		 * Since the vertexNormals are stored by reference
		 * with the geometry, updates to the array are 
		 * automatically reflected in the geometry.
		 */
		Vector3f aNormal = new Vector3f(0, 0, 0);
		for (int vni = 0; vni < coordinates.length; vni = vni + 3) {
			// vertex normal index
			aNormal.x = vertexNormals[vni + 0];
			aNormal.y = vertexNormals[vni + 1];
			aNormal.z = vertexNormals[vni + 2];
			// Normalizing the vector completes the averaging.
			aNormal.normalize();
			vertexNormals[vni + 0] = aNormal.x;
			vertexNormals[vni + 1] = aNormal.y;
			vertexNormals[vni + 2] = aNormal.z;
		}
		
	}
}
