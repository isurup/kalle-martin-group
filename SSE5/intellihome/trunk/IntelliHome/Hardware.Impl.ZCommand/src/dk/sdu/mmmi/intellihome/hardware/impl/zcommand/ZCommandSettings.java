
package dk.sdu.mmmi.intellihome.hardware.impl.zcommand;

import java.util.prefs.Preferences;
import org.openide.util.NbPreferences;

/**
 *
 * @author jemr
 */
public class ZCommandSettings {

    private static Preferences preferences = NbPreferences.forModule(ZCommandSettings.class);

    private static final String SETTING_HOST = "zcommand.host";
    private static final String SETTING_PORT = "zcommand.port";
    private static final String SETTING_USERNAME = "zcommand.username";
    private static final String SETTING_PASSWORD = "zcommand.password";

    public static final String getHost() {
        return preferences.get(SETTING_HOST, "localhost");
    }

    public static final void setHost(String host) {
        preferences.put(SETTING_HOST, host);
		ZCommandPoller.getInstance().reinit();
    }

    public static final int getPort() {
        return preferences.getInt(SETTING_PORT, 26262);
    }

    public static final void setPort(int port) {
        preferences.putInt(SETTING_PORT, port);
		ZCommandPoller.getInstance().reinit();
    }

    public static final String getUsername() {
        return preferences.get(SETTING_USERNAME, "Administrator");
    }

    public static final void setUsername(String username) {
        preferences.put(SETTING_USERNAME, username);
		ZCommandPoller.getInstance().reinit();
    }

    public static final String getPassword() {
        return preferences.get(SETTING_PASSWORD, "");
    }

    public static final void setPassword(String password) {
        preferences.put(SETTING_PASSWORD, password);
		ZCommandPoller.getInstance().reinit();
    }
}