
package dk.sdu.mmmi.intellihome.core.api;

import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.core.pipe.Pipe;

/**
 *
 * @author jemr
 */
public interface API {
	public String getName();
	/**
	 * Return true if event should continue through the pipe
	 * Return false, if the line should be drawn here.
	 * @param event
	 * @return
	 */
	public boolean incomingEvent(DataEvent event);
	public void initialize(Pipe pipe);
	public void cleanup();
}
