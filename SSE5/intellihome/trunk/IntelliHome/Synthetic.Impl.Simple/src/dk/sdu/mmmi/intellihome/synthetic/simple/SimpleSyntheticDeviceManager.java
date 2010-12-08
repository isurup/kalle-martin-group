
package dk.sdu.mmmi.intellihome.synthetic.simple;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import org.openide.util.Exceptions;
import org.openide.util.NbPreferences;

/**
 *
 * @author jemr
 */
class SimpleSyntheticDeviceManager {

	private static final SimpleSyntheticDeviceManager instance = new SimpleSyntheticDeviceManager();
	public static SimpleSyntheticDeviceManager getInstance() {
		return instance;
	}

	private Preferences preferences = NbPreferences.forModule(SimpleSyntheticDeviceManager.class);
	private HashSet<SimpleSyntheticDataSource> dataSources = new HashSet<SimpleSyntheticDataSource>();
	private int nextDeviceId = 100;

	private SimpleSyntheticDeviceManager() {
		try {
			nextDeviceId = preferences.getInt("nextDeviceId", 100);
			for (String key : preferences.keys()) {
				if (key.startsWith("device")) {
					try {
						SimpleSyntheticDataSource dataSource = fromByteArray(preferences.getByteArray(key, null));
						if (dataSource != null)
							dataSources.add(dataSource);
					}
					catch (Exception e) {
						// deserialization failed, delete the config silently
						preferences.remove(key);
					}
				}
			}
		}
		catch (BackingStoreException ex) {
			Exceptions.printStackTrace(ex);
		}
	}

	void activateConfiguration(SimpleSyntheticDataSource dataSource) {
		dataSource.activate();
	}

	Collection<SimpleSyntheticDataSource> getConfigurations() {
		return Collections.unmodifiableSet(dataSources);
	}

	void addConfiguration(SimpleSyntheticDataSource dataSource) {
		byte []data = toByteArray(dataSource);
		preferences.putByteArray("device" + dataSource.getEventType(), data);
	}

	SimpleSyntheticDataSource newDataSource() {
		return new SimpleSyntheticDataSource(getNextId());
	}

	private int getNextId() {
		int next = nextDeviceId;
		nextDeviceId++;
		preferences.putInt("nextDeviceId", nextDeviceId);
		return next;
	}

	private byte[] toByteArray(SimpleSyntheticDataSource dataSource) {
		try {
			ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(byteArray);
			oos.writeObject(dataSource);
			oos.close();
			return byteArray.toByteArray();
		}
		catch (IOException ex) {
			Exceptions.printStackTrace(ex);
		}
		return null;
	}

	private SimpleSyntheticDataSource fromByteArray(byte[] data) throws Exception {
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		ObjectInputStream ois = new ObjectInputStream(bais);
		return (SimpleSyntheticDataSource)ois.readObject();
	}

	void resetConfiguration(SimpleSyntheticDataSource dataSource) {
		try {
			dataSources.remove(dataSource);
			dataSource = fromByteArray(preferences.getByteArray("device" + dataSource.getEventType(), null));
			if (dataSource != null)
				dataSources.add(dataSource);
		}
		catch (Exception ex) {
			// deserialization failed, delete config
			preferences.remove("device" + dataSource.getEventType());
		}
	}
}
