package turtlekit2.tools;

import javax.swing.JComponent;

import turtlekit2.kernel.UI.GUIMessage;
import turtlekit2.kernel.UI.MCharter;
import turtlekit2.kernel.UI.SimulationUI;
import turtlekit2.kernel.creators.Tk2Launcher;
import turtlekit2.kernel.observers.Observer;

public class Charter extends Observer{
	private static final long serialVersionUID = 1L;
	String phero = "";
	MCharter chart;
	@Override
	public void setup() {
		phero = getAttrib().getString("Pheromone");
		chart = new MCharter(0, 0, 0);
		this.sendMessage(Tk2Launcher.COMMUNITY, getSimulationGroup(), "UIManager",
				new GUIMessage<JComponent>(chart, SimulationUI.VIEWER_ZONE, "Chart"));
	}
	
	public void watch(){
		double var[] = new double[3];
		double sum = 0;
		for (int i = 0; i < envHeight; i++) {
			for (int j = 0; j < envHeight; j++) {
				double pheroQ = patchGrid[i][j].getVariableValue(phero);
				var[0] += pheroQ;
				var[1] += pheroQ;
				if(pheroQ > 4) sum++;
			}
		}
		var[2] = sum;
		var[1] /= envHeight * envWidth;
		chart.update(var);
	}
}
