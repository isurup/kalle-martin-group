
package dk.sdu.mmmi.intellihome.persistance.impl.mysql;

import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jemr
 */
class DataCache {
    private static final Comparator<DataEvent> searchComparator = new Comparator<DataEvent>() {
        public int compare(DataEvent o1, DataEvent o2) {
			long val1 = o1.getTimeInMillis();
			long val2 = o2.getTimeInMillis();
            return val1 < val2 ? -1 : (val1 == val2 ? 0 : 1);
        }
    };

    private final String eventType;
    private long start = Long.MAX_VALUE;
    private long end = Long.MIN_VALUE;

    private List<DataEvent> cache = new ArrayList<DataEvent>();

    DataCache(String eventType) {
        this.eventType = eventType;
    }

    synchronized List<DataEvent> subList(long startTime, long endTime) {
        int startIndex = Collections.binarySearch(cache, DBDataEventFactory.getInstance().newEvent(eventType, startTime, 0), searchComparator);
        int endIndex = Collections.binarySearch(cache, DBDataEventFactory.getInstance().newEvent(eventType, endTime, 0), searchComparator);

        // If value is negative, means no precise match was found and the insertion point was returned inverse
        if (startIndex < 0) startIndex = ~startIndex;
        if (endIndex < 0) endIndex = ~endIndex;

        return Collections.unmodifiableList(cache.subList(startIndex, endIndex));
    }

    synchronized void fill(long startTime, long endTime) {
        if (startTime < start || endTime > end) {
            try {
                ResultSet result = DBManager.getInstance().getData(eventType, Math.min(startTime, start), Math.max(endTime, end));
                // Create a new cache object instead of clearing the old, to not destroy subLists currently in use
                result.last();
                cache = new ArrayList<DataEvent>((int)Math.ceil(result.getRow() * 1.25));
                result.beforeFirst();
                while (result.next()) {
                    long timestamp = result.getLong(1);
                    double value = result.getDouble(2);
                    cache.add(DBDataEventFactory.getInstance().newEvent(eventType, timestamp, value));
                }
                result.getStatement().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataCache.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Append an event to the cache, if the event being added is newer
     * than the newest in the cache
     * @param event The DataEvent to add
     * @return True if the event was added, false otherwise
     */
    synchronized boolean append(DataEvent event) {
        if (cache.isEmpty() || cache.get(cache.size() - 1).getTimeInMillis() < event.getTimeInMillis()) {
            cache.add(event);
            return true;
        }
        return false;
    }

}
