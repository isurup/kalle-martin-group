/***
 * @author Morten Knudsen
 */
package am24.util;

public class AM24Job {
	
	private int orePosX;
	private int orePosY;
	private int basePosX;
	private int basePosY;
	
	public AM24Job(int orePosX, int orePosY, int basePosX, int basePosY)
	{
		this.orePosX = orePosX;
		this.orePosY = orePosY;
		this.basePosX = basePosX;
		this.basePosY = basePosY;
	}

	/**
	 * @return the orePosX
	 */
	public int getOrePosX() {
		return orePosX;
	}

	/**
	 * @return the orePosY
	 */
	public int getOrePosY() {
		return orePosY;
	}

	/**
	 * @return the basePosX
	 */
	public int getBasePosX() {
		return basePosX;
	}

	/**
	 * @return the basePosY
	 */
	public int getBasePosY() {
		return basePosY;
	}

}
