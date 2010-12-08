package dk.sdu.mmmi.intellihome.core.dataaccess;

/**
 *
 * @author jemr
 */
class DataPoint {
    public final long timestamp;
    public final double value;

    public DataPoint(long timest, double value) {
        this.timestamp = timest;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("DataPoint[%d => %.2f]", timestamp, value);
    }
}
