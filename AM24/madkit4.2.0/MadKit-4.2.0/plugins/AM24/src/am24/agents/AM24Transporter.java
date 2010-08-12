package am24.agents;

import java.awt.Color;
//import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import am24.util.*;
import turtlekit.kernel.Turtle;
import am24.agents.AM24Base;
import madkit.kernel.AbstractAgent;

public class AM24Transporter extends Turtle {
	
	int count=10;
	private double energyLeft;
	private int xBase = 0;
	private int yBase = 0;
	private int xOre = 0, yOre = 0;
	private ArrayBlockingQueue<AM24Job> jobList = null;
	private int capacity;
	private int tmpCapacity;
	private boolean oreNotReached=true;
	private AM24Constraints cunts;

	
	
	public AM24Transporter() {}
	
	public AM24Transporter(String s) {
		super(s);
	}
	
	public void setup() {
		cunts=new AM24Constraints();
	  	setColor(Color.BLUE);
	  	playRole("Transporter");
	  	jobList = new ArrayBlockingQueue<AM24Job>(cunts.robotMemorySize-1);//AM24Constraints.nbOfBases);
	  	energyLeft = cunts.robotEnergy;
	  	capacity = cunts.transporterOreCapacity;
	  	tmpCapacity = cunts.transporterOreCapacity;
	  	xBase = xcor();
	  	yBase = ycor();
	}

	 public String walk() {
		 /**
			 * @Fills up the Transporter jobList
			 */
		 energyLeft = cunts.robotEnergy;
		 if(jobList.isEmpty()){
		 while(!isMessageBoxEmpty()){
			 //println("Recieve Message!!!");
			 AM24Message recievedMess = (AM24Message) nextMessage();		
				jobList.offer(recievedMess.getJob());
				//println("Transporter jobList size: "+jobList.size());
			//return("walk");
		 }
		 }else
		/**
		 * @Pulls a job from the jobList and checks if the Transporter has enough energy to execute it
		 * The Transporter will return to base if its energy is too low to execute any job from the jobList
		 * or its capacity is used. 
		 */
		 while (!jobList.isEmpty() && capacity!=0){
			 AM24QueueObject job = jobList.poll();
			 // Ore Position
			 if (job instanceof AM24Job) {
				 xOre = ((AM24Job) job).getOrePosX();
				 yOre = ((AM24Job) job).getOrePosY();
			 }
			 if((distance(xOre,yOre)+Math.sqrt((Math.pow(xOre-xBase,2) + (Math.pow(yOre-yBase,2)))*cunts.movingCost) < energyLeft)){
				 return ("executeJob");
				 
			 }
		 }
		 if((xcor() != xBase)&&(ycor() != yBase)){
			 return("returnToBase");	 
		 }
		 return ("walk"); 
		}
	 
	 
	

	public String executeJob(){
		//println("Executing Job!");
		if ((xcor()!=xOre)||(ycor()!=yOre)){
			setHeading(towards(xOre,yOre));
			fd(1);
			AM24Base.addToTotalEnergyUsed(cunts.movingCost);
			energyLeft = energyLeft-cunts.movingCost;
			return("executeJob");
		}
		/*int xTmp = xcor()-xOre;
		int yTmp = ycor()-yOre;
		if(xTmp!=0 && yTmp!=0){
			setHeading(towards((xcor()+xTmp),(ycor()+yTmp)));
			fd(1);
		}*/
		
			if(getPatchColor()==Color.PINK){
				capacity--;
				//println("Collecting Ore at patch: "+xOre  +","+yOre);
				setPatchColor(Color.black);
			}
		return ("walk");
	}
	 
	 public String returnToBase(){
			if(xBase!=xcor()||yBase!=ycor()){		
				 setHeading(towards(xBase,yBase));
				 //println("Moving towards Base!: "+xcor() +" " +ycor());
				 fd(1);
				 
				 
				 //AM24Base.addToTotalEnergyUsed(AM24Constraints.movingCost);
				 //Turtle[] ts = turtlesHere();
				 Turtle[] ts = turtlesAt(0, 0);
					for(Turtle t: ts) {
						if (t instanceof AM24Base) {
							((AM24Base) t).addToTotalEnergyUsed(cunts.movingCost);
						}
					}
				 
				 energyLeft = energyLeft-cunts.movingCost;
				 return ("returnToBase");
			}
		 else
			//println("Where The Transporter thinks the base is: "+xcor()+" "+ycor());
			//println("Initial Base Position: "+xBase+" "+yBase);
			tmpCapacity = cunts.transporterOreCapacity -capacity;
			
			//Turtle[] ts = turtlesHere();
			Turtle[] ts = turtlesAt(0, 0);
			for(Turtle t: ts) {
				if (t instanceof AM24Base) {
					if (t.isPlayingRole("base")) {
						((AM24Base) t).thisBaseCapacity = ((AM24Base) t).thisBaseCapacity - tmpCapacity;
						println("Total Base Capacity: "+((AM24Base) t).thisBaseCapacity);
					}
				}
			}
		 	//AM24Base.thisBaseCapacity = AM24Base.thisBaseCapacity - tmpCapacity;	// Decrement the base capacity with tmpCapacity, NOT SURE
			
		 	//println("Total Base Capacity: "+AM24Base.thisBaseCapacity);
		 	/*if(AM24Base.thisBaseCapacity<=0){
				 println("Total energy used: "+AM24Base.totalEnergyUsed);
				 println("Total time used: "+AM24Base.simCounter);
			 }*/
		 	energyLeft = cunts.robotEnergy;
			 capacity = cunts.transporterOreCapacity;
		 return("walk");
	 }
		
		 
}

