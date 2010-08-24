package turtlekit2.tools;

import java.util.Enumeration;

import javax.media.j3d.Appearance;
import javax.media.j3d.Behavior;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.WakeupOnElapsedTime;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3f;

import turtlekit2.kernel.agents.Turtle;


public class Tk3DAnim extends Behavior{

	private TransformGroup targetTG;
	private Transform3D translater = new Transform3D();

	Turtle t;
//	private Vector3f initLoc;
	Appearance app;

	final static int wakeUpPeriod = 50;

	public Tk3DAnim(TransformGroup targetTG, Turtle particle, Appearance app){
		this.targetTG = targetTG;
		this.t = particle;
		this.app = app;
//		initLoc = new Vector3f(t.xcor(), 1, t.ycor());
	}

	public void initialize(){
		this.wakeupOn(new WakeupOnElapsedTime(wakeUpPeriod));
	}

	@SuppressWarnings("unchecked")
	public void processStimulus(Enumeration criteria){
		translater.setTranslation(new Vector3f(t.xcor(), 1, t.ycor()));
		targetTG.setTransform(translater);
		this.wakeupOn(new WakeupOnElapsedTime(wakeUpPeriod));
		
		Color3f color = new Color3f();
		app.getColoringAttributes().getColor(color);
		if(!color.get().equals(t.color))
		{
		ColoringAttributes caGreen = new ColoringAttributes(new
		Color3f(t.color), ColoringAttributes.FASTEST);

		app.setColoringAttributes(caGreen);}

	}

} 