package agents;

import java.awt.Color;

import turtlekit.kernel.Turtle;

public class Transporter extends Turtle {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Transporter() {
		super();
	}
	
	public void setup()
	{
		playRole("Transporter");
		setColor(Color.CYAN);
		setHeading(NorthEast);
	}
	
	void wiggle() {
		fd(1);
		turnRight(Math.random() * 45);
		turnLeft(Math.random() * 45);
	}

}
