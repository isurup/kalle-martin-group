
package dk.sdu.mmmi.intellihome.synthetic.climate.datasources;

import dk.sdu.mmmi.intellihome.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.synthetic.SyntheticDataEventFactory;
import dk.sdu.mmmi.intellihome.synthetic.SyntheticDataSource;
import dk.sdu.mmmi.intellihome.synthetic.climate.SunRiseSet;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.lookup.ServiceProvider;


/**
 *
 * @author jemr
 */

@ServiceProvider(service = SyntheticDataSource.class)
public class SunRiseSetDataSource implements SyntheticDataSource {

	public static final long INTERVAL = 10 * 30 * 1000; // 30 sec


	public SunRiseSetDataSource() {
	}
	public String getEventType() {
		return "SunRiseSet";
	}

	public List<DataEvent> getEvents(Calendar start, Calendar end) {
		// Round to nearest INTERVAL
		List<DataEvent> result = new ArrayList<DataEvent>();
		long t = (long)Math.floor(start.getTimeInMillis() / INTERVAL) * INTERVAL;
		long endT = (long)(1L + Math.ceil(end.getTimeInMillis() / INTERVAL)) * INTERVAL;
		while (t <= endT) {
			SunRiseSet.Data data = SunRiseSet.getInstance().getSunRiseSet(t);
			long rise = data.getSunRise().getTimeInMillis();
			long set = data.getSunSet().getTimeInMillis();
			double factor = Math.pow(Math.sin(data.getSunRise().get(Calendar.DAY_OF_YEAR)/366.0 * Math.PI), 1.5) * 1000.0 + 400;

			if (t < rise || t > set)
				result.add(SyntheticDataEventFactory.getInstance().newEvent(getEventType(), t, 0.0));
			else
				result.add(SyntheticDataEventFactory.getInstance().newEvent(getEventType(), t, factor * Math.pow(Math.sin(((1.0 * t - rise) / (1.0 * set - rise)) * Math.PI), 2.5)));

			t += INTERVAL;
		}

		return result;
	}
}