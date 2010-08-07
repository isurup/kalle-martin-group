package turtlekit2.tools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Hashtable;
import java.util.List;

import javax.media.j3d.Appearance;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.Material;
import javax.media.j3d.PointLight;
import javax.media.j3d.QuadArray;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JPanel;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

import turtlekit2.kernel.agents.Turtle;
import turtlekit2.kernel.environment.Patch;

import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class Tk3DView extends JPanel{
	final static long serialVersionUID = 1L;

	/**
	 * Renderer attributes
	 */

	public boolean viewOn = true;
	public boolean staticOn = false;
	SimpleUniverse universe3D;
	BranchGroup root;
	BoundingSphere bounds;
	Transform3D translation;
	public Canvas3D canvas3D;

	List<Turtle> turtles;
	Patch[][] patchGrid;
	int width; int height;

	Shape3D[][] patches;
	/**
	 * 3D Scene parameters initialized in constructor
	 * @param patchGrid 
	 */
	public Tk3DView(List<Turtle> list, int envWidth, int envHeight, Patch[][] patchGrid) {
		super();
		this.patchGrid = patchGrid;
		this.setLayout(new BorderLayout());
		turtles = list;
		this.width = envWidth;
		this.height = envHeight;
		canvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
		this.add("Center", canvas3D);
		universe3D = new SimpleUniverse(canvas3D);
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
//		createPatches();
		createGround();
		createObjects();

		root.compile();
		universe3D.addBranchGraph(root);
	}


	public void createBackground() {
		BoundingSphere boundingSphere = bounds;

//			    TextureLoader backgroundTexture = 
//			        new TextureLoader("images/Texture3D.jpg", this);
//			    Background background = 
//			        new Background(backgroundTexture.getImage());
//			    background.setImageScaleMode(Background.SCALE_REPEAT);

		Background background = new Background(new Color3f(0.93f,0.9f,1f));


		background.setApplicationBounds(boundingSphere);
		root.addChild(background);
	}


	public void createPatches(){
		patches = new Shape3D[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
//				if(!patchGrid[i][j].getColor().equals(Color.BLACK)){
					//Patch coordinates
					QuadArray patch = new QuadArray(4, QuadArray.COORDINATES);
					patch.setCoordinate(0 , new Point3f(i, 1, j));
					patch.setCoordinate(1,new Point3f(i, 1, j+1));
					patch.setCoordinate(2,new Point3f(i+1,1, j+1));
					patch.setCoordinate(3,new Point3f(i+1, 1, j));
					
					//patch Color
					Color c = patchGrid[i][j].getColor();
					Appearance app = new Appearance();
					app.setCapability(Appearance.ALLOW_COLORING_ATTRIBUTES_WRITE);
					app.setCapability(Appearance.ALLOW_COLORING_ATTRIBUTES_READ);
					Color3f objColor = new Color3f(c);
					ColoringAttributes ca = new ColoringAttributes();
					ca.setColor(objColor);
					app.setColoringAttributes(ca);
					patches[i][j] = new Shape3D(patch, app);
//				}else
//					patches[i][j] = null;
				
			}
		}

		
		translation = new Transform3D();
		//Translation to place particles
		translation.setTranslation(new Vector3f(0,0.1f,0));
		TransformGroup TG = new TransformGroup(translation);

		
		//Define the TransformGroup to add objects in the scene without translation T3D
		TransformGroup objectsAdder = new TransformGroup();
		objectsAdder.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		objectsAdder.setCapability(TransformGroup.ALLOW_TRANSFORM_READ); 

		TG.addChild(objectsAdder);
		
		
		for (int i = 0; i < width; i++) 
			for (int j = 0; j < height; j++)
				objectsAdder.addChild(patches[i][j]);
		
		
		root.addChild(TG);
	}


	public void createGround(){
		translation = new Transform3D();
		//Translation to place particles
		translation.setTranslation(new Vector3f(width / 2, -1, height / 2));
		TransformGroup TG = new TransformGroup(translation);

		//Define the TransformGroup to add objects in the scene without translation T3D
		TransformGroup objectsAdder = new TransformGroup();
		objectsAdder.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		objectsAdder.setCapability(TransformGroup.ALLOW_TRANSFORM_READ); 

		Color3f color = new Color3f(new Color(0.0f, 0.0f, 0.0f));
		Material material = new Material();
		material.setAmbientColor(color);
		material.setSpecularColor(color);
		material.setDiffuseColor(color);
		material.setShininess(0);


		Appearance groundAppearance = new Appearance();
		groundAppearance.setMaterial(material);

		//appearance.setTransparencyAttributes(new TransparencyAttributes(TransparencyAttributes.NICEST,0.8f));
		Box ground =  new Box(width/2,1.5f,height/2,groundAppearance);


		TG.addChild(objectsAdder);
		objectsAdder.addChild(ground);
		root.addChild(TG);
	}



	/**
	 * Create and configure camera attach them to the @param root node (BranchGroup)
	 */
	public void createCamera() {
		setCameraPosition(width / 2, height*3, height/2);
		universe3D.getViewer().getView().setBackClipDistance(10000);
		OrbitBehavior orbit = new OrbitBehavior(canvas3D);
		orbit.setRotationCenter(new Point3d(width / 2, 0, height/2));
		orbit.setSchedulingBounds(bounds);
		orbit.setZoomFactor(100);
		orbit.setTransFactors(0, 0);
		orbit.setRotXFactor(0);
		orbit.setReverseRotate(true);
		universe3D.getViewingPlatform().setViewPlatformBehavior(orbit);
	}


	/**
	 * Set the position of the camera.
	 */
	private void setCameraPosition(float x, float y, float z) {
		Transform3D vt = new Transform3D();
		Point3d eye = new Point3d(x, y, z);
		Point3d center = new Point3d(width/2, 0, height/2);
		Vector3d up = new Vector3d(1, 0, 0);

		vt.lookAt(eye, center, up);
		vt.invert();
		vt.setTranslation(new Vector3d(eye.x, eye.y, eye.z));
		universe3D.getViewer().getViewingPlatform().getViewPlatformTransform()
		.setTransform(vt);
	}
	/**
	 * Create lights and attach them to the @param root node (BranchGroup)
	 */
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

		//		pointLi=new PointLight(new Color3f(0.3f,0.6f,0.4f), new Point3f(width + width/2 , 0, -height/2), new Point3f(1f,0f,0f));
		//		pointLi.setInfluencingBounds(bounds);
		//		root.addChild(pointLi);
		//		
		//		pointLi=new PointLight(new Color3f(0.5f,0.6f,0.3f), new Point3f(-width/2 , 0, height + height/2), new Point3f(1f,0f,0f));
		//		pointLi.setInfluencingBounds(bounds);
		//		root.addChild(pointLi);
	}




	/**
	 * Create particles shapes and attach them to the @param root node (BranchGroup)
	 */
	public void createObjects(){
		//Environment loop to add particles to the 3D Scene
		translation = new Transform3D();
		for (int i = turtles.size() - 1; i >= 0 ;i--)
			addToScene(turtles.get(i));

	}





	public void addToScene(Turtle o){

		//Translation to place particles
		Vector3f pos = new Vector3f(0.5f,1,0.5f);
		translation.setTranslation(pos);
		TransformGroup TG = new TransformGroup(translation);

		//Define the TransformGroup to add objects in the scene without translation T3D
		TransformGroup objectsAdder = new TransformGroup();
		objectsAdder.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		objectsAdder.setCapability(TransformGroup.ALLOW_TRANSFORM_READ); 
		
		
		Appearance app = new Appearance();
		app.setCapability(Appearance.ALLOW_COLORING_ATTRIBUTES_WRITE);
		app.setCapability(Appearance.ALLOW_COLORING_ATTRIBUTES_READ);
		Color3f objColor = new Color3f(o.getColor());
		ColoringAttributes ca = new ColoringAttributes();
		ca.setColor(objColor);
		app.setColoringAttributes(ca);
		

		Tk3DAnim particleAnimation = new Tk3DAnim(objectsAdder, o, app);
		particleAnimation.setSchedulingBounds(bounds);
		objectsAdder.addChild(particleAnimation);

		
		
		
//		Color3f color = new Color3f(o.getColor());
//		Material material = new Material();
//		material.setAmbientColor(color);
//		material.setSpecularColor(color);
//		material.setDiffuseColor(color);
//		material.setShininess(128.0f);
//		Appearance appearance = new Appearance();
//		appearance.setMaterial(material);
//				Box shape =  new Box(1f,3f,1f,appearance);
//		Cone shape = new Cone(0.8f, 1.6f, appearance);
		Cone shape = new Cone(0.8f, 1.6f, app);

		TG.addChild(objectsAdder);
		objectsAdder.addChild(shape);
		root.addChild(TG);
	}



	public void reset(List<Turtle> list, int envWidth,
			int envHeight) {
		turtles = list;
		this.width = envWidth;
		this.height = envHeight;

		if (root != null)
			root.detach();
		universe3D.cleanup();
		universe3D = new SimpleUniverse(canvas3D);
		createScene();
		this.repaint();
	}


	public void updatePatches(Patch p, int x, int y) {
//		if(patches[x][y] == null & !p.color.equals(Color.BLACK)){
//			System.err.println("ADD");
//			addToScene(p, x, y);
//		}else if(p.color.equals(Color.BLACK)){
//			patches[x][y].removeAllGeometries();
//			patches[x][y] = null;
//		}else{
//		System.err.println(p.getColor());
		if(x<width && y<height){
			Appearance shapeAppearance;

		shapeAppearance = patches[x][y].getAppearance();
		ColoringAttributes caGreen =
		        new ColoringAttributes(new
		Color3f(p.color), ColoringAttributes.FASTEST);

		shapeAppearance.setColoringAttributes(caGreen);
		}
		

//		}
		
	}
	
	
	
	Hashtable<Color, QuadArray> quads;
	
	public void addPatchToQuad(Patch p){
		QuadArray quad = quads.get(p.color);
		int i = p.x;
		int j = p.y;
		int index = quad.getVertexCount();
		quad.setCoordinate(index + 0,new Point3f(i, 1, j));
		quad.setCoordinate(index + 1,new Point3f(i, 1, j+1));
		quad.setCoordinate(index + 2,new Point3f(i+1,1, j+1));
		quad.setCoordinate(index + 3,new Point3f(i+1, 1, j));
	}
	
	
	
	public void addToScene(Patch p, int i, int j){
		//Patch coordinates
		QuadArray patch = new QuadArray(4, QuadArray.COORDINATES);
		patch.setCoordinate(0 , new Point3f(i, 1, j));
		patch.setCoordinate(1,new Point3f(i, 1, j+1));
		patch.setCoordinate(2,new Point3f(i+1,1, j+1));
		patch.setCoordinate(3,new Point3f(i+1, 1, j));
		
		//patch Color
		Color c = p.getColor();
		Appearance app = new Appearance();
		app.setCapability(Appearance.ALLOW_COLORING_ATTRIBUTES_WRITE);
		app.setCapability(Appearance.ALLOW_COLORING_ATTRIBUTES_READ);
		Color3f objColor = new Color3f(c);
		ColoringAttributes ca = new ColoringAttributes();
		ca.setColor(objColor);
		app.setColoringAttributes(ca);
		patches[i][j] = new Shape3D(patch, app);
		
		
		translation = new Transform3D();
		//Translation to place particles
		translation.setTranslation(new Vector3f(0,1,0));
		TransformGroup TG = new TransformGroup(translation);

		
		//Define the TransformGroup to add objects in the scene without translation T3D
		TransformGroup objectsAdder = new TransformGroup();
		objectsAdder.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		objectsAdder.setCapability(TransformGroup.ALLOW_TRANSFORM_READ); 

		TG.addChild(objectsAdder);
		objectsAdder.addChild(patches[i][j]);
		root.addChild(TG);
	}


}



