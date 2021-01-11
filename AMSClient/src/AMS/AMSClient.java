
package AMS;

import AMS.Interfaces.SystemManagerInterface;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class AMSClient {
    
    public static void main(String[] args) {
        // test your controller functions here and response
        //don't forget to remove your tests at the end so it doesn't cause conflict when we merge
         try {
            Registry registry = LocateRegistry.getRegistry(1099);  
            SystemManagerInterface sm = (SystemManagerInterface) registry.lookup("ss");

            System.out.println("The new result is " + sm.add(5, 3));
        } catch (NotBoundException | RemoteException ex) {
            System.out.println("Exception occured, Error Client side try connection failed, can't read registery binds");
        }
    }
    
}
