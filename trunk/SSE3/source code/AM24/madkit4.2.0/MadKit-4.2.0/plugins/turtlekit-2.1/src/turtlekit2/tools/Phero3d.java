package turtlekit2.tools;

import javax.swing.JComponent;

import turtlekit2.kernel.UI.GUIMessage;
import turtlekit2.kernel.UI.SimulationUI;
import turtlekit2.kernel.creators.Tk2Launcher;
import turtlekit2.kernel.observers.Observer;

public class Phero3d extends Observer{
	private static final long serialVersionUID = 1L;
	Phero3DViewer pheroViewer;
	String phero;
	
	@Override
	public void setup() {
		phero = getAttrib().getString("Pheromone");
		pheroViewer = new Phero3DViewer(patchGrid, phero, envWidth, envHeight);
		this.sendMessage(Tk2Launcher.COMMUNITY, getSimulationGroup(), "UIManager",
				new GUIMessage<JComponent>(pheroViewer, SimulationUI.VIEWER_ZONE, "3D Phero"));
	}
	
	public void watch(){
		
	}
	
	public void reset(){
		pheroViewer.reset(patchGrid, phero, envWidth, envHeight);
	}
}
