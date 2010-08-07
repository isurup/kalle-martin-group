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


package turtlekit2.kernel.observers;

import java.awt.Graphics;

import javax.swing.JComponent;

import turtlekit2.kernel.UI.GUIMessage;
import turtlekit2.kernel.UI.SimulationUI;
import turtlekit2.kernel.agents.Turtle;
import turtlekit2.kernel.creators.Tk2Launcher;
import turtlekit2.kernel.environment.Patch;



/**Viewer is the simulation default world displayer agent (an specialized Observer,
	it can be extended to redefine the default representation of patches and
	turtles (a square fill with the color return by the getColor() method of them).

	@author Fabien MICHEL, Gregory Beurier
	@version 2009 */

public class Viewer extends Observer
{
	private static final long serialVersionUID = 1L;
	public int cellSize;
	public GridCanvas onScreen;
	protected int cpt=10;
	protected int flashTime=10;
	protected boolean flash = false;
	protected boolean show = true;
	protected boolean redrawAll = false;
	public TurtleProbe allTurtles;

	public void setFlash (boolean add)
	{
		if (add)
		{
			redrawAll=true;
			onScreen.display();
			redrawAll=false;
		}
		flash = add;
	}
	public boolean getRedrawAll(){return redrawAll;}
	public void setRedrawAll(boolean b){ redrawAll=b;}
	public boolean getFlash(){return flash;}
	public void setShow (boolean add)
	{
		if (add && (! show) && onScreen != null)
		{
			redrawAll=true;
			onScreen.display();
			redrawAll=false;
			show = true;
		}
		else show = add;
	}
	public boolean getShow(){return show;}
	public void setFlashStepSize (int add){flashTime = add;cpt=flashTime;}
	public int getFlashStepSize(){return flashTime;}

	/**MadKit usage, no redefinition*/
	public void initGUI()
	{
		setGUIObject(onScreen = new GridCanvas(cellSize*envWidth,cellSize*envHeight,this));
	}

	/**init the GUI*/
	public void setup()  
	{
		leaveRole(Tk2Launcher.COMMUNITY,getSimulationGroup(),"observer");
		requestRole(Tk2Launcher.COMMUNITY,getSimulationGroup(),"viewer",null);
		allTurtles = new TurtleProbe(getSimulationGroup(),"turtle");
		addProbe(allTurtles);
		onScreen.initialisation();
		sendMessage(Tk2Launcher.COMMUNITY, getSimulationGroup(), "UIManager", new GUIMessage<JComponent>(onScreen, SimulationUI.VIEWER_ZONE, "Viewer"));
	}

	/**override this method if you want an other patch graphic representation
	giving an on screen location (x,y), a patch p to draw
	and a reserved on screen patch size: a square of pixels with a side of cellS.
	As the simulation display is optimized,
	be sure that you draw a figure that is contained in the reserved square or set
	the redrawAll variable to true (in the property box or in constructor
	so the patches are all repainted first,
	then the turtles (avoid to leave turtle trace on the floor,
	but realy slow down the simulation). 
	By example you can use the patch access methods to decide the color to display for this.
	default:
		g.setColor(p.getColor());
		g.fillRect(x,y,cellS,cellS);*/
	public void paintPatch(Graphics g, Patch p,int x,int y,int cellS)
	{
		g.setColor(p.color);
		g.fillRect(x,y,cellS,cellS);
	}

	/** In the same way, you can give a special graphic representation of your turtles.
		Default:
		g.setColor(t.getColor());
		g.fillRect(x,y,cellS,cellS);*/
	public void paintTurtle(Graphics g, Turtle t,int x,int y,int cellS)
	{
		g.setColor(t.color);
		g.fillRect(x,y,cellS,cellS);
	}

	protected void paintInfo(Graphics g)
	{
		if (redrawAll)
			for (int i=envWidth-1; i >=0 ; i--)
				for (int j=envHeight-1; j >=0; j--)
					paintPatch(g, patchGrid[i][j],i*cellSize,(envHeight-j-1)*cellSize,cellSize);
		else
			for (int i=envWidth-1; i >=0 ; i--)
				for (int j=envHeight-1; j >=0; j--)
					if (patchGrid[i][j].change)
						paintPatch(g, patchGrid[i][j],i*cellSize,(envHeight-j-1)*cellSize,cellSize);
		Turtle[] turtles = allTurtles.getTurtles();		
		for(int i=turtles.length-1;i>=0;i--)
		{
			if (turtles[i] != null && ! turtles[i].hidden)
				paintTurtle(g,turtles[i],turtles[i].xcor()*cellSize,(envHeight-turtles[i].ycor()-1)*cellSize,cellSize);
		}
	}

	/**the display itself*/
	public void display()
	{
//		System.err.println("2D: " + patchGrid);
		if (show)
			if (flash) 
			{
				cpt--;
				if (cpt < 0) 
				{
					redrawAll=true;
					cpt=flashTime;
					onScreen.display();
					redrawAll=false;
				}
			}
			else 
				onScreen.display();
		
	}
	/**
	 * @return Returns the onScreen.
	 */
	public GridCanvas getOnScreen() {
		return onScreen;
	}
	/**
	 * @param onScreen The onScreen to set.
	 */
	public void setOnScreen(GridCanvas onScreen) {
		this.onScreen = onScreen;
	}
	/**
	 * @return Returns the cellSize.
	 */
	public int getCellSize() {
		return cellSize;
	}
}

/** this class defines the Graphics object (the agent's GUI) where the display is finally made
  @author Fabien MICHEL
  @version 1.2 20/3/2000 
 */


