package dk.sdu.mmmi.intellihome.hardware.impl.zcommand;

import _1._0._0._127.AddAssociation;
import _1._0._0._127.GetDevice;
import _1._0._0._127.GetDevices2;
import _1._0._0._127.GetLog;
import _1._0._0._127.GetName;
import _1._0._0._127.QueryDevice;
import _1._0._0._127.SetDeviceLevel;
import _1._0._0._127.TxResult;
import _1._0._0._127.ZwaveDevice;
import java.rmi.RemoteException;
import org.apache.axis2.AxisFault;
import org.apache.axis2.databinding.types.UnsignedByte;

/**
 *
 * @author jemr
 */
public class ZCommandControlDevices extends ZCommandControl {

    public ZCommandControlDevices(String endPointHost, int endPointPort, String username, String password) throws AxisFault {
        super(endPointHost, endPointPort, username, password);
    }

    public synchronized ZwaveDevice[] getDevices() throws RemoteException {
        return getDevices("", "");
    }

    public synchronized ZwaveDevice[] getDevices(String locationFilter, String nameFilter) throws RemoteException {
        GetDevices2 getDevices = new GetDevices2();
        getDevices.setAuth(getAuth());
        getDevices.setLocationFilter(locationFilter);
        getDevices.setNameFilter(nameFilter);

        try {
            ZwaveDevice[] res = getStub().getDevices2(getDevices).getGetDevices2Result().getZwaveDevice();

            // If no devices are found, return an empty array instead of null
            if (res == null)
                res = new ZwaveDevice[0];
            return res;
        }
        catch (NullPointerException e) {
            return new ZwaveDevice[0];
        }
    }

    public synchronized ZwaveDevice getDevice(String nodeId) throws RemoteException {
        GetDevice getDevice = new GetDevice();
        getDevice.setAuth(getAuth());
        getDevice.setNodeID(nodeId);
        getDevice.setLastTransmissionStatus(TxResult.Success);
        return getStub().getDevice(getDevice).getGetDeviceResult();
    }

    public synchronized TransmissionStatus setDeviceLevel(String nodeId, int level) throws RemoteException {
        SetDeviceLevel deviceLevel = new SetDeviceLevel();
        deviceLevel.setAuth(getAuth());
        deviceLevel.setNodeID(nodeId);
        deviceLevel.setLevel(new UnsignedByte(level));
        return TransmissionStatus.valueOf(getStub().setDeviceLevel(deviceLevel).getSetDeviceLevelResult());
    }

    public synchronized String getDeviceName(String nodeId) throws RemoteException {
        GetName getName = new GetName();
        getName.setAuth(getAuth());
        getName.setNodeID(nodeId);
        return getStub().getName(getName).getGetNameResult();
    }

    public synchronized TransmissionStatus queryDevice(String nodeId) throws RemoteException {
        QueryDevice queryDevice = new QueryDevice();
        queryDevice.setAuth(getAuth());
        queryDevice.setNodeID(nodeId);
        return TransmissionStatus.valueOf(getStub().queryDevice(queryDevice).getQueryDeviceResult());
    }

    public synchronized TransmissionStatus addAssociation(int nodeId, int groupId, int nodeIdToAssociate) throws RemoteException {
        AddAssociation addAssociation = new AddAssociation();
        addAssociation.setAuth(getAuth());
        addAssociation.setNodeID(new UnsignedByte(nodeId));
        addAssociation.setGroupID(new UnsignedByte(groupId));
        addAssociation.setNodeIDToAssociate(new UnsignedByte(nodeIdToAssociate));
        return TransmissionStatus.valueOf(getStub().addAssociation(addAssociation).getAddAssociationResult());
    }

    public synchronized String[] getLog() throws RemoteException {
        GetLog getLog = new GetLog();
        getLog.setAuth(getAuth());
        return getStub().getLog(getLog).getGetLogResult().getString();
    }
}
