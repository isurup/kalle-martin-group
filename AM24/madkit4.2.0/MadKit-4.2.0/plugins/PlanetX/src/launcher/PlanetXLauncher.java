package launcher;

import agents.Explorer;
import agents.Transporter;
import turtlekit.kernel.*;

public class PlanetXLauncher extends Launcher {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * env variables
	 */
	private static final int nbOfExplorers = 10;
	private static final int nbOfTransporters = 9;
	
	public void addSimulationAgents()
	{
	  addViewer(3); // we choose a default viewer with a cell size of 3

	  for (int i = 0; i < nbOfExplorers; i++) //add the Explorers
	  {
		  addTurtle(new Explorer());
	  }
	  
	  for (int i = 0; i < nbOfTransporters; i++) //add the Transporters
	  {
		  addTurtle(new Transporter());
	  }

	  // this method adds the PatchInitializer (an Observer) with no GUI (false)
	  //addObserver(new PatchInitializer(nbOfExplorers),false);
	}

}
