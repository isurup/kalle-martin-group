/*
 * AM24Launcher.java -TurtleKit - A 'star logo' in MadKit
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
package am24.launcher;

import java.util.Random;

import turtlekit.kernel.Launcher;
import turtlekit.kernel.Turtle;
import madkit.kernel.Message;
import madkit.lib.messages.ACLMessage;
import am24.agents.*;
import am24.util.AM24Constraints;


public class AM24Launcher extends Launcher {

	

	private ACLMessage messages;

	public AM24Launcher() {
		setSimulationName("AM24Planet");
	}

	public void setup() {
		setWidth(AM24Constraints.gridSizeWidth);
		setHeight(AM24Constraints.gridSizeHeight);
		setWrapModeOn(AM24Constraints.wrapOn);
				
	}

	public void addSimulationAgents() {

		for (int i = 0; i < AM24Constraints.nbOfBases; i++) {

			Turtle nt = new AM24Base();
			//int basePosX = (int) Math.random()* getWidth();
			Random r = new Random();
			int basePosX = r.nextInt(getWidth());
			int basePosY = r.nextInt(getHeight());
			addTurtle(new AM24Base(), basePosX, basePosY);

			// deploy Explorers
			for (int e = 0; e < AM24Constraints.nbOfExplorers; e++) {
				addTurtle(new AM24Explorer("walk"), basePosX, basePosY);
			}

			// deploy Transportes
			for (int t = 0; t < AM24Constraints.nbOfTransporter; t++) {
				addTurtle(new AM24Transporter("walk"), basePosX, basePosY);
			}

		}

		addViewer(6);
		
		// Set the enviroment variable
		addObserver(new AM24PatchInit(AM24Constraints.oreDensity), false);
	}

}