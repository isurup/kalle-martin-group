package agents;

import java.awt.Color;

import turtlekit.kernel.Turtle;

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
	}

}
