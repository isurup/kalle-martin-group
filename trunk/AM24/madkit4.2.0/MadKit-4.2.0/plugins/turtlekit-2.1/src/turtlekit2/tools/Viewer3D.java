package turtlekit2.tools;

import javax.swing.JComponent;

import turtlekit2.kernel.UI.GUIMessage;
import turtlekit2.kernel.UI.SimulationUI;
import turtlekit2.kernel.creators.Tk2Launcher;
import turtlekit2.kernel.observers.TurtleProbe;
import turtlekit2.kernel.observers.Viewer;

public class Viewer3D extends Viewer{
	private static final long serialVersionUID = 1L;
	
	Tk3DView view3D;
	
	public void setup()  
	{
		leaveRole(Tk2Launcher.COMMUNITY,getSimulationGroup(),"observer");
		requestRole(Tk2Launcher.COMMUNITY,getSimulationGroup(),"viewer", null);
		allTurtles = new TurtleProbe(getSimulationGroup(),"turtle");
		addProbe(allTurtles);

		view3D = new Tk3DView(allTurtles.getCurrentAgentsList(), envWidth, envHeight, patchGrid);
		
		this.sendMessage(Tk2Launcher.COMMUNITY, getSimulationGroup(), "UIManager",
				new GUIMessage<JComponent>(view3D, SimulationUI.VIEWER_ZONE, "3D View"));
		
		
	}
	
//	public void display()
//	{
////		System.err.println("3D: " + patchGrid);
//		if (show)
//			if (flash) 
//			{
//				cpt--;
//				if (cpt < 0) 
//				{
//					redrawAll=true;
//					cpt=flashTime;
//					updatePatches();
//					redrawAll=false;
//				}
//			}
//			else 
//				updatePatches();
//		
//	}
//	protected void updatePatches(){
//			for (int i=envWidth-1; i >=0 ; i--)
//				for (int j=envHeight-1; j >=0; j--)
//					if (patchGrid[i][j].change){
//						patchGrid[i][j].change = false;
//						view3D.updatePatches(patchGrid[i][j],i,(envHeight-j-1));
//					}
//						
//	}
	
	
	
	
	
	public void reset(){
		view3D.reset(allTurtles.getCurrentAgentsList(), envWidth, envHeight);
	}
	
	
}
