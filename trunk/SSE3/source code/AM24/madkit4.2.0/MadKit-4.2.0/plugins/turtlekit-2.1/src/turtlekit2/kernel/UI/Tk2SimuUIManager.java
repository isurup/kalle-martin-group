package turtlekit2.kernel.UI;

import javax.swing.JComponent;

import madkit.kernel.Agent;
import turtlekit2.kernel.creators.Tk2Launcher;

public class Tk2SimuUIManager extends Agent {
	static final long serialVersionUID = 1l;
	public SimulationUI myGUI;
	String simulationName;

	public Tk2SimuUIManager(String simulationName) {
		super();
		this.simulationName = simulationName;
		myGUI = new SimulationUI();
	}

	
	@Override
	public void activate() {
		super.activate();
		this.requestRole(Tk2Launcher.COMMUNITY, simulationName, "UIManager", null);
		
		this.disposeMyGUI();
		
	}
	
	@SuppressWarnings("unchecked")
	public void live(){
		int nbMsg = 0;
		while(true){
			nbMsg++;
			GUIMessage<JComponent> msg = (GUIMessage<JComponent>) this.waitNextMessage();
			computeMessage(msg);
		}
	}
	
	public final void computeMessage(GUIMessage<JComponent> msg) {
		myGUI.addTabbedComponent(msg.getContent(), msg.getLocation(), msg.name);
	}

}
