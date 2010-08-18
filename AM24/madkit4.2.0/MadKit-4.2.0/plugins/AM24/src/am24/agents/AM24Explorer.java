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
	private AM24Constraints cunts;

	public AM24Explorer(){
		super();
	}

	public AM24Explorer(String s)
	{super(s);}

	public void setup(){
		cunts = new AM24Constraints();
		randomHeading();
		setColor(Color.RED);
		playRole("explorer");
		jobList = new ArrayBlockingQueue<AM24QueueObject>(cunts.robotMemorySize-1);//AM24Constraints.nbOfBases);
		energyLeft = cunts.robotEnergy;
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
		energyLeft = energyLeft-cunts.movingCost;
		if((distance(xBase,yBase))*cunts.movingCost < energyLeft){
		if (count < 0) {
			count = (int) (Math.random()*90);
			checkPerceptionScope(Color.pink);
			randomHeading();
			return("walk");
		}
		else {
			count--;
			checkPerceptionScope(Color.pink);
			energyLeft = energyLeft-(cunts.robotPerceptionScope*cunts.robotPerceptionScope+1);
			return ("walk");
		}
		}
		return("returnToBase");
	}  

	

	public String returnToBase(){
		if(xBase!=xcor()&&yBase!=ycor()){		
			setHeading(towards(xBase,yBase));
			return ("moveRobot");
		}
		fullQueue=false;
		return("explorerWaitForTransporter");  


		
	}
	public String moveRobot(){
		if((distance(xBase,yBase))*cunts.movingCost < energyLeft){
			fd(1);
			AM24Base.addToTotalEnergyUsed(cunts.movingCost);
			energyLeft = energyLeft-cunts.movingCost;
			if(xBase!=xcor()||yBase!=ycor())
				return ("moveRobot");
		} 
			return ("returnToBase");	
	}

	private void checkPerceptionScope(Color c)
	{
		int pScope = cunts.robotPerceptionScope;
		int gWidth = getWorldWidth();
		int gHeight = getWorldHeight();
		energyLeft=energyLeft-(2*cunts.robotPerceptionScope+1);
		AM24Base.addToTotalEnergyUsed(2*cunts.robotPerceptionScope+1);
		
		//check if we wrap is on
		if (cunts.wrapOn)
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
							//println("For ITeration Loop(x,y): " + i + ","+ j+" " +xcor()+","+ycor());
							if (checkPathFor(c, i, j)) {

								try 
								{
									if (jobList.offer(new AM24Job(i, j)))
									{
										//println("found ore at(x,y): " + i + ","+ j+" " +xcor()+","+ycor());
									}
									else
									{

										// memory is full go home
										//println("Memory is full go home to base");
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
			//setPatchColorAt(Color.YELLOW,xcor-xcor(),ycor-ycor());
			return true;
		} else {
			return false;
		}
	}

	public String explorerWaitForTransporter()
	{
		Turtle[] ts = turtlesAt(xBase-xcor(),yBase-ycor());
		if (ts != null){
			for (int i=0; i < ts.length;i++)
				if (ts[i].getColor() == Color.BLUE){
					return("sendToAgent");
		
		}  
			return("explorerWaitForTransporter");
		
	}
		else return("explorerWaitForTransporter");
	}
	
	public String sendToAgent()
	{

		while (!jobList.isEmpty()){
			AM24Base.addToTotalEnergyUsed(1);
			energyLeft = energyLeft-1;

			AM24Job job = (AM24Job) jobList.poll();
			//println("Job: "+jobList.size());
			AM24Message ExplorerMessage = new AM24Message(job);
			Random rand = new Random();		
			Turtle[] ts = turtlesAt(xBase-xcor(),yBase-ycor());//turtlesAt(xBase,yBase);
			//println("Base position: "+xBase+","+yBase);
			
			/*print("TurtlesAt: ");
			for(Turtle t: ts) {
				print(t.getName()+" ");
			}
			println("");*/
			
			int tsRand = 0;
			//println("Send Message!!!");
			if (ts != null)
				//tsRand = rand.nextInt(ts.length);
				//println("RandomTransporter: "+tsRand);
				/*for (int i=0; i < ts.length;i++)
					if (ts[i].getColor() == Color.blue)
						sendMessage(ts[i].getAddress(),ExplorerMessage);*/
			for (int i=0; i < ts.length;i++)
				
			if (ts[i].getColor() == Color.BLUE)
				tsRand = rand.nextInt(ts.length);
						 sendMessage(ts[tsRand].getAddress(),ExplorerMessage);
		//return("sendToAgent");
		}
		energyLeft = cunts.robotEnergy;
		return ("walk");
	}
}

