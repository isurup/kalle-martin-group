
package dk.sdu.mmmi.intellihome.persistance;

import dk.sdu.mmmi.intellihome.core.api.API;
import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

/**
 *
 * @author jemr
 */
public interface Persistance extends API {
	public Set<String> getEventTypes();
	public List<DataEvent> getEvents(String eventType, Calendar startTime, Calendar endTime);
}
