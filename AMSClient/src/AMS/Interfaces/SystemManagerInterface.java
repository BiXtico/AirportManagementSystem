
package AMS.Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface SystemManagerInterface extends Remote{
    
    public void createAccount() throws RemoteException ;
    public void createBillingAccount() throws RemoteException ;
    public void refundPayment() throws RemoteException ;
    public void assignPassengerGate() throws RemoteException ;
    public void assignPlane() throws RemoteException ; 
    public void assignFlightStaff() throws RemoteException ;  
}
