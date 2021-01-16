package AMS;

import AMS.FlightManagementSubSystem.ManagementEmployee;
import AMS.FlightManagementSubSystem.Pilot;
import AMS.Interfaces.SystemManagerInterface;
import AMS.PlaneManagementSubSystem.Gate;
import AMS.PlaneManagementSubSystem.Plane;
import AMS.ResevationSubSystem.BillingAccount;
import AMS.ResevationSubSystem.Passenger;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SystemManager implements SystemManagerInterface, Serializable {

    public SystemManager() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public void createAccountPassengers(int age, int SSN, String username, String email, String nationality) throws RemoteException {
        Passenger pass = new Passenger(age, SSN, username, email, nationality);
        DB_SC_Manager.getPassengers_S().add(pass);
    }

    @Override
    public void createAccountEmployees(int age, int SSN, String username, String email, float salary) throws RemoteException {
        ManagementEmployee me = new ManagementEmployee(age, SSN, username, email, salary);
        DB_SC_Manager.getManagmentEmployees_S().add(me);
    }

    @Override
    public void refundPayment(int AccountID, double balance) throws RemoteException {
        for (BillingAccount i : DB_SC_Manager.getBilligAccounts_S()) {
            if (AccountID == i.getAccountID()) {
                i.addBalance(balance);
            }
        }
    }

    @Override
    public Gate assignPassengerGate() throws RemoteException {
        for (Gate i : DB_SC_Manager.getGates_S()) {
            if (i.isIsAvailable() == true) {
                return i;
            }
        }
        return null;
    }

    @Override
    public Plane assignPlane() throws RemoteException {

        for (Plane i : DB_SC_Manager.getPlanes_S()) {
            if (i.getSlot().isIsAvailable() == true) {
                return i;
            }
        }
        return null;
    }

    @Override
    public Pilot assignFlightStaff() throws RemoteException {
        for (Pilot i : DB_SC_Manager.getPilots_S()) {
            if (i.isIsAvailable() == true) {
                return i;
            }
        }
        return null;
    }
}
