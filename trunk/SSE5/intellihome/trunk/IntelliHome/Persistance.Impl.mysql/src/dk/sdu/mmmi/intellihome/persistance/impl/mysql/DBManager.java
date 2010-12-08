
package dk.sdu.mmmi.intellihome.persistance.impl.mysql;

import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.persistance.impl.mysql.gui.DBSettingsDialog;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openide.util.Exceptions;

/**
 *
 * @author jemr
 */
public final class DBManager {
    private static final DBManager instance = new DBManager();

    public static DBManager getInstance() {
        return instance;
    }

    private Connection connection;
	private HashMap<String, Integer> eventTypes = new HashMap<String, Integer>();

    private DBManager() {
        try {
            Class.forName(DBSettings.getDriver());
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed())
            connection.close();
    }

    private void connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            String url = String.format("jdbc:%s://%s:%s/%s",
                DBSettings.getProvider(),
                DBSettings.getHost(),
                DBSettings.getPort(),
                DBSettings.getScheme());
            connection = DriverManager.getConnection(url, DBSettings.getUsername(), DBSettings.getPassword());
			readEventTypes();
        }
    }

    ResultSet getData(String eventType, long start, long end) throws SQLException {
        connect();
        PreparedStatement statement = connection.prepareStatement(
                "SELECT timestamp, value " +
                "FROM log2 " +
                "WHERE eventType = ? AND timestamp >= ? AND timestamp <= ? " +
                "ORDER BY timestamp ASC",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        statement.setString(1, eventType);
        statement.setLong(2, start);
        statement.setLong(3, end);
        return statement.executeQuery();
    }

    Collection<String> getEventTypes() throws SQLException {
        connect();
		return Collections.unmodifiableCollection(eventTypes.keySet());
    }

	private void readEventTypes() {
		try {
			ResultSet result = connection.createStatement().executeQuery("SELECT eventType, discreteLevel FROM eventTypes2");
			HashMap<String, Integer> types = new HashMap<String, Integer>();
			while (result.next())
				types.put(result.getString(1), result.getInt(2));
			result.close();
			eventTypes = types;
		}
		catch (SQLException ex) {
			Exceptions.printStackTrace(ex);
		}
	}

	void addDataEvent(DataEvent event) {
		try {
			connect();
			if (!eventTypes.containsKey(event.getType())) {
				PreparedStatement statement = connection.prepareStatement("INSERT INTO eventTypes2 (eventType, discreteLevel) VALUES (?, ?)");
				statement.setString(1, event.getType());
				statement.setInt(2, event.getDiscreteLevels());
				statement.execute();
				statement.close();
				eventTypes.put(event.getType(), event.getDiscreteLevels());
			}

			PreparedStatement statement = connection.prepareStatement("INSERT INTO log2 (eventType, timestamp, value) VALUES (?, ?, ?)");
			statement.setString(1, event.getType());
			statement.setLong(2, event.getTimeInMillis());
			statement.setDouble(3, event.getValue());
			statement.execute();
			statement.close();
		}
		catch (SQLException ex) {
			Exceptions.printStackTrace(ex);
		}
	}

	void tryConnect() {
		try {
			connect();
		}
		catch (SQLException ex) {
			DBSettingsDialog.showDialog("Error connecting to the mysql database, please validate the connection parameters", "Connection error");
		}
	}
}

