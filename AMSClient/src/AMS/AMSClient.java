
package AMS;

import AMS.Controllers.PassengerController;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;



public class AMSClient {
    
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        PassengerController ss = new PassengerController();
        ss.LookupPassenger("bix", 8787657);
        System.out.println(ss.getCurrentP().getNationality());
    }
    
}
