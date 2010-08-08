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
	private static PlanetConstraints constrains;

	public SpaceShip() {
		super();
	}

	public void setup() {
		playRole("spaceship");
		setColor(Color.WHITE);
		
	}

}
