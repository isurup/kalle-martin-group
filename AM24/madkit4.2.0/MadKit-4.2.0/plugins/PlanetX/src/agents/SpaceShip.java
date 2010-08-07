package agents;

import java.awt.Color;
import java.util.Stack;

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
		
		Stack<Integer> fifo = new Stack<Integer>();
		fifo.push(17);
		int a = fifo.pop();

	}

}
