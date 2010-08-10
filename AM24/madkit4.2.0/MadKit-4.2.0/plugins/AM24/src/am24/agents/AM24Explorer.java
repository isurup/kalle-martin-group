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

import am24.util.*;
import turtlekit.kernel.Turtle;


 public class AM24Explorer extends Turtle 
 {
	 int count=10;
	 
	 private double energyLeft = AM24Constraints.robotEnergy;
	 private ArrayBlockingQueue<AM24QueueObject> jobList = null;
	 
	 public AM24Explorer(){
	 	super();
	 }
	 
	 public AM24Explorer(String s)
	  {super(s);}
	
	 public void setup(){
	  	randomHeading();
	  	setColor(Color.WHITE);
	  	playRole("explorer");
	  	jobList = new ArrayBlockingQueue<AM24QueueObject>(AM24Constraints.robotMemorySize);
	  	
	  	AM24BasePos basePos = new AM24BasePos(xcor(), ycor());
	  	jobList.add(basePos);
	  }
	
	 public String walk(){
		fd(1);
		energyLeft = energyLeft-AM24Constraints.movingCost;
	   	if (count < 0) {
	      count = (int) (Math.random()*90);
	      return("change");
	    }
	   	else {
	  	  count--;
	 	  return ("walk");
	   	}
	}  
	
	 public String change(){
		  randomHeading();
		  /*if (getHeading() > South) setColor(Color.red);
		  else if (getHeading() > West) setColor(Color.blue);
		    else if (getHeading() > North) setColor(Color.green);
		      else setColor(Color.yellow);*/
		  
		  // + 2 for extra precaution
			 if((distance(xBase,yBase)*AM24Constraints.movingCost)+ 2 < energyLeft){
				 return("returnToBase");
			 }
		  
		  return("walk");
  }
	 private void FindOreWithWarp(){
		
		 int Ptmp = AM24Constraints.robotPerceptionScope;
		 
		// Wrapping of grid
		 int itmp;
		 int jtmp;
		 
		 if(AM24Constraints.gridSizeWidth - xcor()- Ptmp<AM24Constraints.gridSizeWidth)
		 {
			 itmp = AM24Constraints.gridSizeWidth - xcor()- Ptmp;
		 }
		 else
		 {
			 itmp = xcor()- Ptmp;
		 }
		 
		 if(AM24Constraints.gridSizeHeight - ycor()- Ptmp<AM24Constraints.gridSizeHeight)
		 {
			 jtmp = AM24Constraints.gridSizeHeight - ycor()- Ptmp;
		 }
		 else
		 {
			 jtmp = ycor()- Ptmp;
		 }
		 //
		 
		 // find ore, add job
		 for(int i = itmp; i == Ptmp + xcor() || i == AM24Constraints.gridSizeWidth - xcor()- Ptmp ; i++)
		 {
			 if (i > AM24Constraints.gridSizeWidth)
			 {
				 i = i - AM24Constraints.gridSizeWidth;
			 }
			 for(int j = jtmp; j == Ptmp + ycor() || j == AM24Constraints.gridSizeHeight - ycor()- Ptmp; j++)
			 {
				 if(j > AM24Constraints.gridSizeHeight)
				 {
					 j = j - AM24Constraints.gridSizeHeight;
				 }
				 if(getPatchColorAt(i,j) == Color.pink)
				 {
					 AM24Job job = new AM24Job( i, j );
					 jobList.add(job);
				 }
			 }
		 }
	 }
	 
	 private void FindOreWithoutWarp(){
			
		 int Ptmp = AM24Constraints.robotPerceptionScope;
		 
		// No Warping of grid
		 int itmp = xcor()- Ptmp;
		 int jtmp = ycor()- Ptmp;
	
		 // find ore, add job
		 for(int i = itmp; i == Ptmp + xcor() || i > AM24Constraints.gridSizeWidth; i++)
		 {
			 for(int j = jtmp; j == Ptmp + ycor() || j > AM24Constraints.gridSizeHeight; j++)
			 {
				 if(getPatchColorAt(i,j) == Color.pink)
				 {
					 AM24Job job = new AM24Job( i, j );
					 jobList.add(job);
				 }
			 }
		 }
		 
	 }
	 
	 public void FindOre(){
		 
		 if(AM24Constraints.wrapOn)
		 {
			 FindOreWithWarp();
		 }
		 else
		 {
			 FindOreWithoutWarp();
		 }
	 }

// the end
}


