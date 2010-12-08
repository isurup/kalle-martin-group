
package dk.sdu.mmmi.intellihome.analysis.impl.twolevel;

import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author jemr
 */
class AnalysisMetaData {
	private final HashMap<String, Double> data = new HashMap<String, Double>();
	private final long timestamp;

	AnalysisMetaData(AnalysisMetaData previousMetaData, DataEvent event) {
		if (previousMetaData != null)
			data.putAll(previousMetaData.data);
		if (event != null) {
			data.put(event.getType(), event.getValue());
			timestamp = event.getTimeInMillis();
		}
		else
			timestamp = 0;
	}

	long getTimeInMillis() {
		return timestamp;
	}

	Double getValue(String eventType) {
		return data.get(eventType);
	}

	Set<String> getMetaDataTypes() {
		return Collections.unmodifiableSet(data.keySet());
	}
}
