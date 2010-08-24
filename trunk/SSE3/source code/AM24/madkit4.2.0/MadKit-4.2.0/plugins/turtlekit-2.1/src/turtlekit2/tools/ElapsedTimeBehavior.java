/*
 * A simple behavior that notifies a listener when
 * the configured number of milliseconds has past.
 */
package turtlekit2.tools;
import java.util.Enumeration;

import javax.media.j3d.Behavior;
import javax.media.j3d.WakeupCondition;
import javax.media.j3d.WakeupCriterion;
import javax.media.j3d.WakeupOnElapsedTime;
import javax.media.j3d.WakeupOr;

public class ElapsedTimeBehavior extends Behavior {
	private WakeupCondition wakeupCondition = null;
	private IElapsedTimeListener listener;

	public ElapsedTimeBehavior(
		IElapsedTimeListener listener,
		int milliseconds) {
		this.listener = listener;
		WakeupCriterion[] wakeupArray = new WakeupCriterion[1];
		wakeupArray[0] = new WakeupOnElapsedTime(milliseconds);
		wakeupCondition = new WakeupOr(wakeupArray);
	}

	public void initialize() {
		wakeupOn(wakeupCondition);
	}

	@SuppressWarnings("unchecked")
	public void processStimulus(Enumeration criteria) {
		@SuppressWarnings("unused")
		WakeupOnElapsedTime event;
		WakeupCriterion criterion;
		while (criteria.hasMoreElements()) {
			criterion = (WakeupCriterion) criteria.nextElement();
			if (criterion instanceof WakeupOnElapsedTime) {
				event = (WakeupOnElapsedTime) criterion;
				listener.tick();
			}
		}
		wakeupOn(wakeupCondition);
	}

}
