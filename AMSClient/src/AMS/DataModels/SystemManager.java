
package AMS.DataModels;


import java.io.Serializable;
import java.rmi.RemoteException;


public class SystemManager implements Serializable   {

    public SystemManager() throws RemoteException {
        
    }

    public int add(int x, int y) throws RemoteException {
        return x + y;
    }

    public int sub(int x, int y) throws RemoteException {
        return x - y;
    }

}
