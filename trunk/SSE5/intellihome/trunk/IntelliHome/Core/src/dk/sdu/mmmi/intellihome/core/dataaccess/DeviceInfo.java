
package dk.sdu.mmmi.intellihome.core.dataaccess;

import java.io.Serializable;

/**
 *
 * @author jemr
 */
class DeviceInfo implements Comparable<DeviceInfo>, Serializable {
	private final int nodeId;
	private final int nodeSubId;
	private final String id;
	private final String type;
	private String name;
	private String scale;
	private String location;
	private String manufacturer;
	private String productUniqueId;

	public DeviceInfo(int nodeId, int nodeSubId, String name, String type, String scale, String location, String manufacturer, String productUniqueId) {
		this.nodeId = nodeId;
		this.nodeSubId = nodeSubId;
		this.name = name;
		this.type = type;
		this.scale = scale;
		this.location = location;
		this.manufacturer = manufacturer;
		this.productUniqueId = productUniqueId;

		id = (nodeSubId < 0) ? Integer.toString(nodeId) : String.format("%d_%d", nodeId, nodeSubId);
	}

	public final String getId() {
		return id;
	}

	/**
	 * @return the nodeId
	 */
	public final int getNodeId() {
		return nodeId;
	}

	/**
	 * @return the nodeSubId
	 */
	public final int getNodeSubId() {
		return nodeSubId;
	}

	public final String getType() {
		return type;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the scale
	 */
	public String getScale() {
		return scale;
	}

	/**
	 * @param scale the scale to set
	 */
	public void setScale(String scale) {
		this.scale = scale;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * @return the productUniqueId
	 */
	public String getProductUniqueId() {
		return productUniqueId;
	}

	/**
	 * @param productUniqueId the productUniqueId to set
	 */
	public void setProductUniqueId(String productUniqueId) {
		this.productUniqueId = productUniqueId;
	}

	@Override
	public int compareTo(DeviceInfo o) {
		return (nodeId == o.nodeId) ?
			nodeSubId - o.nodeSubId :
			nodeId - o.nodeId;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof DeviceInfo))
			return false;

		DeviceInfo d = (DeviceInfo)obj;

		return
			(d.nodeId == nodeId) && (d.nodeSubId == nodeSubId) &&
			(d.name == null ? name == null : d.name.equals(name)) &&
			(d.scale == null ? scale == null : d.scale.equals(scale)) &&
			(d.location == null ? location == null : d.location.equals(location)) &&
			(d.manufacturer == null ? manufacturer == null : d.manufacturer.equals(manufacturer)) &&
			(d.productUniqueId == null ? productUniqueId == null : d.productUniqueId.equals(productUniqueId));
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}


}
