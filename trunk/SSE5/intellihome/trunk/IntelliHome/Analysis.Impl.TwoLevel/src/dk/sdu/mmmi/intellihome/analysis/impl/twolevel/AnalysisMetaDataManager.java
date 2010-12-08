
package dk.sdu.mmmi.intellihome.analysis.impl.twolevel;

import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author jemr
 */
class AnalysisMetaDataManager {
	private final ArrayList<AnalysisMetaData> metaData = new ArrayList<AnalysisMetaData>();
	private static final AnalysisMetaData EMPTY_METADATA = new AnalysisMetaData(null, null);
	private AnalysisMetaData currentMetaData = EMPTY_METADATA;

	void incomingEvent(DataEvent event) {
		// keep updating the currentMetaData object with meta data information
		// until a non-metadata event happens, at which time the current
		// MetaData object is pushed on to the list to support search
		if (event.getDiscreteLevels() == 0)
			currentMetaData = new AnalysisMetaData(currentMetaData, event);
		else
			metaData.add(currentMetaData);
	}
	
	AnalysisMetaData getMetaDataForEvent(DataEvent event) {
		if (metaData.isEmpty())
			return EMPTY_METADATA;

		if (event.getTimeInMillis() >= currentMetaData.getTimeInMillis())
			return currentMetaData;

		int index = Collections.binarySearch(metaData, new AnalysisMetaData(null, event), new Comparator<AnalysisMetaData>() {
			@Override
			public int compare(AnalysisMetaData o1, AnalysisMetaData o2) {
				long o1time = o1.getTimeInMillis();
				long o2time = o2.getTimeInMillis();
				return (o1time < o2time ? -1 : (o1time == o2time ? 0 : 1));
			}
		});

		index = index < 0 ? ~index : index;
		if (index >= metaData.size())
			index = metaData.size() - 1;

		return metaData.get(index);
	}

	AnalysisMetaData getCurrentMetaData() {
		return currentMetaData;
	}
}
