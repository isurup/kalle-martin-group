package am24.util;

public class AM24BasePos extends AM24QueueObject {

	private int basePosX;
	private int basePosY;
	
	public AM24BasePos(int basePosX, int basePosY)
	{
		this.basePosX = basePosX;
		this.basePosY = basePosY;
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
