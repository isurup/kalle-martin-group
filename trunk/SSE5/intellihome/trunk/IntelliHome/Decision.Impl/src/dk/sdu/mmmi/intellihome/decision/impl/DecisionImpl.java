package dk.sdu.mmmi.intellihome.decision.impl;

import dk.sdu.mmmi.intellihome.analysis.Analysis;
import dk.sdu.mmmi.intellihome.analysis.AnalysisEvent;
import dk.sdu.mmmi.intellihome.core.api.ConfigurationManager;
import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.decision.Decision;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
@ServiceProvider(service = Decision.class)
public class DecisionImpl extends Decision {

	private final List<DecisionPath> decisionPaths = new ArrayList<DecisionPath>();

	@Override
	public synchronized boolean confirmEvent(DataEvent event) {

		for (Iterator<DecisionPath> it = decisionPaths.iterator(); it.hasNext(); )
			if (it.next().isTimedOut())
				it.remove();

		boolean confirmed = false;

		// XXX TODO XXX:
		// Udvid med check på distance og probability
		// for at vælge det rigtige path
		//
		// Lav 3 modeller, alt efetr hvor mange paths event er expected i
		// 1 path: simpelt, vælg det path (hvis det er inden for tidshorizonten)
		// 2 paths: se om begge passer med tidshorizont
		//          check om en/begge er scheduled
		//          check sandsynlighed hvis xor scheduled
		// 3+ paths: blah blah
		for (DecisionPath path: decisionPaths) {
			if (path.isExpected(event)) {
				path.confirmEvent(event);
				schedulePath(path);
				confirmed = true;
			}
		}

		if (confirmed)
			return true;

		DecisionPath path = new DecisionPath(this, event);
		decisionPaths.add(path);
		return schedulePath(path);
	}

	private boolean schedulePath(DecisionPath path) {
		if (circularCheck(path)) {
			System.out.println("[#####] Circular path found: " + path);
			return false;
		}

		Analysis analysis = Lookup.getDefault().lookup(ConfigurationManager.class).getAPIImplementation(Analysis.class);

		if (analysis == null)
			return false;

		Set<AnalysisEvent> analysisEvents = analysis.performAnalysis(path.getParents());
		System.out.println(analysisEvents);
		path.setLeaves(convertToDecisionEvents(analysisEvents));

		if (!analysisEvents.isEmpty()) {
			return findEventToSchedule(path);
		}
		return false;
	}

	@Override
	public synchronized void negateEvent(DataEvent event, DataEvent negatedBy) {
		for (Iterator<DecisionPath> it = decisionPaths.iterator(); it.hasNext(); ) {
			if (it.next().negateEvent(event, negatedBy))
				it.remove();
		}
	}

	private Set<DecisionEventImpl> convertToDecisionEvents(Set<AnalysisEvent> analysisEvents) {
		Set<DecisionEventImpl> result = new HashSet<DecisionEventImpl>();
		for (AnalysisEvent ev: analysisEvents)
			result.add(new DecisionEventImpl(ev));
		return result;
	}

	private boolean findEventToSchedule(DecisionPath path) {
		ArrayList<DecisionEventImpl> list = new ArrayList<DecisionEventImpl>(path.getLeaves());
		Collections.sort(list, new Comparator<DecisionEventImpl>() {
			@Override
			public int compare(DecisionEventImpl o1, DecisionEventImpl o2) {
				// Divide probability into 10% blocks, but scew by 5%, so 95-100 are in the same
				int p1 = (int)Math.floor(10.0 * (o1.getAnalysisEvent().getProbability() + 0.05));
				int p2 = (int)Math.floor(10.0 * (o2.getAnalysisEvent().getProbability() + 0.05));

				if (p1 == p2) {
					if (o1.getDistance() < o2.getDistance())
						return -1;
					else if (o1.getDistance() == o2.getDistance())
						return 0;
					else
						return 1;
				}
				else if (p1 > p2)
					return -1;
				else
					return 1;
			}
		});
		if (list.isEmpty())
			return false;
		DecisionEventImpl max = list.get(0);

		// Don't schedule unless you have atleast 65% probability
		if (max.getAnalysisEvent().getProbability() < 0.65)
			return false;
		
		path.scheduleEvent(max);
		fireScheduleEvent(max, path.getLatest().getParent());
		return true;
	}

	void cancelEvent(DecisionEventImpl event, DataEvent triggerEvent) {
		fireCancelEvent(event, triggerEvent);
	}

	private boolean circularCheck(DecisionPath path) {
		List<DataEvent> events = path.getParents();
		if (events.size() < 4)
			return false;
		String topType = events.get(events.size() - 1).getType();

		int len = events.size();
		for (int i = len - 2; i > len / 3; i--) {
			if (events.get(i).getType().equals(topType)) {
				int start = 2 * (i + 1) - len;
				if (start < 0)
					return false;

 				List<DataEvent> topList = events.subList(i + 1, len);
				List<DataEvent> bottomList = events.subList(start, i + 1);
				if (compareList(topList, bottomList))
					return true;
			}
		}
		return false;
	}

	private boolean compareList(List<DataEvent> topList, List<DataEvent> bottomList) {
		System.out.println("Comparing: " + topList);
		System.out.println("Comparing: " + bottomList);
		if (topList.size() != bottomList.size()) {
			System.out.println("Size mismatch!");
			return false;
		}
		for (int i = 0; i < topList.size(); i++)
			if (!topList.get(i).getType().equals(bottomList.get(i).getType()))
				return false;
		return true;
	}
}
