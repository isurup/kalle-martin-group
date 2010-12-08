package dk.sdu.mmmi.intellihome.hardware.impl.zcommand;

import _1._0._0._127.Auth;
import _1._0._0._127.GetUser;
import _1._0._0._127.TxResult;
import com.zcommand.scheme.ZCommandWSZCommandWSSoap12;
import com.zcommand.scheme.ZCommandWSZCommandWSSoap12Stub;
import org.apache.axis2.AxisFault;

/**
 *
 * @author jemr
 */
public class ZCommandControl {
    public static enum TransmissionStatus {
        Fail(TxResult.Fail),
        Queued(TxResult.Queued),
        Success(TxResult.Success);

        private final TxResult txResult;
        private TransmissionStatus(TxResult txResult) {
            this.txResult = txResult;
        }

        public static TransmissionStatus valueOf(TxResult txResult) {
            for (TransmissionStatus status: values())
                if (status.txResult == txResult)
                    return status;
            return null;
        }
    }

    private final Auth auth;
    private final ZCommandWSZCommandWSSoap12Stub stub;

    public ZCommandControl(String endPointHost, int endPointPort, String username, String password) throws AxisFault {
        stub = new ZCommandWSZCommandWSSoap12Stub(String.format("http://%s:%d/ZCommand.asmx", endPointHost, endPointPort));
		System.out.println("Connecting to: " + stub._getServiceClient().getOptions().getTo().getAddress());
        stub._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.CHUNKED, Boolean.FALSE);

        auth = new Auth();
        auth.setUserName(username);
        auth.setPassword(password);
    }

    protected ZCommandWSZCommandWSSoap12 getStub() {
        return stub;
    }

    protected Auth getAuth() {
        return auth;
    }

	public synchronized boolean testConnection() {
		try {
			GetUser getUser = new GetUser();
			getUser.setAuth(getAuth());
			getUser.setUsername(getAuth().getUserName());
			return stub.getUser(getUser).getGetUserResult().getUsername().equals(getAuth().getUserName());
		}
		catch (Exception ex) {
			System.out.println("testConnection failed with: " + ex.getLocalizedMessage());
		}
		return false;
	}
}
