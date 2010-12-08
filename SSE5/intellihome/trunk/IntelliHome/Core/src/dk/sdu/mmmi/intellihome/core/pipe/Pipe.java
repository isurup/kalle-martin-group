
package dk.sdu.mmmi.intellihome.core.pipe;

import dk.sdu.mmmi.intellihome.core.api.API;
import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.openide.util.Lookup;

/**
 *
 * @author jemr
 */
public abstract class Pipe<E extends API> {
	private E apiImplementation;
	private Pipe source;
	private Pipe sink;

	public abstract Class<E> getAPI();
	public abstract String getName();
	public final Collection<? extends API> getAPIImplementations() {
		return Lookup.getDefault().lookupAll(getAPI());
	}

	public final void setAPIImplementation(E api) {
		E old = getAPIImplementation();
		if (old != null) {
			try {
				old.cleanup();
			}
			catch (Exception e) {
				// ignore exceptions from cleanup
			}
		}

		apiImplementation = api;

		if (api != null) {
			try {
				api.initialize(this);
			}
			catch (Exception e) {
				// ignore exceptions from initialize
			}
		}
	}

	public final E getAPIImplementation() {
		return apiImplementation;
	}

    public final void setSource(Pipe newSource) {
		if (newSource == null && sink != null)
			sink.setSink(null);
		source = newSource;
		if (newSource != null)
			newSource.setSink(this);
	}
	
    public final Pipe getSource() {
		return source;
	}

    private void setSink(Pipe sink) {
		this.sink = sink;
	}
    public final Pipe getSink() {
		return sink;
	}

    public final void incomingEvent(DataEvent event) {
		API api = getAPIImplementation();
		if (api != null) {
			if (!api.incomingEvent(event))
				return;
		}
		if (sink != null)
			sink.incomingEvent(event);
	}

    public List<DataEvent> getEvents(String eventType, Calendar startTime, Calendar endTime) {
		return source != null ? source.getEvents(eventType, startTime, endTime) : Collections.<DataEvent>emptyList();
	}

	public Set<String> getEventTypes() {
		return source != null ? source.getEventTypes() : Collections.<String>emptySet();
	}
}
