/***
 * AM24 - Project
 * 
 * @author Morten Knudsen
 */

package am24.launcher;

import java.awt.Color;
import turtlekit.kernel.Observer;

public class AM24PatchInit extends Observer {

	double densityRate;
	
	public AM24PatchInit() {}
	
	public AM24PatchInit(double densityRate){
		this.densityRate = densityRate;
	}
	
	public void setup() {
		for (int i=0; i < envWidth; i++) {
			for (int j=0; j < envHeight ;j++) {
				if (Math.random() < densityRate) {
					patchGrid[i][j].setColor(Color.pink);
				} else {
					patchGrid[i][j].setColor(Color.BLACK);
				}
			}
		}
	}
	
	
	

}
