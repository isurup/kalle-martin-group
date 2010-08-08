package launcher;

import java.awt.Color;

import turtlekit.kernel.Observer;

public class PatchInit extends Observer {
	
	private static final long serialVersionUID = -1964925049880093389L;
	float densityRate;
	
	public PatchInit(){
		densityRate = 0.2f;
	}
	
	public PatchInit(float density) {
		densityRate = density;
	}
	
	public void setup() {
		for (int i=0;i<envWidth;i++) {
			for (int j=0; j<envHeight ;i++) {
				if (Math.random() < densityRate) {
					patchGrid[i][j].setColor(Color.YELLOW);
				} else {
					patchGrid[i][j].setColor(Color.BLACK);
				}
			}
		}
	}
	
	
	

}
