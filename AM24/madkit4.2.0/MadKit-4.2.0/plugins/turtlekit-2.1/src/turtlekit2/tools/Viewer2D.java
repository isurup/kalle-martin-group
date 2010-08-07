/*
 * TurtleKit - A 'reactive simulation platform' using MadKit Kernel
 * Copyright (C) 2000-2007 Fabien Michel, Gregory Beurier
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

package turtlekit2.tools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import javax.swing.JScrollPane;

import turtlekit2.kernel.UI.GUIMessage;
import turtlekit2.kernel.UI.SimulationUI;
import turtlekit2.kernel.agents.Turtle;
import turtlekit2.kernel.creators.Tk2Launcher;
import turtlekit2.kernel.environment.Patch;
import turtlekit2.kernel.environment.PatchVariable;
import turtlekit2.kernel.observers.Viewer;
/**
 * <p>Titre : AdvancedViewer</p>
 * <p>Description : AdvancedViewer is a simulation world displayer agent. It displays flavors/pheromones according to RGB canals and
 * permits flavors observations and modifications in the environment in real time. </p>
 * <p>Use : To display a flavor on a RGB canal, click on the color then on the flavor name (mixing canals is allowed). To drop a flavor, click on drop then on the flavor name, then click within the environment. 
 * To modify the displaying scale, click on a color then roll mouse wheel over the environment. To display a flavor/pheromone quantity, do as drop
 * and move the mouse cursor over the environment.</p>
 * <p></p>
 * <p>XML Attributes : None</p>
 * @author Gregory Beurier
 */


public class Viewer2D extends Viewer implements MouseListener, MouseMotionListener, MouseWheelListener{
	private static final long serialVersionUID = 1L;


	boolean turtleDisplay = true;
	String dropedPheromones = "";
	Hashtable<String,Float> intensity;
	Hashtable<String,Color> colors;
	Hashtable<String,Boolean> pheroDisp;
	ArrayList<String> pheromones;
	double maxRed = 0;
	double maxGreen = 0;
	double maxBlue = 0;

	/**No usage*/
	public void init() {}

	/**MadKit usage, no redefinition*/
	public void initGUI() {
		super.initGUI();
		intensity = new Hashtable<String, Float>();
		colors = new Hashtable<String, Color>();
		pheroDisp = new Hashtable<String, Boolean>();
		pheromones = new ArrayList<String>();
		ArrayList<PatchVariable> flavors = getFlavors();
		for (Iterator iterator = flavors.iterator(); iterator.hasNext();) {
			PatchVariable patchVariable = (PatchVariable) iterator.next();
			pheromones.add(patchVariable.getName());
			intensity.put(patchVariable.getName(), 500f);
			colors.put(patchVariable.getName(), Color.WHITE);
			pheroDisp.put(patchVariable.getName(), false);
		}
		ViewOptions options = new ViewOptions(pheromones, this);
		JScrollPane pane = new JScrollPane(options);
		this.sendMessage(Tk2Launcher.COMMUNITY, getSimulationGroup(), "UIManager",
				new GUIMessage<JScrollPane>(pane, SimulationUI.CONSOLE_ZONE, "Adv View Options"));
	}



	/**Standard graphical representation of turtle. Can be disabled/enabled in real time. 
	 * You can override this method in order to give a special graphic representation of your turtles.*/
	public void paintTurtle(Graphics g, Turtle t,int x,int y,int cellS)
	{
		if(turtleDisplay){
			g.setColor(t.getColor());
			g.fillRect(x,y,cellS,cellS);
		}
	}

	/**The Paintpatch method has been overriden in order to achieve specific representation of flavors. 
	 * Each flavor can be represented as a function of the Red/Blue/Green/Black canals.*/
	public void paintPatch(Graphics g, Patch p,int x,int y,int CellSize)
	{
		if(p.color.equals(Color.BLACK)){

			double red = getQuantity(p,0);
			double blue = getQuantity(p,2);
			double green = getQuantity(p,1);

			if(red > maxRed) maxRed = red;
			if(blue > maxBlue) maxBlue = blue;
			if(green > maxGreen) maxGreen = green;

			int r = new Double(red/maxRed * 255).intValue();
			int b = new Double(blue/maxBlue * 255).intValue();
			int gr = new Double(green/maxGreen * 255).intValue();


			Color d = new Color( r, gr, b);
			g.setColor(d);
		}
		else
			g.setColor(p.color);

		
		g.fillRect(x,y,CellSize,CellSize);
	}




	private double getQuantity(Patch p, int i) {
		double result = 0;
		for (int j = 0; j < pheromones.size(); j++) {
			String o = pheromones.get(j);
			double factor = 0;
			switch (i) {
			case 0:
				factor = (colors.get(o).getRed() / 255);
				break;
			case 1:
				factor = (colors.get(o).getGreen() / 255);
				break;
			case 2:
				factor = (colors.get(o).getBlue() / 255);
				break;
			default:
				break;
			}
			double add = p.getVariableValue(o) 
			* (intensity.get(o) / 500)
			* factor;
			if(!pheroDisp.get(o)) add = 0;
			result += add;
		}
		return result;
	}

	/**GUI method*/
	public void mousePressed(MouseEvent e){}
	/**GUI method*/
	public void mouseReleased(MouseEvent e){}
	/**GUI method*/
	public void mouseEntered(MouseEvent e){}
	/**GUI method*/
	public void mouseExited(MouseEvent e){}
	/**GUI method*/
	public void mouseClicked(MouseEvent e){}
	/**GUI method. It drops Pheromones/Flavors on the environment*/



	public void mouseDragged(MouseEvent e){
		//		 int x = e.getX()/getCellSize();
		//	     int y = e.getY()/getCellSize();
		//	     if(flavorsContains(dropPher)) patchGrid[x][envHeight - y].incrementPatchVariable(dropPher,1000);
	}


	/**GUI method. When a Flavor is selected to be dropped, it displays its quantity in the environment.*/   
	public void mouseMoved(MouseEvent e){
		//	    	cord.setText("X:" +e.getX()/getCellSize() + " Y:"+ (e.getY())/getCellSize());
		//	    	if(!dropPher.equals("") && !dropPher.equals(null)){
		//	    		phero.setText(new Double(patchGrid[e.getX()/getCellSize()][envHeight - e.getY()/getCellSize()].getVariableValue(dropPher)).toString());
		//	    	}
	}


	/**GUI method. WheelMouse modify the scale of flavors displaying as a function of RGB canals.*/
	public void mouseWheelMoved(MouseWheelEvent e) {
		int notches = e.getWheelRotation();
		//	        if(modifiedColor == RED){
		//	        	redFactor += notches*20;
		//		 	}else if(modifiedColor == GREEN){
		//		 		greenFactor += notches*20;
		//		 	}else if(modifiedColor == BLUE){
		//		 		blueFactor += notches*20;
		//		 	}else if(modifiedColor == BLACK){
		//		 		blackFactor += notches*20;
		//		 	}
		//	        factors.setText("R:" + redFactor + " G:"+ greenFactor + " B:" + blueFactor + " Bl:" + blackFactor);
	}



	public void updatePheromoneColor(String phero2, Color newColor) {
		colors.put(phero2, newColor);
	}

	public void updatePheromoneIntensity(String phero2, Float value) {
		intensity.put(phero2, value);

	}

	public void setViewable(String phero2, boolean b) {
		pheroDisp.put(phero2, b);
	}

	public void setTurtlesViewable(boolean b) {
		turtleDisplay = b;
	}

	public void setDropedPheromones(String selectedValue) {
		dropedPheromones = selectedValue;
	}
}

