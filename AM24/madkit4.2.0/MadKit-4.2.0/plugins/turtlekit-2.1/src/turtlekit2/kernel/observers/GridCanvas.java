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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;


/**
 * <p>Titre : GridCanvas</p>
 * <p>Description :  </p>
 * @author Fabien Michel, Gregory Beurier
 */
public class GridCanvas extends JComponent
{
	private static final long serialVersionUID = 1L;
	Viewer simuViewer;
	public Image buffer;
	Graphics bufferGraphics;

	public GridCanvas(int width,int height,Viewer l)
	{
		setBackground(Color.black);
		setForeground(Color.blue);
		setSize(width,height);
		simuViewer=l;
	}

	public void initialisation()
	{
		Dimension d = getSize();
		buffer = createImage(d.width,d.height);
		bufferGraphics = buffer.getGraphics();
		bufferGraphics.setColor(Color.black);
		bufferGraphics.fillRect(0,0,d.width,d.height);
	}

	public Dimension getPreferredSize() {return getSize();}

	void display()
	{
		if(getGraphics() != null)
		{
			simuViewer.paintInfo(bufferGraphics);
			getGraphics().drawImage(buffer,0,0,this);
		}
	}
}