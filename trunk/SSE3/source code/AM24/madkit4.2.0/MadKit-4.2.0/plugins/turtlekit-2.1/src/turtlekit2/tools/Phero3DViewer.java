package turtlekit2.tools;
import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;

import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.PointLight;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JPanel;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

import turtlekit2.kernel.environment.Patch;

import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class Phero3DViewer extends JPanel implements IElapsedTimeListener {
	private static final long serialVersionUID = 1L;

	private PheromoneMesh pheroMesh;
	private int ticks = 0;
	Canvas3D canvas3D;
	SimpleUniverse simpleU;
	BoundingSphere bounds;

	String pheromone;
	Patch[][] patchGrid;

	BranchGroup root;
	int width; int height;


	public Phero3DViewer(Patch[][] patchGrid, String phero, int envWidth, int envHeight){
		this.width = envWidth;
		this.height = envHeight;
		this.patchGrid = patchGrid;
		this.pheromone = phero;

		setLayout(new BorderLayout());
		GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
		canvas3D = new Canvas3D(config);
		add("Center", canvas3D);
		simpleU = new SimpleUniverse(canvas3D);
		createScene();
	}


	/**
	 * Creating the 3D initial scene - JAVA 3D implementation
	 */
	private void createScene(){
		//3D Objects initialization
		root = new BranchGroup();
		root.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.setCapability(TransformGroup.ALLOW_TRANSFORM_READ); 
		root.setCapability(BranchGroup.ALLOW_DETACH);

		bounds = new BoundingSphere(new Point3d(width/2, 0 , height / 2), height * width);

		createBackground();
		createCamera();
		createLight();
		createObjects();

		root.compile();
		simpleU.addBranchGraph(root);
	}


	
	
	
	
	public void createBackground() {
		BoundingSphere boundingSphere = bounds;
		Background background = new Background(new Color3f(0.93f,0.9f,1f));
		background.setApplicationBounds(boundingSphere);
		root.addChild(background);
	}




	/**
	 * Create and configure camera attach them to the @param root node (BranchGroup)
	 */
	public void createCamera() {
		setCameraPosition(width / 2, height*3, height/2);
		simpleU.getViewer().getView().setBackClipDistance(10000);
		OrbitBehavior orbit = new OrbitBehavior(canvas3D);
		orbit.setRotationCenter(new Point3d(width / 2, 0, height/2));
		orbit.setSchedulingBounds(bounds);
		orbit.setZoomFactor(100);
		orbit.setTransFactors(0, 0);
		orbit.setRotXFactor(0);
		orbit.setReverseRotate(true);
		simpleU.getViewingPlatform().setViewPlatformBehavior(orbit);
	}


	/**
	 * Set the position of the camera.
	 */
	private void setCameraPosition(float x, float y, float z) {
		Transform3D vt = new Transform3D();
		Point3d eye = new Point3d(x, y, z);
		Point3d center = new Point3d(width/2, 0, height/2);
		Vector3d up = new Vector3d(1.0, 1.0, 0.0);

		vt.lookAt(eye, center, up);
		vt.invert();
		vt.setTranslation(new Vector3d(eye.x, eye.y, eye.z));
		simpleU.getViewer().getViewingPlatform().getViewPlatformTransform()
		.setTransform(vt);
	}

	public void createLight(){
		//Global Lighting parameters
		PointLight pointLi;


		//TOP
		pointLi=new PointLight(new Color3f(1f,1f,1f), new Point3f(0 , height, 0), new Point3f(1f,0f,0f));
		pointLi.setInfluencingBounds(bounds);
		root.addChild(pointLi);

		pointLi=new PointLight(new Color3f(1f,1f,1f), new Point3f(width , height, 0), new Point3f(2f,0f,0f));
		pointLi.setInfluencingBounds(bounds);
		root.addChild(pointLi);

		pointLi=new PointLight(new Color3f(1f,1f,1f), new Point3f(width , height * 2, height), new Point3f(1.6f,0f,0f));
		pointLi.setInfluencingBounds(bounds);
		root.addChild(pointLi);

		pointLi=new PointLight(new Color3f(1f,1f,1f), new Point3f(0 , height, height), new Point3f(1f,0f,0f));
		pointLi.setInfluencingBounds(bounds);
		root.addChild(pointLi);


		//BOTTOM
		pointLi=new PointLight(new Color3f(0.3f,0.6f,1f), new Point3f(width/2 , -height*3, height/2), new Point3f(1f,0f,0f));
		pointLi.setInfluencingBounds(bounds);
		root.addChild(pointLi);


		//BORDER
		pointLi=new PointLight(new Color3f(0.3f,0.6f,0.4f), new Point3f(-width/2 , 0, -height/2), new Point3f(1f,0f,0f));
		pointLi.setInfluencingBounds(bounds);
		root.addChild(pointLi);

		pointLi=new PointLight(new Color3f(0.5f,0.6f,0.3f), new Point3f(width + width/2 , 0, height + height/2), new Point3f(1f,0f,0f));
		pointLi.setInfluencingBounds(bounds);
		root.addChild(pointLi);

	}
	
	
	
	public void tick(){
		pheroMesh.nextFrame(++ticks);
	}

	public void createObjects() {
		pheroMesh = new PheromoneMesh(patchGrid,pheromone);
		
		Transform3D translation = new Transform3D();
		translation.setTranslation(new Vector3f(0, 0 , height));
		TransformGroup TG = new TransformGroup(translation);
		
		TransformGroup objectsAdder = new TransformGroup();
		objectsAdder.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		objectsAdder.setCapability(TransformGroup.ALLOW_TRANSFORM_READ); 
		
		TG.addChild(objectsAdder);
		objectsAdder.addChild(pheroMesh);
		root.addChild(TG);
		
		ElapsedTimeBehavior timer = new ElapsedTimeBehavior(this, 50);
		timer.setSchedulingBounds(bounds);
		root.addChild(timer);

	}


	public void reset(Patch[][] patchGrid2, String phero, int envWidth,
			int envHeight) {
		this.width = envWidth;
		this.height = envHeight;
		this.patchGrid = patchGrid2;
		this.pheromone = phero;

		if (root != null)
			root.detach();
		simpleU.cleanup();
		simpleU = new SimpleUniverse(canvas3D);
		createScene();
		this.repaint();
		
	}

}
