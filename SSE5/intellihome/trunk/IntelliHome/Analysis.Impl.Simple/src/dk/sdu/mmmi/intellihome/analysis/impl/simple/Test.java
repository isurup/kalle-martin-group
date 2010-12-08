
package dk.sdu.mmmi.intellihome.analysis.impl.simple;

import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author jemr
 */
public class Test {
/*
	public static void main(String[] args) {
		Analyzer analyzer = new Analyzer();
		//morningScenario(analyzer);
		testScenario(analyzer);

		analyzer.analyze();
	}
	private static void testScenario(Analyzer analyzer) {
		Random r = new Random();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2010);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.setLenient(true);
		for (int dayOfYear = 1; dayOfYear < 365*2; dayOfYear++) {
			cal.set(Calendar.YEAR, 2010);
			cal.set(Calendar.DAY_OF_YEAR, dayOfYear);
			cal.set(Calendar.HOUR_OF_DAY, 6);
			analyzer.addEvent(new AnalysisEvent("e1", cal.getTimeInMillis(), 1));
			cal.set(Calendar.HOUR_OF_DAY, 7);
			if (r.nextInt(10) < 3)
				analyzer.addEvent(new AnalysisEvent("e1", cal.getTimeInMillis(), 1));
			cal.set(Calendar.HOUR_OF_DAY, 8);
			analyzer.addEvent(new AnalysisEvent("e2", cal.getTimeInMillis(), 1));
			cal.set(Calendar.HOUR_OF_DAY, 9);
			if (r.nextInt(10) < 3)
				analyzer.addEvent(new AnalysisEvent("e2", cal.getTimeInMillis(), 1));
			cal.set(Calendar.HOUR_OF_DAY, 10);
			analyzer.addEvent(new AnalysisEvent("e3", cal.getTimeInMillis(), 1));
		}
	}

	private static void morningScenario(Analyzer analyzer) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2010);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		for (int dayOfYear = 1; dayOfYear < 366; dayOfYear++) {
			cal.set(Calendar.DAY_OF_YEAR, dayOfYear);
			// Morning
			cal.set(Calendar.HOUR_OF_DAY, 7);
			cal.set(Calendar.MINUTE, 2);
			analyzer.addEvent(new AnalysisEvent("bedOn", cal.getTimeInMillis(), 1));
			cal.set(Calendar.MINUTE, 8);
			analyzer.addEvent(new AnalysisEvent("ceilOn", cal.getTimeInMillis(), 1));
			cal.set(Calendar.MINUTE, 19);
			analyzer.addEvent(new AnalysisEvent("bedOff", cal.getTimeInMillis(), 0));
			cal.set(Calendar.MINUTE, 47);
			analyzer.addEvent(new AnalysisEvent("ceilOff", cal.getTimeInMillis(), 0));
			// Evening
			cal.set(Calendar.HOUR_OF_DAY, 22);
			cal.set(Calendar.MINUTE, 46);
			analyzer.addEvent(new AnalysisEvent("ceilOn", cal.getTimeInMillis(), 1));
			cal.set(Calendar.MINUTE, 47);
			analyzer.addEvent(new AnalysisEvent("bedOn", cal.getTimeInMillis(), 1));
			cal.set(Calendar.MINUTE, 54);
			analyzer.addEvent(new AnalysisEvent("ceilOff", cal.getTimeInMillis(), 0));
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 9);
			analyzer.addEvent(new AnalysisEvent("bedOff", cal.getTimeInMillis(), 0));
		}
	}
*/
}
