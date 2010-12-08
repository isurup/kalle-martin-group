
package dk.sdu.mmmi.intellihome.synthetic;

import dk.sdu.mmmi.intellihome.dataaccess.DataEvent;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author jemr
 */
public interface SyntheticDataSource {
	public String getEventType();
	public List<DataEvent> getEvents(Calendar start, Calendar end);
}