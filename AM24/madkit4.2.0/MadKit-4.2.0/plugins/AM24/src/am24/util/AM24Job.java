/***
 * @author Morten Knudsen
 */
package am24.util;

public class AM24Job extends AM24QueueObject{
	
	private int orePosX;
	private int orePosY;
	
	public AM24Job(int orePosX, int orePosY)
	{
		this.orePosX = orePosX;
		this.orePosY = orePosY;
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

}
