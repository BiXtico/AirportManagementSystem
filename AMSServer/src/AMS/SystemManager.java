
package AMS;

import AMS.Interfaces.SystemManagerInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class SystemManager implements SystemManagerInterface {

    public SystemManager() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public int add(int x, int y) throws RemoteException {
        return x + y;
    }

    @Override
    public int sub(int x, int y) throws RemoteException {
        return x - y;
    }

}
