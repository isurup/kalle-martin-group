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
	private int capacity = PlanetConstraints.transporterOreCapacity;;
	
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
		 if (jobList.size() == PlanetConstraints.robotMemorySize){
			 
			 AM24Job job = jobList.poll();
			 xOre = job.getOrePosX();
			 yOre = job.getOrePosY();
			 xBase = job.getBasePosX();
			 yBase = job.getBasePosY();
			 if((distance(xOre,yOre)+Math.sqrt((Math.pow(xOre-xBase,2) + (Math.pow(yOre-yBase,2)))*7) < energyLeft)){
				 return ("executeJob"); 
				 else 
		 }
		 else return("walk");
		 
		}
	 
	 /*public String computeJob(){
		 if (jobList.size() == 0){			 
			 return("walk");			 
		 }
		 else{
		 AM24Job job = jobList.poll();
		 xOre = job.getOrePosX();
		 yOre = job.getOrePosY();
		 xBase = job.getBasePosX();
		 yBase = job.getBasePosY();
		 if((distance(xOre,yOre)+Math.sqrt((Math.pow(xOre-xBase,2) + (Math.pow(yOre-yBase,2)))*7) < energyLeft))
			 return ("executeJob");
		 else return ("computeJob");}
		 
	 }*/
	 
	 public String executeJob(){
		 
			boolean oreNotReached=true;
			while(oreNotReached){
			towards(xOre,yOre);
			fd(1);
			
			if((xcor()==xOre)&&(ycor()==yOre))
				oreNotReached=false;
				else oreNotReached=true;		
			}
			capacity++;
			return ("computeJob");
		}
		
		 public String change(){
			  randomHeading();
			  /*if (getHeading() > South) setColor(Color.red);
			  else if (getHeading() > West) setColor(Color.blue);
			    else if (getHeading() > North) setColor(Color.green);
			      else setColor(Color.yellow);*/
			  return("walk");
	  }
}
