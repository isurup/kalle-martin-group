
package dk.sdu.mmmi.intellihome.visualization.impl.standard;

import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.core.pipe.Pipe;
import dk.sdu.mmmi.intellihome.visualization.Visualization;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
@ServiceProvider(service=Visualization.class)
public class VisualizationStandard implements Visualization {


	public String getName() {
		return "Visualization Standard";
	}

	public boolean incomingEvent(DataEvent event) {
		System.out.println(event + " -- added");
		DeviceListTopComponent.getDefault().addEventType(event.getType());
		GraphAreaTopComponent.getDefault().update(event);
		return true;
	}

	public void initialize(Pipe pipe) {
		GraphAreaTopComponent.getDefault().resetGraphs();
		DeviceListTopComponent.getDefault().setPipe(pipe);
		DeviceListTopComponent.getDefault().setEventTypes(pipe.getEventTypes());
	}

	public void cleanup() {
		GraphAreaTopComponent.getDefault().resetGraphs();
	}
}
