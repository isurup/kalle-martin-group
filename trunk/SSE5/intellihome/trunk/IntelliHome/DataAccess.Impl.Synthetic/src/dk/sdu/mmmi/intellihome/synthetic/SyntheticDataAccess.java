
package dk.sdu.mmmi.intellihome.synthetic;

import dk.sdu.mmmi.intellihome.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.dataaccess.DataSink;
import dk.sdu.mmmi.intellihome.dataaccess.DataSource;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openide.util.Lookup;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import org.openide.util.lookup.ProxyLookup;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
@ServiceProvider(service = DataSource.class)
public class SyntheticDataAccess implements DataSource {
	private Map<String, SyntheticDataSource> syntheticDataSources;
	private DataSink dataSink;

	private final InstanceContent content = new InstanceContent();
	private final Lookup lookup = new ProxyLookup(Lookup.getDefault(), new AbstractLookup(content));

	public SyntheticDataAccess() {
	}

	public final Lookup getLookup() {
		return lookup;
	}

	public void registerDataSource(SyntheticDataSource dataSource) {
		content.add(dataSource);
	}

	public Set<String> getEventTypes() {
		Set<String> devices = new HashSet<String>();
		for (SyntheticDataSource source: getLookup().lookupAll(SyntheticDataSource.class))
			devices.add(source.getEventType());
		return devices;
	}

	public List<DataEvent> getEvents(String eventType, Calendar startTime, Calendar endTime) {
		SyntheticDataSource syn = syntheticDataSources.get(eventType);
		if (syn == null)
			return Collections.emptyList();

		return syn.getEvents(startTime, endTime);
	}


	public void setDataSink(DataSink sink) {
		dataSink = sink;
	}

	public DataSink getDataSink() {
		return dataSink;
	}
}