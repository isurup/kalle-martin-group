/*
 * AM24Turtle.java -TurtleKit - A 'star logo' in MadKit
 * Copyright (C) 2000-2002 Fabien Michel
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package am24.agents;

import java.awt.Color;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.Random;
import java.lang.Math;
import am24.util.*;
import madkit.kernel.Message;
import turtlekit.kernel.Turtle;


public class AM24Explorer extends Turtle 
{
	int count=10;
	int xBase;
	int yBase;
	boolean fullQueue = false;

	private double energyLeft = 0;
	private ArrayBlockingQueue<AM24QueueObject> jobList = null;
	AM24BasePos basePos;

	public AM24Explorer(){
		super();
	}

	public AM24Explorer(String s)
	{super(s);}

	public void setup(){
		randomHeading();
		setColor(Color.WHITE);
		playRole("explorer");
		jobList = new ArrayBlockingQueue<AM24QueueObject>(AM24Constraints.robotMemorySize-AM24Constraints.nbOfBases);
		energyLeft = AM24Constraints.robotEnergy;
		AM24BasePos basePos = new AM24BasePos(xcor(), ycor());
		xBase = basePos.getBasePosX();
		yBase = basePos.getBasePosY();
		
	}

	public String walk(){
		
		println("energyLeft "+energyLeft);
		if(fullQueue)
		{
			return("returnToBase");
		}
		else
		fd(1);
		energyLeft = energyLeft-AM24Constraints.movingCost;
		
		/*if((distance(xBase,yBase)*AM24Constraints.movingCost)+ 2 < energyLeft){
			return("returnToBase");
		}
		else*/
		 /*if((xcor() == xBase)&&(ycor() == yBase)){
			 sendToAgent();
			 energyLeft = AM24Constraints.robotEnergy;	 
		 }*/
		if (count < 0) {
			count = (int) (Math.random()*90);
			checkPerceptionScope(Color.pink);
			return("change");
		}
		else {
			count--;
			checkPerceptionScope(Color.pink);
			energyLeft = energyLeft-(AM24Constraints.robotPerceptionScope*AM24Constraints.robotPerceptionScope+1);
			return ("walk");
		}
	}  

	public String change(){
		randomHeading();
		/*if (getHeading() > South) setColor(Color.red);
		  else if (getHeading() > West) setColor(Color.blue);
		    else if (getHeading() > North) setColor(Color.green);
		      else setColor(Color.yellow);*/
		return("walk");
	}

	public String returnToBase(){
		println("Going To Base!!!!!");
		if(xBase!=xcor()&&yBase!=ycor()){		
			 setHeading(towards(xBase,yBase));
			 println("Moving towards Base!: "+xcor() +" " +ycor());
			 fd(1);
			 AM24Base.addToTotalEnergyUsed(AM24Constraints.movingCost);
			 energyLeft = energyLeft-AM24Constraints.movingCost;
			 return ("returnToBase");
			 	 
		}
		else 		 
			 println("Where The Explorer thinks the base is: "+xcor()+" "+ycor());
			 println("Initial Base Position: "+xBase+" "+yBase);
			 fullQueue=false;
			return("sendToAgent");   //GIVES EXCEPTIONS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		 	//energyLeft = AM24Constraints.robotEnergy;
			
		 //return("walk");
	 }
		

	private void checkPerceptionScope(Color c)
	{
		int iPerceptionScope = AM24Constraints.robotPerceptionScope;
		//check if we wrap is on
		if (AM24Constraints.wrapOn) {

			if (xcor()+iPerceptionScope > getWorldWidth()) { 			 // check if we are in right side of the world

				for(int i = xcor()-iPerceptionScope; i < xcor() + iPerceptionScope || i < getWorldWidth(); i++)
				{
					if (i > getWorldWidth()) // warp x
					{
						 i = Math.abs(i - getWorldWidth());
					}
					for(int j = ycor()-iPerceptionScope; j < ycor() + iPerceptionScope || j < getWorldHeight(); j++)
					{
						if(j > getWorldHeight()) // warp y
						{
							j = Math.abs(j - getWorldHeight());
						}
						if (checkPathFor(c,i,j)) {

							try {
								if(jobList.offer(new AM24Job(i,j))) {
									println("found ore at(x,y): " + i +","+j);
								} else {
									// memory is full go home
									println("Memory is full go home to base");
									fullQueue = true;
									break;
								}
							} catch(Exception e)
							{
								//HMM hehe
							}
						}
					}
				}

			} else if (xcor()-iPerceptionScope < 0) { 			 // check if we are in left side of the world

				for(int i = xcor()-iPerceptionScope; i < xcor() + iPerceptionScope || i < getWorldWidth(); i++)
				{
					if (i > getWorldWidth()) // warp x
					{
						i = Math.abs(i - getWorldWidth());
					}
					for(int j = ycor()-iPerceptionScope; j < ycor() + iPerceptionScope || j < getWorldHeight(); j++)
					{
						if(j > getWorldHeight()) // warp y
						{
							j = Math.abs(j - getWorldHeight());
						}
						if (checkPathFor(c,i,j)) {

							try {
								if(jobList.offer(new AM24Job(i,j))) {
									println("found ore at(x,y): " + i +","+j);
								} else {
									// memory is full go home
									println("Memory is full go home to base");
									fullQueue = true;
									break;
								}
							} catch(Exception e)
							{
								//HMM hehe
							}
						}
					}
				}
			} 
			else {
				// no need to wrap anything

				for(int i = xcor()-iPerceptionScope; i < xcor() + iPerceptionScope || i < getWorldWidth(); i++)
				{
					for(int j = ycor()-iPerceptionScope; j < ycor() + iPerceptionScope || j < getWorldHeight() ; j++)
					{
						if (checkPathFor(c,i,j)) {

							try {
								if(jobList.offer(new AM24Job(i,j))) {
									println("found ore at(x,y): " + i +","+j);
								} else {
									// memory is full go home
									println("Memory is full go home to base");
									fullQueue = true;
									break;
								}
							} catch(Exception e)
							{
								//HMM hehe
							}
						}
					}
				}
			}

		}
	}

	private Boolean checkPathFor(Color c, int xcor, int ycor) {

		if (getPatchColorAt(xcor, ycor) == c) {
			return true;
		} else {
			return false;
		}
	}

	public String sendToAgent()
	{
		
		if (!jobList.isEmpty()){
			AM24Base.addToTotalEnergyUsed(1);
			 energyLeft = energyLeft-1;
			 
			AM24Job job = (AM24Job) jobList.poll();
			println("Job: "+jobList.size());
			AM24Message ExplorerMessage = new AM24Message(job);
			Random rand = new Random();		
			Turtle[] ts = turtlesHere();//turtlesAt(xBase,yBase);
			int tsRand = 0;
			println("Send Message!!!");
			if (ts != null)
				tsRand = rand.nextInt(ts.length);
			    println("RandomTransporter: "+tsRand);
				 //for (int i=0; i < ts.length;i++)
					 if (ts[tsRand].getColor() == Color.BLUE)
						 sendMessage(ts[tsRand].getAddress(),ExplorerMessage);
			/*if (ts != null)
			{
				tsRand = rand.nextInt(ts.length);
				sendMessage(ts[tsRand].getAddress(),ExplorerMessage);
				
			}*/
			energyLeft = energyLeft-1;
			return ("sendToAgent");
		}
		return ("walk");
	}
}


