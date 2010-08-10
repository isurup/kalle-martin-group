package am24.util;

import madkit.kernel.Message;
@SuppressWarnings("serial")
public class AM24Message extends Message {
	
		private int orePosX;
		private int orePosY;
		
		public AM24Message(int orePosX, int orePosY)
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
		
		/**
		 * @set the orePosX
		 */
		public void setOrePosX() {
		}
		
		/**
		 * @set the orePosX
		 */
		public void setOrePosY() {
		}
	}

