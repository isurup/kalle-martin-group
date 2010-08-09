package am24.agents;

import java.awt.Color;
import java.util.concurrent.ArrayBlockingQueue;

import am24.util.*;
import turtlekit.kernel.Turtle;

public class AM24Transporter extends Turtle {
	
	int count=10;
	private double energyLeft = PlanetConstraints.robotEnergy;
	private int xBase = 0;
	private int yBase = 0;
	private int xOre = 0, yOre = 0;
	private ArrayBlockingQueue<AM24Job> jobList = null;
	private int capacity = PlanetConstraints.transporterOreCapacity;
	private boolean oreNotReached=true;
	
	public AM24Transporter() {}
	
	public AM24Transporter(String s) {
		super(s);
	}
	
	public void setup() {
	  	randomHeading();
	  	setColor(Color.BLUE);
	  	playRole("Transporter");
	  	jobList = new ArrayBlockingQueue<AM24Job>(PlanetConstraints.robotMemorySize);
	}

	 public String walk(){
		 while (!jobList.isEmpty()){
			 AM24Job job = jobList.poll();
			 xOre = job.getOrePosX();
			 yOre = job.getOrePosY();
			 xBase = job.getBasePosX();
			 yBase = job.getBasePosY();
			 if((distance(xOre,yOre)+Math.sqrt((Math.pow(xOre-xBase,2) + (Math.pow(yOre-yBase,2)))*4) < energyLeft)){
				 return ("executeJob");
			 }
		 }
		 if((xcor() != xBase)&&(ycor() != yBase)){
			 return("returnToBase");	 
		 }
		 else
		 return ("walk"); 
		}
	 
	 public String executeJob(){
		if (oreNotReached==true){
			towards(xOre,yOre);
			fd(1);
			energyLeft = energyLeft-3;
			
			if((xcor()==xOre)&&(ycor()==yOre)){
				oreNotReached=false;
			}
			else oreNotReached=true;		
			capacity++;
			return ("walk");
			}
			else return("executeJob");
		}
		
		 
}
