
package dk.sdu.mmmi.intellihome.visualization.impl.standard.graphs;

import dk.sdu.mmmi.intellihome.core.pipe.Pipe;

/**
 *
 * @author jemr
 */
public interface GraphFactory {
	public AbstractGraph newInstance(String eventType, Pipe pipe);
	public String getName();
}
