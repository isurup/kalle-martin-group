
package dk.sdu.mmmi.intellihome.core.api;

/**
 *
 * @author jemr
 */
public interface ConfigurationManager {
	public <T extends API> T getAPIImplementation(Class<T> clazz);
}
