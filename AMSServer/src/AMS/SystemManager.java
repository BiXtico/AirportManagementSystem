
package AMS;

import AMS.Interfaces.SystemManagerInterface;
import AMS.ResevationSubSystem.Passenger;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class SystemManager implements SystemManagerInterface {

    public SystemManager() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
       public void createAccount() throws RemoteException{
      
    
      
       }
    @Override
    public void createBillingAccount() throws RemoteException {
    
    }
    @Override
    public void refundPayment() throws RemoteException {
    
    }
    @Override
    public void assignPassengerGate() throws RemoteException {
    
    }
    @Override 
    public void assignPlane() throws RemoteException {
    
    } 
    @Override 
    public void assignFlightStaff() throws RemoteException {
    
    }  

}
