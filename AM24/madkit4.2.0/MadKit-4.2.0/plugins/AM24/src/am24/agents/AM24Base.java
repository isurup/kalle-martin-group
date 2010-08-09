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

import am24.util.PlanetConstraints;
import turtlekit.kernel.Turtle;

/** the only thing is to walk and change color 
  @author Fabien MICHEL
  @version 1.2 6/12/1999 - used as a template: 03/2005
   */



 public class AM24Base extends Turtle 
 {	 
	 public AM24Base(){
	 	super();
	 }
	 
	 public AM24Base(String s)
	  {super(s);}
	
	 public void setup(){
	  	randomHeading();
	  	playRole("base");
	  	setColor(Color.GREEN);
	  }	 
	
	
	 
}


