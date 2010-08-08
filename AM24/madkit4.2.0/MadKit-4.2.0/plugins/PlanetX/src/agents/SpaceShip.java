package agents;

import java.awt.Color;
import java.util.*;
import turtlekit.kernel.Turtle;
import util.*;

public class SpaceShip extends Turtle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public SpaceShip() {
		super();
	}
	
	public void setup(){
		playRole("spaceship");
		setColor(Color.PINK);
		
		Queue<PlanetJob> jobList = new LinkedList<PlanetJob>();
	}

}
