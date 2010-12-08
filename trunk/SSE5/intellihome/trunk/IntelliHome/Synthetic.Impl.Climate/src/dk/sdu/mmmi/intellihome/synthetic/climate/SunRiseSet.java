
package dk.sdu.mmmi.intellihome.synthetic.climate;

import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;

/**
 * Module, to calculate sunrise and sunset<br />
 * Based on code from <a href="http://www.srrb.noaa.gov/highlights/sunrise/sunrise.html"> http://www.srrb.noaa.gov/highlights/sunrise/sunrise.html</a>
 * @author  jemr
 */
public class SunRiseSet
{
	/**
	 * @author  jemr
	 */
	public class Data
	{
		private Calendar sunRise;
		private Calendar sunSet;

		/**
		 * Constructor
		 * @param sunRise Time of sunrise
		 * @param sunSet Time of sunset
		 */
		public Data(Calendar sunRise, Calendar sunSet)
		{
			this.sunRise = sunRise;
			this.sunSet = sunSet;
		}

		/**
		 * Retrieves the time of sunset
		 * @return  the time of sunset
		 */
		public Calendar getSunRise()
		{
			return sunRise;
		}

		/**
		 * Retrieves the time of sunrise
		 * @return  The time of sunrise
		 */
		public Calendar getSunSet()
		{
			return sunSet;
		}
	}


	private static SunRiseSet instance = new SunRiseSet();

	/**
	 * Retrieves the Singleton instance
	 * @return  Returns the Singleton instance
	 */
	public static SunRiseSet getInstance() {
		return instance;
	}


	private final HashMap<String, SunRiseSet.Data> cache = new HashMap<String, SunRiseSet.Data>();

	// default: Årslev
	private double latitude = 55.305439;
	private double longitude = -10.448384;

	/**
	 * Private constructor for the Singleton
	 */
	private SunRiseSet() {
	}

	/**
	 * Calculates the sunrise and sunset for the specified date
	 * @param date The date, in miliseconds since epocs GMT, to calculate the sunrise and sunset for
	 * @return The sunrise and sunset times, for the specified date
	 */
	public SunRiseSet.Data getSunRiseSet(long date)
	{
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(date);
		return getSunRiseSet(c);
	}

	/**
	 * Calculates the sunrise and sunset for the specified date
	 * @param date The date, to calculate the sunrise and sunset for
	 * @return The sunrise and sunset times, for the specified date
	 */
	public SunRiseSet.Data getSunRiseSet(Calendar date)
	{
		return getSunRiseSet(date, latitude, longitude);
	}

	/**
	 * Calculates the sunrise and sunset for the specified date
	 * @param date The date to calculate the sunrise and sunset for
	 * @param latitude The latitude of the location (degrees)
	 * @param longitude The longitude of the location (degrees)
	 * @return The sunrise and sunset times, for the specified date and coordinates
	 */
	public SunRiseSet.Data getSunRiseSet(Calendar date, double latitude, double longitude)
	{
		String str = String.format("%2d-%2d-%4d-%s-%.6f-%.6f",
			date.get(Calendar.DAY_OF_MONTH), date.get(Calendar.MONTH)+1, date.get(Calendar.YEAR),
			date.getTimeZone().getID(), latitude, longitude);

		if (cache.containsKey(str))
			return cache.get(str);

		synchronized(cache)
		{
			if (!cache.containsKey(str))
				cache.put(str, calcSunRiseSet(date, latitude, longitude));

			return cache.get(str);
		}
	}

	/**
	 * Calculates the sunrise and sunset for the specified date
	 * @param date The date to calculate the sunrise and sunset for
	 * @param latitude The latitude of the location (degrees)
	 * @param longitude The longitude of the location (degrees)
	 * @return The sunrise and sunset times, for the specified date and coordinates
	 */

	private SunRiseSet.Data calcSunRiseSet(Calendar date, double latitude, double longitude)
	{
		int JD = calcJulianDate(date);
		TimeZone tz = date.getTimeZone();
		double riseOffsetGMT = calcSunriseUTC(JD, latitude, longitude);
		double setOffsetGMT = calcSunsetUTC(JD, latitude, longitude);

		Calendar riseTime = (Calendar)date.clone();
		Calendar setTime = (Calendar)date.clone();

		if (Double.isNaN(riseOffsetGMT))
		{
			riseTime.set(Calendar.HOUR_OF_DAY, 0);
			riseTime.set(Calendar.MINUTE, 0);
			riseTime.set(Calendar.SECOND, 0);
		}
		else
		{
			riseTime.setTimeZone(TimeZone.getTimeZone("GMT"));
			riseTime.set(Calendar.HOUR_OF_DAY, 0);
			riseTime.set(Calendar.MINUTE, 0);
			riseTime.set(Calendar.SECOND, 0);
			riseTime.add(Calendar.MINUTE, (int)Math.round(riseOffsetGMT));
			riseTime.setTimeZone(tz);
		}

		if (Double.isNaN(setOffsetGMT))
		{
			setTime.set(Calendar.HOUR_OF_DAY, 24);
			setTime.set(Calendar.MINUTE, 0);
			setTime.set(Calendar.SECOND, 0);
		}
		else
		{
			setTime.setTimeZone(TimeZone.getTimeZone("GMT"));
			setTime.set(Calendar.HOUR_OF_DAY, 0);
			setTime.set(Calendar.MINUTE, 0);
			setTime.set(Calendar.SECOND, 0);
			setTime.add(Calendar.MINUTE, (int)Math.round(setOffsetGMT));
			setTime.setTimeZone(tz);
		}

		return new SunRiseSet.Data(riseTime, setTime);
	}

	/**
	 * Calculates the Julian Date from a normal (Gregorian Calendar) date
	 * @param date Gregorian Calendar date
	 * @return Julian Date
	 */
	private int calcJulianDate(Calendar date)
	{
		int year = date.get(Calendar.YEAR);
		int month = date.get(Calendar.MONTH) + 1;
		int day = date.get(Calendar.DAY_OF_MONTH);

		int a = (int)Math.floor((14 - month) / 12);
		int y = year + 4800 - a;
		int m = month + 12 * a - 3;

		return day + (int)Math.floor((153 * m + 2) /  5) + (365 * y) + (int)Math.floor(y / 4) - (int)Math.floor(y / 100) + (int)Math.floor(y / 400) - 32045;
	}

	/**
	 * Converts a Julian date to centuries since J2000.0
	 * @param jd The Julian date to convert
	 * @return Centuries since J2000.0, corresponding to the specified Julian Date
	 */
	private double calcJulianCentFromJulianDate(double jd)
	{
		return (jd - 2451545.0) / 36525.0;
	}

	/**
	 * Converts centuries since J2000.0 to Julian Day.
	 * @param t Number of centuries since J2000.0
	 * @return The Julian Date converted from the specified number of centuries since J2000.0
	 */
	private double calcJulianDateFromJulianCent(double t)
	{
		return t * 36525.0 + 2451545.0;
	}

	/**
	 * Calculates the geometric mean longitude of the sun
	 * @param t Number of centuries since J2000.0
	 * @return the geometric mean longitude of the sun (degrees)
	 */
	private double calcGeometricMeanLongitudeSun(double t)
	{
		double geom = 280.46646 + t * (36000.76983 + 0.0003032 * t);
		while(geom > 360.0) geom -= 360.0;
		while(geom < 0.0) geom += 360.0;
		return geom;
	}

	/**
	 * calculated the geometric mean anomaly of the sun
	 * @param t Centuries since J2000.0
	 * @return The calculated geometric mean anomaly (degrees)
	 */
	private double calcGeometricMeanAnomalySun(double t)
	{
		return 357.52911 + t * (35999.05029 - 0.0001537 * t);
	}

	/**
	 * Calculates the eccentricity of Earth's orbit
	 * @param t Centuries since J2000.0
	 * @return The eccentricity of Earth's orbit
	 */
	private double calcEccentricityEarthOrbit(double t)
	{
		return 0.016708634 - t * (0.000042037 + 0.0000001267 * t);
	}

	/**
	 * Calculates the equation of center of the sun
	 * @param t Centuries since J2000.0
	 * @return the equation of center of the sun (degrees)
	 */
	private double calcSunEqOfCenter(double t)
	{
		double m = calcGeometricMeanAnomalySun(t);

		double mrad = Math.toRadians(m);
		double sinm = Math.sin(mrad);
		double sin2m = Math.sin(mrad * 2.0);
		double sin3m = Math.sin(mrad * 3.0);

		return sinm * (1.914602 - t * (0.004817 + 0.000014 * t)) +
		       sin2m * (0.019993 - 0.000101 * t) +
		       sin3m * 0.000289;
	}

	/**
	 * Calculates the true longitude of the sun
	 * @param t Centuries since J2000.0
	 * @return The sun's true longitude (degree)
	 */
	private double calcSunTrueLong(double t)
	{
		return calcGeometricMeanLongitudeSun(t) + calcSunEqOfCenter(t);
	}

	/**
	 * Calculates the true anomaly of the sun
	 * @param t Centuries since J2000.0
	 * @return The true anomoly of the sun (degrees)
	 */
	private double calcSunTrueAnomaly(double t)
	{
		double m = calcGeometricMeanAnomalySun(t);
		double c = calcSunEqOfCenter(t);

		return m + c; // in degrees
	}

	/**
	 * calculates the distance to the sun in AU
	 * @param t Centuries since J2000.0
	 * @return The distance to the sun (AU)
	 */
	private double calcSunRadVector(double t)
	{
		double v = Math.cos(Math.toRadians(calcSunTrueAnomaly(t)));
		double e = calcEccentricityEarthOrbit(t);

		return (1.000001018 * (1 - e * e)) / (1 + e * v);
	}

	/**
	 * Calculates the apparent longitude of the sun
	 * @param t Centuries since J2000.0
	 * @return the sun's apparent longitude (degrees)
	 */
	private double calcSunApparentLong(double t)
	{
		double o = calcSunTrueLong(t);

		double omega = 125.04 - 1934.136 * t;
		return o - 0.00569 - 0.00478 * Math.sin(Math.toRadians(omega));
	}

	/**
	 * Calculates the mean obliquity of the ecliptic
	 * @param t Centuries since J2000.0
	 * @return The mean obliquity (degrees)
	 */
	private double calcMeanObliquityOfEcliptic(double t)
	{
		double seconds = 21.448 - t * (46.8150 + t * (0.00059 - t * (0.001813)));
		return 23.0 + (26.0 + (seconds / 60.0)) / 60.0;
	}

	/**
	 * calculates the corrected obliquity of the ecliptic
	 * @param t Centuries since J2000.0
	 * @return The corrected obliquity (degrees)
	 */
	private double calcObliquityCorrection(double t)
	{
		double e0 = calcMeanObliquityOfEcliptic(t);

		double omega = 125.04 - 1934.136 * t;
		return e0 + 0.00256 * Math.cos(Math.toRadians(omega));
	}

	/**
	 * Calculates the right ascension of the sun
	 * @param t Centuries since J2000.0
	 * @return the sun's right ascension (degrees)
	 */
	private double calcSunRtAscension(double t)
	{
		double e = Math.toRadians(calcObliquityCorrection(t));
		double lambda = Math.toRadians(calcSunApparentLong(t));

		double tananum = (Math.cos(e) * Math.sin(lambda));
		double tanadenom = (Math.cos(lambda));
		return Math.toDegrees(Math.atan2(tananum, tanadenom));
	}

	/**
	 * Calculates the declination of the sun
	 * @param t Centuries since J2000.0
	 * @return The sun's declination (degrees)
	 */
	private double calcSunDeclination(double t)
	{
		double e = Math.toRadians(calcObliquityCorrection(t));
		double lambda = Math.toRadians(calcSunApparentLong(t));

		double sint = Math.sin(e) * Math.sin(lambda);
		return Math.toDegrees(Math.asin(sint));
	}

	/**
	 * Calculates the difference between true solar time and the mean solar time
	 * @param t Centuries since J2000.0
	 * @return Equiation of time (minutes)
	 */
	private double calcEquationOfTime(double t)
	{
		double epsilon = calcObliquityCorrection(t);
		double l0 = calcGeometricMeanLongitudeSun(t);
		double e = calcEccentricityEarthOrbit(t);
		double m = calcGeometricMeanAnomalySun(t);

		double y = Math.tan(Math.toRadians(epsilon)/2.0);
		y *= y;

		double sin2l0 = Math.sin(2.0 * Math.toRadians(l0));
		double sinm   = Math.sin(Math.toRadians(m));
		double cos2l0 = Math.cos(2.0 * Math.toRadians(l0));
		double sin4l0 = Math.sin(4.0 * Math.toRadians(l0));
		double sin2m  = Math.sin(2.0 * Math.toRadians(m));

		double Etime = y * sin2l0 - 2.0 * e * sinm + 4.0 * e * y * sinm * cos2l0
				- 0.5 * y * y * sin4l0 - 1.25 * e * e * sin2m;

		return Math.toDegrees(Etime)*4.0;	// in minutes of time
	}

	/**
	 * Calculates the hour angle of the sun at sunrise, for the specified latitude
	 * @param lat Latitude (degrees)
	 * @param solarDec Declination angle of the sun (degrees)
	 * @return The hour angle of the sun (radians)
	 */
	private double calcHourAngleSunrise(double lat, double solarDec)
	{
		double latRad = Math.toRadians(lat);
		double sdRad  = Math.toRadians(solarDec);

		return (Math.acos(Math.cos(Math.toRadians(90.833)) / (Math.cos(latRad) * Math.cos(sdRad)) - Math.tan(latRad) * Math.tan(sdRad)));
	}

	/**
	 * Calculates the hour angle of the sun at sunset for the latitude.
	 * @param lat Latitude (degrees)
	 * @param solarDec Declination angle of the sun (degrees)
	 * @return Hour angle of sunset (radians)
	 */
	private double calcHourAngleSunset(double lat, double solarDec)
	{
		return -calcHourAngleSunrise(lat, solarDec);
	}

	/**
	 * calculates the UTC time for sunrise for the given day at the given location
	 * @param JD Julian Date
	 * @param latitude Latitude (degrees)
	 * @param longitude Longitude (degrees)
	 * @return Time offset from UTC midnight for sunrise (minutes)
	 */
	private double calcSunriseUTC(int JD, double latitude, double longitude)
	{
		double t = calcJulianCentFromJulianDate(JD);

		// *** Find the time of solar noon at the location, and use
        //     that declination. This is better than start of the
        //     Julian day

		double noonmin = calcSolNoonUTC(t, longitude);
		double tnoon = calcJulianCentFromJulianDate (JD+noonmin/1440.0);

		// *** First pass to approximate sunrise (using solar noon)

		double eqTime = calcEquationOfTime(tnoon);
		double solarDec = calcSunDeclination(tnoon);
		double hourAngle = calcHourAngleSunrise(latitude, solarDec);

		double delta = longitude - Math.toDegrees(hourAngle);
		double timeDiff = 4 * delta;	// in minutes of time
		double timeUTC = 720 + timeDiff - eqTime;	// in minutes

		// *** Second pass includes fractional jday in gamma calc

		double newt = calcJulianCentFromJulianDate(calcJulianDateFromJulianCent(t) + timeUTC/1440.0);
		eqTime = calcEquationOfTime(newt);
		solarDec = calcSunDeclination(newt);
		hourAngle = calcHourAngleSunrise(latitude, solarDec);
		delta = longitude - Math.toDegrees(hourAngle);
		timeDiff = 4 * delta;
		timeUTC = 720 + timeDiff - eqTime; // in minutes

		return timeUTC;
	}

	/**
	 * Calculates the UTC time of solar noon for the given day, at the given location
	 * @param t Centuries since J2000.0
	 * @param longitude Longitude (degrees)
	 * @return Time offset from UTC midnight for solar noon (minutes)
	 */
	private double calcSolNoonUTC(double t, double longitude)
	{
		// First pass uses approximate solar noon to calculate eqtime
		double tnoon = calcJulianCentFromJulianDate(calcJulianDateFromJulianCent(t) + longitude/360.0);
		double eqTime = calcEquationOfTime(tnoon);
		double solNoonUTC = 720 + (longitude * 4) - eqTime; // min

		double newt = calcJulianCentFromJulianDate(calcJulianDateFromJulianCent(t) -0.5 + solNoonUTC/1440.0);

		eqTime = calcEquationOfTime(newt);
		// var solarNoonDec = calcSunDeclination(newt);
		solNoonUTC = 720 + (longitude * 4) - eqTime; // min

		return solNoonUTC;
	}

	/**
	 * Calculates the UTC time for sunset for the given day at the given location
	 * @param JD Julian Date
	 * @param latitude Latitude (degrees)
	 * @param longitude Longitude (degrees)
	 * @return Time offset from UTC midnight for sunset (minutes)
	 */
	private double calcSunsetUTC(int JD, double latitude, double longitude)
	{
		double t = calcJulianCentFromJulianDate(JD);

		// *** Find the time of solar noon at the location, and use
        //     that declination. This is better than start of the
        //     Julian day

		double noonmin = calcSolNoonUTC(t, longitude);
		double tnoon = calcJulianCentFromJulianDate (JD+noonmin/1440.0);

		// First calculates sunrise and approx length of day

		double eqTime = calcEquationOfTime(tnoon);
		double solarDec = calcSunDeclination(tnoon);
		double hourAngle = calcHourAngleSunset(latitude, solarDec);

		double delta = longitude - Math.toDegrees(hourAngle);
		double timeDiff = 4 * delta;
		double timeUTC = 720 + timeDiff - eqTime;

		// first pass used to include fractional day in gamma calc

		double newt = calcJulianCentFromJulianDate(calcJulianDateFromJulianCent(t) + timeUTC/1440.0);
		eqTime = calcEquationOfTime(newt);
		solarDec = calcSunDeclination(newt);
		hourAngle = calcHourAngleSunset(latitude, solarDec);

		delta = longitude - Math.toDegrees(hourAngle);
		timeDiff = 4 * delta;
		timeUTC = 720 + timeDiff - eqTime; // in minutes

		return timeUTC;
	}

}