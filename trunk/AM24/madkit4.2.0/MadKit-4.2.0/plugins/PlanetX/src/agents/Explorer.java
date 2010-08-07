package agents;

import java.awt.Color;

import turtlekit.kernel.Turtle;

public class Explorer extends Turtle {

	public Explorer() {
		super();
	}

	public void setup() {
		playRole("explorer");
		setColor(Color.red);
		setHeading(West);
	}

	void wiggle() {
		fd(1);
		turnRight(Math.random() * 45);
		turnLeft(Math.random() * 45);
	}

}
