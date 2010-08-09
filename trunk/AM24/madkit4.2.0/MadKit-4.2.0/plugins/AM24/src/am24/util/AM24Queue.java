/***
 * AM24 - Project
 * 
 * AM24Queue - The queue for the agents
 * 
 * @author Morten Knudsen 
 */

package am24.util;

import java.util.concurrent.ArrayBlockingQueue;

public class AM24Queue {
		
	private ArrayBlockingQueue<AM24Job> jobQueue = null;
	
	public AM24Queue(int capasity) {
		jobQueue = new ArrayBlockingQueue<AM24Job>(capasity);
	}
	
	/***
	 * 
	 * @return the top element
	 */
	public AM24Job poll()
	{
		return jobQueue.poll();
	}
	
	/***
	 * 
	 * @param AM24job
	 */
	public void add(AM24Job job) 
	{
		jobQueue.add(job);
	}

	/***
	 * 
	 * @param job
	 * @return
	 */
	public boolean offer(AM24Job job)
	{
		return jobQueue.offer(job);
	}
	
	
}
