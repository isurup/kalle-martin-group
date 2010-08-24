/*
 * MetaLauncher.java -A 'reactive simulation platform' using MadKit Kernel
 * Copyright (C) 2000-2005 Gregory Beurier
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

package turtlekit2.kernel.creators;
import madkit.kernel.AbstractAgent;

import org.w3c.dom.Document;

import turtlekit2.kernel.UI.Tk2UI;


public class Tk2Launcher extends AbstractAgent {
	private static final long serialVersionUID = 1L;
	
	
	final public static String COMMUNITY="Turtlekit";

	public void activate(){
		this.disposeMyGUI();
    	final Tk2Launcher m = this;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tk2UI(m).setVisible(true);
            }
        });
    }
	
	
	public String getGroupName(Document doc){
		String simulationName = Instancier.getFromNode(doc.getDocumentElement(), "Name", "Tk2 Simu");
		int i = 2;
		if (isGroup(Tk2Launcher.COMMUNITY,simulationName)) {
			while (isGroup(Tk2Launcher.COMMUNITY,simulationName + " " + i))
				i++;
			simulationName += " " + i;
		}
		return simulationName;
	}
}
