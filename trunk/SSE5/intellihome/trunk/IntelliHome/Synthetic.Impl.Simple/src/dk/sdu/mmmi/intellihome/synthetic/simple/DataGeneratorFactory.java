
package dk.sdu.mmmi.intellihome.synthetic.simple;

/**
 *
 * @author jemr
 */
public interface DataGeneratorFactory {
	public DataGenerator newInstance();
	public String getName();
}
