package util;

import turtlekit.kernel.TurtleScheduler;

public class PlanetScheduler extends TurtleScheduler {

	String group;
	private static final long serialVersionUID = 1L;
	
	public PlanetScheduler(String group) {
		super(group);
		this.group=group;
	}

}
