package dk.sdu.mmmi.intellihome.execution.impl.standard;

import dk.sdu.mmmi.intellihome.core.api.ConfigurationManager;
import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.decision.Decision;
import dk.sdu.mmmi.intellihome.decision.DecisionEvent;
import dk.sdu.mmmi.intellihome.hardware.Hardware;
import java.util.Timer;
import java.util.TimerTask;
import org.openide.util.Lookup;

/**
 *
 * @author jemr
 */
final class ExecutorScheduledActionManager extends AbstractExecuteActionManager {
	// <editor-fold defaultstate="collapsed" desc="Singleton code">
	private static final ExecutorScheduledActionManager instance = new ExecutorScheduledActionManager();

	public static ExecutorScheduledActionManager getInstance() {
		return instance;
	}

	private ExecutorScheduledActionManager() {
	}
	// </editor-fold>

	final ExecutorAction newAction(DecisionEvent event, DataEvent triggerEvent, EventHandler handler) {
		return add(new ExecutorScheduledAction(event.getEventType(), event.getDistance(), triggerEvent, handler));
	}

	// <editor-fold defaultstate="collapsed" desc="ExecutorCompletedAction code">
	static final class ExecutorScheduledAction implements ExecutorAction, ExecutorEventListener {
		private final String eventType;
		private final DataEvent triggerEvent;
		private final EventHandler handler;
		private final Timer timer = new Timer(true);
		private final TimerTask executeTask = new TimerTask() {
			@Override
			public void run() {
				cleanup();
				execute();
			}
		};

		private final TimerTask releaseTask = new TimerTask() {
			@Override
			public void run() {
				release();
			}
		};


		/**
		 * Private constructor, so all constructions go through the manager
		 *
		 * @param eventType The event type that has been scheduled
		 * @param time Time until the event should be executed (in milliseconds)
		 */
		private ExecutorScheduledAction(String eventType, long time, DataEvent triggerEvent, EventHandler handler) {
			System.out.printf("Scheduling %s in %d sec\n", eventType, time/1000);
			this.eventType = eventType;
			this.triggerEvent = triggerEvent;
			this.handler = handler;
			timer.schedule(executeTask, time);
			timer.schedule(releaseTask, time / 2);
			handler.addEventListener(triggerEvent.getCounterTypes(), this);
		}

		/**
		 * Execute the action
		 *
		 * TODO: Contact the hardware layer and do some stuff
		 */
		private void execute() {
			System.out.println("Executing " + this);
			// XXX TODO, fix with Config
			Hardware hardware = Lookup.getDefault().lookup(ConfigurationManager.class).getAPIImplementation(Hardware.class);
			if (hardware != null) {
				hardware.fireEvent(eventType, 0);
			}
		}

		private void release() {
			handler.removeEventListener(triggerEvent.getCounterTypes(), this);
			handler.getFilter().releaseEvent(triggerEvent);
		}

		public String getEventType() {
			return eventType;
		}

		/**
		 * Cancel the scheduled event
		 */
		public void cancelAction(DataEvent event) {
			handler.getFilter().removeWithheldEvent(event);
			handler.getFilter().removeWithheldEvent(triggerEvent);
			cleanup();
		}

		private void cleanup() {
			timer.cancel();
			ExecutorScheduledActionManager.getInstance().remove(this);
			handler.removeEventListener(triggerEvent.getCounterTypes(), this);
		}

		public void onEvent(DataEvent event) {
			// Counter event triggered
			// XXX TODO, Fix with Config
			cancelAction(event);
			handler.getFilter().removeWithheldEvent(event);
			Lookup.getDefault().lookup(Decision.class).negateEvent(this.triggerEvent, event);
		}
	}
	// </editor-fold>
}
