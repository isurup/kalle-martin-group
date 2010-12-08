
package dk.sdu.mmmi.intellihome.synthetic.simple;

import dk.sdu.mmmi.intellihome.synthetic.SyntheticDataEventFactory;
import dk.sdu.mmmi.intellihome.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.dataaccess.DataSink;
import dk.sdu.mmmi.intellihome.dataaccess.DataSource;
import dk.sdu.mmmi.intellihome.synthetic.SyntheticDataAccess;
import dk.sdu.mmmi.intellihome.synthetic.SyntheticDataSource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.openide.util.Lookup;

/**
 *
 * @author jemr
 */
class SimpleSyntheticDataSource implements SyntheticDataSource, DataSource, Serializable {

	private ArrayList<DataGenerator> generators = new ArrayList<DataGenerator>();
	private final String eventType;
	private transient DataSink sink;
	private transient boolean active = false;
	private long resolution = 5000;

	public SimpleSyntheticDataSource(int eventType) {
		 this.eventType = Integer.toString(eventType);
	}

	public void addDataGenerator(DataGenerator generator) {
		generators.add(generator);
	}

	public boolean removeDataGenerator(DataGenerator generator) {
		return generators.remove(generator);
	}

	public boolean removeDataGenerator(int index) {
		return generators.remove(index) != null;
	}

	public List<DataGenerator> getDataGenerators() {
		return Collections.unmodifiableList(generators);
	}

	public List<DataEvent> getEvents(String eventType, Calendar startTime, Calendar endTime) {
		return getEvents(startTime, endTime);
	}

	public List<DataEvent> getEvents(Calendar startTime, Calendar endTime) {
		// since we'll be looping over this a LOT, copy to an array to eliminate iterator overhead
		final DataGenerator[] genArray = generators.toArray(new DataGenerator [generators.size()]);
		final int generatorCount = genArray.length;
		final long timeResolution = getResolution();

		final ArrayList<DataEvent> result = new ArrayList<DataEvent>((int)((endTime.getTimeInMillis() - startTime.getTimeInMillis()) / timeResolution));

		for (long timeStamp = startTime.getTimeInMillis(); timeStamp < endTime.getTimeInMillis(); timeStamp += timeResolution) {
			double value = 0;
			for (int i = 0; i < generatorCount; i++) {
				final DataGenerator generator = genArray[i];

				value = generator.getData(timeStamp, value);
				if (generator.terminate() || Double.isNaN(value))
					break; // breaks inner for-loop
			}

			if (!Double.isNaN(value))
				result.add(SyntheticDataEventFactory.getInstance().newEvent(eventType, timeStamp, value));
		}

		return result;
	}

	public Set<String> getEventTypes() {
		return Collections.singleton(eventType);
	}

	public String getEventType() {
		return eventType;
	}


	public void setDataSink(DataSink sink) {
		this.sink = sink;
	}

	public DataSink getDataSink() {
		return sink;
	}

	public long getResolution() {
		return resolution;
	}

	public void setResolution(long resolution) {
		this.resolution = resolution;
	}

	public boolean isActive() {
		return active;
	}

	public void activate() {
		if (!isActive()) {
			active = true;
			Lookup.getDefault().lookup(SyntheticDataAccess.class).registerDataSource(this);
		}
	}
}
