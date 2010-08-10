package am24.util;

import madkit.kernel.Message;

public class AM24Message extends Message {
	@SuppressWarnings("serial")
		private int orePosX;
		private int orePosY;
		
		public AM24Message(int orePosX, int orePosY)
		{
			this.orePosX = orePosX;
			this.orePosY = orePosY;
		}
		
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

