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
	private double energyLeft = AM24Constraints.robotEnergy;
	private int xBase = 0;
	private int yBase = 0;
	private int xOre = 0, yOre = 0;
	private ArrayBlockingQueue<AM24Job> jobList = null;
	private int capacity = AM24Constraints.transporterOreCapacity;
	private int tmpCapacity = AM24Constraints.transporterOreCapacity;
	private boolean oreNotReached=true;

	
	
	public AM24Transporter() {}
	
	public AM24Transporter(String s) {
		super(s);
	}
	
	public void setup() {
	  	setColor(Color.BLUE);
	  	playRole("Transporter");
	  	jobList = new ArrayBlockingQueue<AM24Job>(AM24Constraints.robotMemorySize-AM24Constraints.nbOfBases);
	  	xBase = xcor();
	  	yBase = ycor();
	}

	 public String walk() {
		 /**
			 * @Fills up the Transporter jobList
			 */
		 
		 //println("MessagBox Size: "+getMessageBoxSize());
		 //println("Is messageBox empty? "+ isMessageBoxEmpty());
		 if(isMessageBoxEmpty()==false){
			 println("Recieve Message!!!");
			 AM24Message recievedMess = (AM24Message) nextMessage();		
				jobList.offer(recievedMess.getJob());
				println("Transporter jobList size: "+jobList.size());
			 
		 }
		
		/*while (!isMessageBoxEmpty()){
			println("Recieve Message!!!");
			 AM24Message recievedMess = (AM24Message) nextMessage();		
			jobList.offer(recievedMess.getJob());			
		}*/
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
			 if((distance(xOre,yOre)+Math.sqrt((Math.pow(xOre-xBase,2) + (Math.pow(yOre-yBase,2)))*AM24Constraints.movingCost) < energyLeft)){
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
		while ((xcor()!=xOre)&&(ycor()!=yOre)){
			setHeading(towards(xOre,yOre));
			fd(1);
			AM24Base.addToTotalEnergyUsed(AM24Constraints.movingCost);
			energyLeft = energyLeft-AM24Constraints.movingCost;
		}
			if(getPatchColorAt(xOre,yOre) == Color.pink){
				capacity--;
				println("Collecting Ore at patch: "+xOre  +","+yOre);
				//setPatchColorAt(Color.black, xcor(), ycor());
			}
		return ("walk");
	}
	 
	 public String returnToBase(){
		 //println("Going To Base!!!!!");
			if(xBase!=xcor()&&yBase!=ycor()){		
				 setHeading(towards(xBase,yBase));
				 //println("Moving towards Base!: "+xcor() +" " +ycor());
				 fd(1);
				 AM24Base.addToTotalEnergyUsed(AM24Constraints.movingCost);
				 energyLeft = energyLeft-AM24Constraints.movingCost;
				 return ("returnToBase");
			}
		 else
			println("Where The Transporter thinks the base is: "+xcor()+" "+ycor());
			println("Initial Base Position: "+xBase+" "+yBase);
			tmpCapacity = AM24Constraints.transporterOreCapacity -capacity;
		 
		 	AM24Base.thisBaseCapacity = AM24Base.thisBaseCapacity - tmpCapacity;	// Decrement the base capacity with tmpCapacity, NOT SURE
		 	println("Total Base Capacity: "+AM24Base.thisBaseCapacity);																		// IF THIS IS THE CORRECT WAY TO DO IT!!!!!
		 	energyLeft = AM24Constraints.robotEnergy;
			 capacity = AM24Constraints.transporterOreCapacity;
		 return("walk");
	 }
		
		 
}

