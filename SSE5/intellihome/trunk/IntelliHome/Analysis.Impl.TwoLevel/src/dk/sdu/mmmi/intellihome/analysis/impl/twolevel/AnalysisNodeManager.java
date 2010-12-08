
package dk.sdu.mmmi.intellihome.analysis.impl.twolevel;

import dk.sdu.mmmi.intellihome.analysis.AnalysisEvent;
import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author jemr
 */
class AnalysisNodeManager {
	private static final int ANALYSIS_DEPTH = 2;
	private static final long MAX_DISTANCE = 10 * 60 * 1000L;

	static boolean isTimedOut(DataEvent currentEvent, DataEvent previousEvent) {
		return (currentEvent.getTimeInMillis() - previousEvent.getTimeInMillis()) > MAX_DISTANCE;
	}

	static boolean isSameEventType(DataEvent event1, DataEvent event2) {
		return event1.getType().equals(event2.getType());
	}

	private class AnalysisWindowTuple {
		private final AnalysisNode node;
		private final DataEvent event;
		private final Set<String> followUpEventTypes = new HashSet<String>();

		public AnalysisWindowTuple(AnalysisNode node, DataEvent event) {
			this.node = node;
			this.event = event;
		}
		
		boolean isTimedOut(DataEvent event) {
			return AnalysisNodeManager.isTimedOut(event, this.event);
		}

		boolean isSameEventType(DataEvent event) {
			return AnalysisNodeManager.isSameEventType(this.event, event);
		}

		long getEventTime() {
			return event.getTimeInMillis();
		}

		boolean addFollowUp(DataEvent event) {
			if (isTimedOut(event) || isSameEventType(event) || followUpEventTypes.contains(event.getType()))
				return false;

			followUpEventTypes.add(event.getType());
			node.add(event, metaDataManager.getMetaDataForEvent(event), event.getTimeInMillis() - getEventTime());
			return true;
		}

		@Override
		public String toString() {
			return String.format("Tuple{%s}", node.toString());
		}


	}

	private final AnalysisMetaDataManager metaDataManager = new AnalysisMetaDataManager();
	// hashmap, key is "[eventType];[eventType];..."
	// for one level: "#;[eventType];"
	private final HashMap<String, AnalysisNode> nodes = new HashMap<String, AnalysisNode>();

	AnalysisNodeManager() {
	}

	boolean isEmpty() {
		return nodes.isEmpty();
	}

	void reset() {
		nodes.clear();
	}

	// the list is created over a fixed size array, to make sure the
	// list is also fixed sized. A list is used so getNode() can be used
	// this means operations that would change the size of the List cannot
	// be used (such as add, remove, clear) also checks like isEmpty are
	// meaningless (in this case, check if last element is null instead).
	private Map<AnalysisNode, AnalysisWindowTuple> tuples = new HashMap<AnalysisNode, AnalysisWindowTuple>();
	private LinkedList<DataEvent> eventWindow = new LinkedList<DataEvent>();

	void incomingEvent(DataEvent event) {
		System.out.println("[2Lvl] incomingEvent: " + event);
		metaDataManager.incomingEvent(event);
		if (event.getDiscreteLevels() == 0)
			return;
		
		// This will ONLY work for depth==2 !
		List<DataEvent> windowKey = Arrays.asList((new DataEvent[2]));
		windowKey.set(1, event);
		boolean found = false;
		for (Iterator<DataEvent> it = eventWindow.descendingIterator(); it.hasNext(); ) {
			DataEvent windowEvent = it.next();
			if (isTimedOut(event, windowEvent)) {
				it.remove();
				continue;
			}

			if (!found && isSameEventType(windowEvent, event))
				found = true;
			
			if (!found) {
				windowKey.set(0, windowEvent);
				AnalysisNode node = getNode(windowKey, true);
				tuples.put(node, new AnalysisWindowTuple(node, event));
			}
		}
		
		windowKey.set(0, null);
		AnalysisNode node = getNode(windowKey, true);
		tuples.put(node, new AnalysisWindowTuple(node, event));

		eventWindow.add(event);

		for (Iterator<Map.Entry<AnalysisNode, AnalysisWindowTuple>> it = tuples.entrySet().iterator(); it.hasNext(); ) {
			AnalysisWindowTuple tuple = it.next().getValue();
			if (tuple.isTimedOut(event)) {
				it.remove();
			}
			else {
				tuple.addFollowUp(event);
			}
		}
	}

	Set<AnalysisEvent> getCandidates(List<DataEvent> data) {
		System.out.println("[2Lvl] getCandidates: " + data);
		if (data.isEmpty())
			return Collections.emptySet();

		AnalysisNode node = getNode(data, false);
		if (node == null)
			return Collections.emptySet();

		Set<AnalysisEvent> result = node.getCandidates(metaDataManager.getMetaDataForEvent(data.get(data.size() - 1)));
		return result;

	}

	private AnalysisNode getNode(List<DataEvent> data, boolean create) {
		String nodeKey = "";
		for (int index = data.size() - ANALYSIS_DEPTH; index < data.size(); index++) {
			if (index < 0)
				nodeKey += "#;";
			else {
				DataEvent event = data.get(index);
				nodeKey += (event == null ? "#" : event.getType()) + ";";
			}
		}
		AnalysisNode node = nodes.get(nodeKey);
		if (node == null && create) {
			node = new AnalysisNode(nodeKey);
			nodes.put(nodeKey, node);
		}
		return node;
	}
}
