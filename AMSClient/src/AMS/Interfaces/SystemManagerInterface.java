
package AMS.Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface SystemManagerInterface extends Remote{
    
    //example code
    public int add(int x, int y) throws RemoteException;
    //example code
    public int sub(int x, int y) throws RemoteException ;
}
