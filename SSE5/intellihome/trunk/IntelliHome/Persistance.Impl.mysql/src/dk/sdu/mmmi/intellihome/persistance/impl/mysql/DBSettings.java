
package dk.sdu.mmmi.intellihome.persistance.impl.mysql;

import java.util.prefs.Preferences;
import org.openide.util.NbPreferences;

/**
 *
 * @author jemr
 */
public class DBSettings {
    private static Preferences preferences = NbPreferences.forModule(DBSettings.class);

    private static final String SETTING_DRIVER = "db.driver";
    private static final String SETTING_PROVIDER = "db.provider";
    private static final String SETTING_HOST = "db.host";
    private static final String SETTING_PORT = "db.port";
    private static final String SETTING_SCHEME = "db.scheme";
    private static final String SETTING_USERNAME = "db.username";
    private static final String SETTING_PASSWORD = "db.password";

    public static String getDriver() {
        return preferences.get(SETTING_DRIVER, "com.mysql.jdbc.Driver");
    }

    public static void setDriver(String driver) {
        preferences.put(SETTING_DRIVER, driver);
    }

    public static String getProvider() {
        return preferences.get(SETTING_PROVIDER, "mysql");
    }

    public static void setProvider(String provider) {
        preferences.put(SETTING_PROVIDER, provider);
    }

    public static String getHost() {
        return preferences.get(SETTING_HOST, "localhost");
    }

    public static void setHost(String host) {
        preferences.put(SETTING_HOST, host);
    }

    public static int getPort() {
        return preferences.getInt(SETTING_PORT, 3306);
    }

    public static void setPort(int port) {
        preferences.putInt(SETTING_PORT, port);
    }

    public static String getScheme() {
        return preferences.get(SETTING_SCHEME, "intellihouse");
    }

    public static void setScheme(String scheme) {
        preferences.put(SETTING_SCHEME, scheme);
    }

    public static String getUsername() {
        return preferences.get(SETTING_USERNAME, "anonymous");
    }

    public static void setUsername(String username) {
        preferences.put(SETTING_USERNAME, username);
    }

    public static String getPassword() {
        return preferences.get(SETTING_PASSWORD, "");
    }

    public static void setPassword(String password) {
        preferences.put(SETTING_PASSWORD, password);
    }
}