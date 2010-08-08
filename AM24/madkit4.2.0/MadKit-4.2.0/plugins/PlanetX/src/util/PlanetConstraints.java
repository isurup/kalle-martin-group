package util;

public class PlanetConstraints {
	
	public static int N; //number of bases.
	public static int D; //density of ore, as a percentage.
	public static int G; //size of the grid.
	public static int M; //coordination mode between bases,cooperative = 1 or competitive = 0.
	public static int X; //number of explorers per base.
	public static int Y; //number of transporters per base.
	public static int P; //initial perception scope.
	public static int I; //fixed communication scope.
	public static int S; //memory size of each robot(S < X+Y).
	public static int C; //capacity of each base in number of ore samples.
	public static int W; //maximal number of ore a robot can grab and/or carry.
	public static int T; //maximal number of cycles.
}
