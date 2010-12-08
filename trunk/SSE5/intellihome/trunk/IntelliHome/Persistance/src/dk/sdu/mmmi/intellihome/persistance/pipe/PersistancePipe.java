
package dk.sdu.mmmi.intellihome.persistance.pipe;

import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.persistance.Persistance;
import dk.sdu.mmmi.intellihome.core.pipe.Pipe;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
@ServiceProvider(service=Pipe.class, position=3000)
public class PersistancePipe extends Pipe<Persistance> {

	@Override
	public Class<Persistance> getAPI() {
		return Persistance.class;
	}

	@Override
	public String getName() {
		return "Persistance";
	}

	@Override
	public Set<String> getEventTypes() {
		Persistance persistance = getAPIImplementation();
		Set<String> result = new HashSet<String>(persistance != null ? persistance.getEventTypes() : Collections.<String>emptySet());
		result.addAll(super.getEventTypes());
		return result;
	}

	@Override
	public List<DataEvent> getEvents(String eventType, Calendar startTime, Calendar endTime) {
		Persistance persistance = getAPIImplementation();
		return persistance != null ? persistance.getEvents(eventType, startTime, endTime) : Collections.<DataEvent>emptyList();
	}
}
