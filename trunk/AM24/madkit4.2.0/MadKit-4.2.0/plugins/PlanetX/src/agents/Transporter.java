package agents;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;
import util.*;

import turtlekit.kernel.Turtle;

public class Transporter extends Turtle {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Queue<PlanetJob> jobList = null;
	double energyLeft = 0;
	private int w=0;
	int movingCost = 4;
	int perceptionCost = 3;
	private int envWidth, envHeight;
	private double xBase, yBase;
	private double xOre, yOre; 
	private boolean collisionDetection;
	

	public Transporter(int envWidth, int envHeight, int xBase, int yBase) {
		super("pullJobList");
		this.envHeight = envHeight;
		this.envWidth = envWidth;
		this.xBase = xBase;
		this.yBase = yBase;
	}
	
	public void setup()
	{
		playRole("Transporter");
		setColor(Color.BLUE);
		setHeading(NorthEast);
		jobList = new LinkedList<PlanetJob>();
		energyLeft = (Math.sqrt(envWidth)+Math.sqrt(envHeight))*2*movingCost*Math.sqrt(perceptionCost);
	}
	
	public String pullJobList(){
		xOre = 0;
		yOre = 0;
		PlanetJob tst = jobList.poll();
		if (tst !=null){
			xOre = PlanetJob.x;
			yOre = PlanetJob.y;
			if((distance(xOre,yOre)+Math.sqrt((Math.pow(xOre-xBase,2) + (Math.pow(yOre-yBase,2)))*7) < energyLeft))
			return ("executeJob");
			else return ("pullJobList");
		}
		else 
			return ("jobListEmpty");
	}
	
	public String executeJob(){
		boolean oreNotReached=true;
		while(oreNotReached){
		towards(xOre,yOre);
		fd(1);
		
		if((xcor()==xOre)&&(ycor()==yOre))
			oreNotReached=false;
			else oreNotReached=true;		
		}
		w++;
		return ("goToBase");
	}
	
	public String jobListEmpty(){
		return ("goToBase");
	}
	
	public String goToBase(){
		boolean baseNotReached=true;
		while(baseNotReached){
		towards(xBase,yBase);
		fd(1);
		
		if((xcor()==xBase)&&(ycor()==yBase))
			baseNotReached=false;
			else baseNotReached=true;		
		}
		PlanetConstraints.C--;
		w=0;
		energyLeft = (Math.sqrt(envWidth)+Math.sqrt(envHeight))*2*movingCost*Math.sqrt(perceptionCost);
		return ("pullJobList");
	}
	
//	void wiggle() {
//		fd(1);
//		turnRight(Math.random() * 45);
//		turnLeft(Math.random() * 45);
//	}

}
