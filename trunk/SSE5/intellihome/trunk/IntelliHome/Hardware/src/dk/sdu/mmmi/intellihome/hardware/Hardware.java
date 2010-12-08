
package dk.sdu.mmmi.intellihome.hardware;

import dk.sdu.mmmi.intellihome.core.api.API;
import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author jemr
 */
public interface Hardware extends API {
	public String getResourceId(String eventId);
	public Map<String, Object> getResourceInfo(String resourceId);
	public void setValue(String resourceId, double value);
	public void fireEvent(String eventId, double defaultValue);
	public Set<String> getEventTypes();
	public List<DataEvent> getEvents(String eventType, Calendar startTime, Calendar endTime);	
}
