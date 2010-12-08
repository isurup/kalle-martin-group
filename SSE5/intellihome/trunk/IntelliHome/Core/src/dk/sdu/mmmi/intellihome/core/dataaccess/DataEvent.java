
package dk.sdu.mmmi.intellihome.core.dataaccess;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jemr
 */
public interface DataEvent {
	public String getType();
	public long getTimeInMillis();
	public Calendar getTime();
	public double getValue();
	public DataGenerator getGenerator();
	public Map<String, Object> getMetaData();
	public int getDiscreteLevels();
	public List<String> getCounterTypes();
}
