package am24.util;

public class AM24Constraints {
	
	/***
	 * RobotEnergy - the amount of energy a robot has
	 */
	public final int robotEnergy = 5000;
	
	/***
	 * nbOfBases - Number of bases.
	 */
	public final int nbOfBases = 10;
	
	/***
	 * oreDensity - Density of ore.
	 */
	public final double oreDensity = 0.05;
	
	
	/***
	 * gridSizeHeight - The Height;
	 */
	public final int gridSizeHeight = 200;
	

	/***
	 * gridSizeWidth - The Width;
	 */
	public final int gridSizeWidth = 200;
	
	/**
	 * mode - Coordination mode between bases,cooperative = 1 or competitive = 0.
	 */
	public final int mode = 1;
	
	/*** 
	 * nbOfExplorers - Number of explorers per base.
	 */
	public  final int nbOfExplorers = 13;

	/***
	 * nbOfTransporter - Number of transporters per base.
	 */
	public final int nbOfTransporter = 7;
	
	/***
	 * robotPerceptionScope
	 */
	public final int robotPerceptionScope = 2;
	
	/***
	 * I - fixed communication scope.
	 */
	public final int fixedRobotCommunicationScope = 10;
	
	/***
	 * robotMemorySize
	 */
	public final int robotMemorySize = 10;
	
	/***
	 * C - Capacity of each base in number of ore samples.
	 */
	public final int baseCapacity = 200;
	
	/***
	 * W - Maximal number of ore a robot can grab and/or carry.
	 */
	public final int transporterOreCapacity = 8;
	
	/***
	 * maxSimulationTime  - Maximal number of cycles.
	 */
	public final int maxSimulationTime = 10000;
	
	/***
	 * movingCost - The cost to make one patch move
	 */
	public final int movingCost = 4;
	
	/***
	 * is wrap on
	 */
	public  final boolean wrapOn = true;
}
