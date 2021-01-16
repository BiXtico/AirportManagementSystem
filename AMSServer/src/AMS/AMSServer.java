package AMS;

import AMS.ResevationSubSystem.BillingAccount;
import AMS.ResevationSubSystem.Booking;
import AMS.ResevationSubSystem.Passenger;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class AMSServer {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        DB_SC_Manager DBSC = new DB_SC_Manager();
        DB_SC_Manager.readPassengers();
        BillingAccount bbb = new BillingAccount();
        bbb.setAccountID(14);
        bbb.setBalance(1414);
        DBSC.RegisterPassenger();
        
        //DB_SC_Manager.UpdatePassengers();
        Booking b1 = new Booking(1, 2, "2021");
        Booking b2 = new Booking(10, 20, "2021");
        Booking b3 = new Booking(11, 22, "2021");
        ArrayList<Booking> bb = new ArrayList();
        bb.add(b1);
        bb.add(b2);
        bb.add(b3);

        BillingAccount b = new BillingAccount();
       
    }
}
