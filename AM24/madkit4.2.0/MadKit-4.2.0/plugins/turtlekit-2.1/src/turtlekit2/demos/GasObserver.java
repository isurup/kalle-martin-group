/*
 * GasObserver.java -TurtleKit - A 'star logo' in MadKit
 * Copyright (C) 2000-2007 Fabien Michel
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
package turtlekit2.demos;

import java.awt.Color;

import javax.swing.JComponent;

import turtlekit2.kernel.UI.GUIMessage;
import turtlekit2.kernel.UI.MCharter;
import turtlekit2.kernel.UI.SimulationUI;
import turtlekit2.kernel.agents.Turtle;
import turtlekit2.kernel.creators.Tk2Launcher;
import turtlekit2.kernel.observers.Observer;
import turtlekit2.kernel.observers.TurtleProbe;

/** This agent watch the gas simulation (nb of turtles on right or left) 
  @author Fabien MICHEL
  @version 1.1 6/12/1999 */

@SuppressWarnings("serial")
public class GasObserver extends Observer
{
	TurtleProbe allTurtles;
	int wall,holeSize;
	double[] t= {0};
	
	MCharter chart;
	@Override

	public void setup() {
		//paint the box
		for(int i=0;i<patchGrid[0].length;i++)
			patchGrid[getAttrib().getInt("wall")][i].setColor(Color.white);
		
		for (int i=0;i < getAttrib().getInt("holesize");i++)
			patchGrid[getAttrib().getInt("wall")][envHeight/2-getAttrib().getInt("holesize")/2+i].setColor(Color.black);
		
//		
//		chart = new MCharter(t);
//		this.sendMessage(Tk2Launcher.COMMUNITY, getSimulationGroup(), "UIManager",
//				new GUIMessage<JComponent>(chart, SimulationUI.VIEWER_ZONE, "Chart"));
	}

	public void watch(){
//		int cpt = 0;
//		for (final Turtle t : allTurtles.getCurrentAgentsList()) {
//			if (t.xcor()>= ((Gas)t).wall)
//				cpt++;
//		}
//		t[0] = cpt;
//		chart.update(t);
	}

}
