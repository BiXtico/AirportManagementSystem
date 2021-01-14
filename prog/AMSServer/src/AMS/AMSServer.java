
package AMS;

import AMS.ResevationSubSystem.BillingAccount;
import AMS.ResevationSubSystem.Booking;
import AMS.ResevationSubSystem.Passenger;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class AMSServer {

    public static void main(String[] args) throws RemoteException {
        DB_SC_Manager DBSC = new DB_SC_Manager();
        DBSC.RegisterPassenger();
        Booking b1 = new Booking(1,2);
        Booking b2 = new Booking(10,20);
        Booking b3 = new Booking(11,22);
        ArrayList<Booking> bb = new ArrayList();
        bb.add(b1);
        bb.add(b2);
        bb.add(b3);

        BillingAccount b = new BillingAccount();
        Passenger p = new Passenger(176437,21,8787657,"bix","onBoard","bix176437@gmail.com","Egyptian",b,bb);
    }
}
    