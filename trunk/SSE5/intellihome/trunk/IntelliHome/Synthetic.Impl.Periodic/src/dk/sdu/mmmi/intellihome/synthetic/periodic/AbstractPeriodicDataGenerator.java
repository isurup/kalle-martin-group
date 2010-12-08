package dk.sdu.mmmi.intellihome.synthetic.periodic;

import dk.sdu.mmmi.intellihome.synthetic.simple.DataGenerator;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JComponent;

/**
 *
 * @author jemr
 */
public abstract class AbstractPeriodicDataGenerator implements DataGenerator {
	private long offset = 0;

	private long upPeriod = 3600000;

	private long downPeriod = 3600000;

	private int upRepeat = 1;
	private double upOffset = 0.0;
	private double upAmplitude = 1.0;
	private double upModifier = 1.0;

	private int downRepeat = 1;
	private double downOffset = 0.0;
	private double downAmplitude = 1.0;
	private double downModifier = 1.0;

	private boolean multiply = false;

	private transient PeriodicDataGeneratorConfigPanel configControl;

	/**
	 * Generates the unmodified data for the specified distance into the period
	 * Acceptable results range from -1.0 to +1.0
	 * @param x The distance into the current period
	 * @param isUp specifies if it's the up or down period
	 * @return A value between -1.0 and 1.0
	 */
	protected abstract double generatePeriodData(double x, boolean isUp);


	public double getData(long timest, double prevValue) {
		long upPeriodLength = getUpPeriod() * getUpRepeat();
		long downPeriodLength = getDownPeriod() * getDownRepeat();
		long periodLength = upPeriodLength + downPeriodLength;

		if (periodLength <= 0)
			return prevValue;

		while (timest < getOffset())
			timest += periodLength;
		
		long x = (timest - getOffset()) % (periodLength);

		double mult = isMultiply() ? prevValue : 1;
		double add = isMultiply() ? 0 : prevValue;

		return add + mult * ((x < upPeriodLength) ?
			getUpOffset() + getUpAmplitude() * Math.pow(generatePeriodData(x % getUpPeriod(), true), getUpModifier()) :
			getDownOffset() - getDownAmplitude() * Math.pow(generatePeriodData((x - upPeriodLength) % getDownPeriod(), false), getDownModifier()));
	}

	public boolean terminate() {
		return false;
	}

	protected synchronized PeriodicDataGeneratorConfigPanel getConfigurationPanel() {
		if (configControl == null)
			configControl = new PeriodicDataGeneratorConfigPanel(this);
		return configControl;
	}

	public JComponent getConfigurationControls() {
		return getConfigurationPanel();
	}

	/* ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** */
	//                   <editor-fold desc="GETTERS AND SETTERS">
	/* ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** */
	protected long getOffset() {
		return offset;
	}

	protected void setOffset(long offset) {
		this.offset = offset;
	}

	protected long getUpPeriod() {
		return upPeriod;
	}

	protected void setUpPeriod(long upPeriod) {
		this.upPeriod = upPeriod;
	}

	protected double getUpOffset() {
		return upOffset;
	}

	protected void setUpOffset(double upOffset) {
		this.upOffset = upOffset;
	}

	protected double getUpModifier() {
		return upModifier;
	}

	protected void setUpModifier(double upModifier) {
		this.upModifier = upModifier;
	}

	protected double getUpAmplitude() {
		return upAmplitude;
	}

	protected void setUpAmplitude(double upAmpliture) {
		this.upAmplitude = upAmpliture;
	}

	protected long getDownPeriod() {
		return downPeriod;
	}

	protected void setDownPeriod(long downPeriod) {
		this.downPeriod = downPeriod;
	}

	protected double getDownOffset() {
		return downOffset;
	}

	protected void setDownOffset(double downOffset) {
		this.downOffset = downOffset;
	}

	protected double getDownModifier() {
		return downModifier;
	}

	protected void setDownModifier(double downModifier) {
		this.downModifier = downModifier;
	}

	protected double getDownAmplitude() {
		return downAmplitude;
	}

	protected void setDownAmplitude(double downAmplitude) {
		this.downAmplitude = downAmplitude;
	}

	protected boolean isMultiply() {
		return multiply;
	}

	protected void setMultiply(boolean multiply) {
		this.multiply = multiply;
	}

	protected int getUpRepeat() {
		return upRepeat;
	}

	protected void setUpRepeat(int upRepeat) {
		this.upRepeat = Math.max(1, upRepeat);
	}

	protected int getDownRepeat() {
		return downRepeat;
	}

	protected void setDownRepeat(int downRepeat) {
		this.downRepeat = Math.max(1, downRepeat);
	}
	// </editor-fold>
}
