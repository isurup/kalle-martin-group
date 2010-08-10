package am24.util;

import madkit.kernel.Message;
@SuppressWarnings("serial")
public class AM24Message extends Message {
	
		private AM24Job tmpJob;
		
		public AM24Message(AM24Job tmpJob)
		{
			this.tmpJob = tmpJob;
		}
		/**
		 * @return the orePosX
		 */
		public AM24Job getJob() {
			return tmpJob;
		}
	}

