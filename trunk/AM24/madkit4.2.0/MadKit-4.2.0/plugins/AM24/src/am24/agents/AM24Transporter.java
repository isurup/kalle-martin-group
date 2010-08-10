package am24.agents;

import java.awt.Color;
//import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import am24.util.*;
import turtlekit.kernel.Turtle;

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
	  	//randomHeading();
	  	setColor(Color.BLUE);
	  	playRole("Transporter");
	  	jobList = new ArrayBlockingQueue<AM24Job>(AM24Constraints.robotMemorySize-AM24Constraints.nbOfBases);
	}

	 public String walk() {			//throws InvalidAddressException
		 /*Random rand = new Random();		
		 Turtle[] ts = turtlesAt(xBase,yBase);
		 int tsRand = 0;
		 if (ts != null){
			 tsRand = rand.nextInt(ts.length);
			 sendMessage(ts[tsRand].getAddress(),new ExplorerMessage());}
			 else*/
			
		while (!isMessageBoxEmpty()){
			 AM24Message recievedMess = (AM24Message) nextMessage();		
			jobList.offer(recievedMess.getJob());
			
		}
		
		 while (!jobList.isEmpty()){
			 AM24QueueObject job = jobList.poll();
			 // Base Positions
			 if (job instanceof AM24BasePos) {
				 xBase = ((AM24BasePos) job).getBasePosX();
				 yBase = ((AM24BasePos) job).getBasePosY();
			 }
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
		 else
		 return ("walk"); 
		}
	 
	 
	

	public String executeJob(){
		if (oreNotReached==true){
			towards(xOre,yOre);
			fd(1);
			
			energyLeft = energyLeft-AM24Constraints.movingCost;
			
			if((xcor()==xOre)&&(ycor()==yOre)){
				oreNotReached=false;
			}
			else oreNotReached=true;
			if(getPatchColorAt(xOre,yOre) == Color.pink){
				capacity--;
				setPatchColorAt(Color.black, xcor(), ycor());
			}
			
			return ("walk");
			}
			else return("executeJob");
	 }
	 
	 public String returnToBase(){
		 if((xcor() != xBase)&&(ycor() != yBase)){
			 towards(xBase,yBase);
			 fd(1);
			 energyLeft = energyLeft-AM24Constraints.movingCost;
			 return("returnToBase");	 
		 }
		 else
			tmpCapacity = AM24Constraints.transporterOreCapacity -capacity;
		 
		 	AM24Base.thisBaseCapacity = AM24Base.thisBaseCapacity - tmpCapacity;	// Decrement the base capacity with tmpCapacity, NOT SURE
		 																			// IF THIS IS THE CORRECT WAY TO DO IT!!!!!
		 
			 capacity = AM24Constraints.transporterOreCapacity;
		 return("walk");
	 }
		
		 
}

