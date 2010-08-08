package util;

public class PlanetConstraints {
	
	/***
	 * N - Number of bases.
	 */
	public static int N = 1;
	
	/***
	 * D - Density of ore, as a percentage.
	 */
	public static int D = 5;
	
	/***
	 * G - Size of the grid.
	 */
	public static int G;
	
	/**
	 * M - Coordination mode between bases,cooperative = 1 or competitive = 0.
	 */
	public static int M = 1;
	
	/*** 
	 * X - Number of explorers per base.
	 */
	public static int X;

	/***
	 * Y - Number of transporters per base.
	 */
	public static int Y;
	
	/***
	 * P - Initial perception scope.
	 */
	public static int P = 20;
	
	/***
	 * I - fixed communication scope.
	 */
	public static int I = 40;
	
	/***
	 * S - memory size of each robot(S < X+Y).
	 */
	public static int S = 19;
	
	/***
	 * C - Capacity of each base in number of ore samples.
	 */
	public static int C = 200;
	
	/***
	 * W - Maximal number of ore a robot can grab and/or carry.
	 */
	public static int W;
	
	/***
	 * T - Maximal number of cycles.
	 */
	public static int T;
}
