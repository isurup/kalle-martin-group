
package dk.sdu.mmmi.intellihome.synthetic.climate;

import dk.sdu.mmmi.intellihome.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.synthetic.SyntheticDataSource;
import dk.sdu.mmmi.intellihome.synthetic.SyntheticDataEventFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import org.openide.util.Exceptions;

/**
 *
 * @author jemr
 */
public abstract class ClimateDataSource implements SyntheticDataSource {

	private final String table;
	private final long offset;
	private final int climateId;

	public ClimateDataSource(int climateId, String table, long offset) {
		this.table = table;
		this.offset = offset;
		this.climateId = climateId;
	}

	public String getEventType() {
		return Integer.toString(climateId);
	}

	private List<DataEvent> cache;
	private long cacheStart;
	private long cacheEnd;

	public List<DataEvent> getEvents(Calendar start, Calendar end) {
		if (cacheStart != start.getTimeInMillis() || cacheEnd != end.getTimeInMillis()) {
			cache = readData(table, getEventType(), start.getTimeInMillis(), end.getTimeInMillis(), offset);
			cacheStart = start.getTimeInMillis();
			cacheEnd = end.getTimeInMillis();
		}
		return cache;
	}

	private static Connection conn;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://jira.softwarelab.sdu.dk/climate_hawaii", "intellihome", "T!tDB4tIH");
		}
		catch (SQLException ex) {
			Exceptions.printStackTrace(ex);
		}
		catch (ClassNotFoundException ex) {
			Exceptions.printStackTrace(ex);
		}
	}

	private static List<DataEvent> readData(String table, String eventType, long start, long end, long offset) {
		try {
			List<DataEvent> list = new ArrayList<DataEvent>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + table +" WHERE timest >= ? AND timest <= ? ORDER BY timest");
			stmt.setLong(1, start + offset);
			stmt.setLong(2, end + offset);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				list.add(SyntheticDataEventFactory.getInstance().newEvent(eventType, result.getLong("timest") - offset, result.getDouble("value")));
			}
			result.close();
			stmt.close();
			return list;
		}
		catch (SQLException ex) {
			Exceptions.printStackTrace(ex);
		}

		return Collections.emptyList();
	}
}