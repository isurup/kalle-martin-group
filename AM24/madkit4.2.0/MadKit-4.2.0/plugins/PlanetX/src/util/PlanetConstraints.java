package util;

public class PlanetConstraints {
	
	public static int N; //N bases land randomly to collect ore samples.
	public static int D; //The ore is distributed on the planet with a density D.
	public static int M; //Coordination mode M of the bases...
	public static int X; //X explorers
	public static int Y; //Y transporters
	public static int P; //Each robot has a finite perception scope P.
	public static int I; //finite communication scope I
	public static int S; //limited size memory to record a maximum of S (S < X+Y) coordinates
	public static int C; //The capacity C of the base is limited.
	public static int W; //Robots have a limited capacity W of ore
	public static int T; //When the base is full of ore or after a given time T, robots alive return to the base.
}
