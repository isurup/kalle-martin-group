package agents;

import java.awt.Color;
import java.util.*;
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

		 List<Object> spaceList = new ArrayList<Object>();
		 spaceList.add(1,3); // index 1, value 3
		 spaceList.get(1); // get from index 1
	}

}
