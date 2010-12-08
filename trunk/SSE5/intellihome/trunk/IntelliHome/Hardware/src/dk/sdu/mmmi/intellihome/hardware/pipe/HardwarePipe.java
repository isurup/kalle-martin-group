
package dk.sdu.mmmi.intellihome.hardware.pipe;

import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.hardware.Hardware;
import dk.sdu.mmmi.intellihome.core.pipe.Pipe;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
@ServiceProvider(service=Pipe.class, position=1000)
public class HardwarePipe extends Pipe<Hardware> {
	@Override
	public Class<Hardware> getAPI() {
		return Hardware.class;
	}

	@Override
	public String getName() {
		return "Hardware";
	}

	@Override
	public Set<String> getEventTypes() {
		Hardware hardware = getAPIImplementation();
		return hardware != null ? hardware.getEventTypes() : Collections.<String>emptySet();
	}

	@Override
	public List<DataEvent> getEvents(String eventType, Calendar startTime, Calendar endTime) {
		Hardware hardware = getAPIImplementation();
		return hardware != null ? hardware.getEvents(eventType, startTime, endTime) : Collections.<DataEvent>emptyList();
	}
}
