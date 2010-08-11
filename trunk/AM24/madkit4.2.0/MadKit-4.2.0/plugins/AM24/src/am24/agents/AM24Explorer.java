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
		setColor(Color.RED);
		playRole("explorer");
		jobList = new ArrayBlockingQueue<AM24QueueObject>(AM24Constraints.robotMemorySize-AM24Constraints.nbOfBases);
		energyLeft = AM24Constraints.robotEnergy;
		AM24BasePos basePos = new AM24BasePos(xcor(), ycor());
		xBase = basePos.getBasePosX();
		yBase = basePos.getBasePosY();

	}

	public String walk(){

		//println("energyLeft "+energyLeft);
		if(fullQueue)
		{
			return("returnToBase");
		}
		else
			fd(1);
		energyLeft = energyLeft-AM24Constraints.movingCost;

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
		return("walk");
	}

	public String returnToBase(){
		if(xBase!=xcor()&&yBase!=ycor()){		
			setHeading(towards(xBase,yBase));
			return ("moveRobot");
		}
		//println("Where The Explorer thinks the base is: "+xcor()+" "+ycor());
		//println("Initial Base Position: "+xBase+" "+yBase);
		fullQueue=false;
		return("explorerWaitForTransporter");  


		
	}
	public String moveRobot(){
		if((distance(xBase,yBase))*AM24Constraints.movingCost < energyLeft){
			fd(1);
			AM24Base.addToTotalEnergyUsed(AM24Constraints.movingCost);
			energyLeft = energyLeft-AM24Constraints.movingCost;
			if(xBase!=xcor()||yBase!=ycor())
				return ("moveRobot");
		} 
			return ("returnToBase");	
	}

	private void checkPerceptionScope(Color c)
	{
		int pScope = AM24Constraints.robotPerceptionScope;
		int gWidth = getWorldWidth();
		int gHeight = getWorldHeight();
		energyLeft=energyLeft-(2*AM24Constraints.robotPerceptionScope+1);
		AM24Base.addToTotalEnergyUsed(2*AM24Constraints.robotPerceptionScope+1);
		
		//check if we wrap is on
		if (AM24Constraints.wrapOn)
		{

			for (int i = xcor() - pScope; i <= xcor()+ pScope; i++)
			{

//				if(i>gWidth) // Warp X
//				{
//					i = i - gWidth;
//				}
//				if(i <= 0)
//				{
//					i = gWidth + i;
//				}

				if (i >= 0 && i < gWidth) { // check x boundaries
					for (int j = ycor() - pScope; j <= ycor()+ pScope; j++)
					{

						if(i>=gHeight) // Warp y
						{
							j = j - gHeight;
						}
						if(j <= 0)
						{
							j = gHeight + j;
						}
						if (j >= 0 && j < gHeight) { // check y boundaries
							println("For ITeration Loop(x,y): " + i + ","+ j+" " +xcor()+","+ycor());
							if (checkPathFor(c, i, j)) {

								try 
								{
									if (jobList.offer(new AM24Job(i, j)))
									{
										println("found ore at(x,y): " + i + ","+ j+" " +xcor()+","+ycor());
									}
									else
									{

										// memory is full go home
										println("Memory is full go home to base");
										fullQueue = true;
										break;
									}
								} catch (Exception e) {
									// HMM hehe
								}
							}
						}
					}
				}
			}
		}
	}

	private Boolean checkPathFor(Color c, int xcor, int ycor) {

		if (getPatchColorAt(xcor-xcor(), ycor-ycor()) == c) {
			setPatchColorAt(Color.YELLOW,xcor-xcor(),ycor-ycor());
			return true;
		} else {
			return false;
		}
	}

	public String explorerWaitForTransporter()
	{
		Turtle[] ts = turtlesAt(xBase-xcor(),yBase-ycor());//turtlesAt(xBase,yBase);
		if (ts.length > 1) {
			return("sendToAgent"); 
		} else {
			return("explorerWaitForTransporter");
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
			Turtle[] ts = turtlesAt(xBase-xcor(),yBase-ycor());//turtlesAt(xBase,yBase);
			println("Base position: "+xBase+","+yBase);
			
			print("TurtlesAt: ");
			for(Turtle t: ts) {
				print(t.getName()+" ");
			}
			println("");
			
			int tsRand = 0;
			println("Send Message!!!");
			if (ts != null)
				tsRand = rand.nextInt(ts.length);
				//println("RandomTransporter: "+tsRand);
				/*for (int i=0; i < ts.length;i++)
					if (ts[i].getColor() == Color.blue)
						sendMessage(ts[i].getAddress(),ExplorerMessage);*/
			for (int i=0; i < ts.length;i++)
			if (ts[tsRand].getColor() == Color.BLUE)
						 sendMessage(ts[tsRand].getAddress(),ExplorerMessage);
			energyLeft = AM24Constraints.robotEnergy;
		}
		return ("walk");
	}
}


