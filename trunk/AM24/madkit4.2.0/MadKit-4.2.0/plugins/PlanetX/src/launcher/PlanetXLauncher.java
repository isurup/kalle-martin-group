package launcher;

import turtlekit.kernel.Launcher;
import agents.Explorer;
import agents.SpaceShip;
import agents.Transporter;




public class PlanetXLauncher extends Launcher {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * env variables
	 */
	public static int nbOfExplorers = 10;
	public static int nbOfTransporters = 9;
	public static int nbOfSpaceShips = 1;
	public static float densityRate = 0.2f;

	
	
	public PlanetXLauncher() {
		setSimulationName("Star-Hores");
		setHeight(200);
		setWidth(200);
		setWrapModeOn(true);
	}
	
	


	
	public void addSimulationAgents()
	{
	  addViewer(4); // we choose a default viewer with a cell size of 3

	  /**
	   * Add the Spaceships
	   */
	 /* for (int i = 0; i < nbOfSpaceShips; i++) //add the Explorers
	  {
		  addTurtle(new SpaceShip());
	  }

	 */ 
	  for (int i = 0; i < nbOfExplorers; i++) //add the Explorers
	  {
		  addTurtle(new Explorer());
	  }
	  /*
	  for (int i = 0; i < nbOfTransporters; i++) //add the Transporters
	  {
		  addTurtle(new Transporter());
	  }
*/

	  // this method adds the PatchInitializer (an Observer) with no GUI (false)
	  //addObserver(new PatchInit(densityRate),false);
	}

}
