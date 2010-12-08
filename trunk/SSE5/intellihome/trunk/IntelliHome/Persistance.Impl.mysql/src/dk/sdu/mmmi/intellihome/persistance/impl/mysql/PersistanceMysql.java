package dk.sdu.mmmi.intellihome.persistance.impl.mysql;

import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.persistance.Persistance;
import dk.sdu.mmmi.intellihome.core.pipe.Pipe;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.openide.util.Exceptions;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
@ServiceProvider(service=Persistance.class)
public class PersistanceMysql implements Persistance {

    private HashMap<String, DataCache> cache = new HashMap<String, DataCache>();

    private DataCache getCache(String eventType) {
        DataCache data = cache.get(eventType);
        if (data == null) {
            data = new DataCache(eventType);
            cache.put(eventType, data);
        }

        return data;
    }

	public Set<String> getEventTypes() {
		return Collections.unmodifiableSet(cache.keySet());
	}

	public List<DataEvent> getEvents(String eventType, Calendar startTime, Calendar endTime) {
        DataCache data = getCache(eventType);
        data.fill(startTime.getTimeInMillis(), endTime.getTimeInMillis());
        return data.subList(startTime.getTimeInMillis(), endTime.getTimeInMillis());
    }

	public String getName() {
		return "Persistance mysql";
	}

	public boolean incomingEvent(DataEvent event) {
        DataCache data = getCache(event.getType());
        if (data.append(event)) {
			DBManager.getInstance().addDataEvent(event);
			return true;
		}
		return false;
	}

	public void initialize(Pipe pipe) {
		new Thread() {
			@Override
			public void run() {
				DBManager.getInstance().tryConnect();
				if (cache.isEmpty()) {
					try {
						for (String eventType: DBManager.getInstance().getEventTypes()) {
							cache.put(eventType, new DataCache(eventType));
						}
					} catch (SQLException ex) {
						Exceptions.printStackTrace(ex);
					}
				}
			}
		}.start();
	}

	public void cleanup() {
		cache.clear();
	}
}
