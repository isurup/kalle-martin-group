
package dk.sdu.mmmi.intellihome.analysis;

import dk.sdu.mmmi.intellihome.core.api.API;
import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import java.util.List;
import java.util.Set;

/**
 *
 * @author jemr
 */
public interface Analysis extends API {
	public Set<AnalysisEvent> performAnalysis(List<DataEvent> data);
}
