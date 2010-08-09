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
	 private ArrayBlockingQueue<AM24Job> jobList = null;
	 
	 AM24Job homeJob;
	 
	 public AM24Explorer(){
	 	super();
	 }
	 
	 public AM24Explorer(String s)
	  {super(s);}
	
	 public void setup(){
	  	randomHeading();
	  	setColor(Color.WHITE);
	  	playRole("explorer");
	  	jobList = new ArrayBlockingQueue<AM24Job>(PlanetConstraints.robotMemorySize);
	  	
	  	AM24Job homeJob = new AM24Job(xcor(), ycor(), xcor(), ycor());
	  	jobList.add(homeJob);
	  }
	
	 public String walk(){
		fd(1);
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
		  return("walk");
  }
	 public void OreWithinPerception(){
		
		 int Ptmp = PlanetConstraints.robotPerceptionScope;
		 
		 for(int i = xcor()- Ptmp; i <= Ptmp + xcor(); i++){
			 for(int j = ycor()- Ptmp; j<= Ptmp + ycor(); j++){
				 if(getPatchColorAt(i,j) == Color.pink){
					 AM24Job job = new AM24Job( i, j , homeJob.getBasePosX(), homeJob.getBasePosY());
					 jobList.add(job);
				 }
			 }
		 }
	 }

}


