package AMS;

import AMS.FlightManagementSubSystem.ManagementEmployee;
import AMS.Interfaces.AdminInterface;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Admin extends User implements AdminInterface, Serializable {

    private static Admin instance;

    private Admin() throws RemoteException {
        //Private Constructor
        UnicastRemoteObject.exportObject(this, 0);
    }

    public static Admin getInstance() throws RemoteException {
        if (instance == null) {
            //synchronized block to remove overhead 
            synchronized (Admin.class) {
                if (instance == null) {
                    // if instance is null, initialize 
                    instance = new Admin();
                }
            }
        }
        return instance;
    }

    @Override
    public String getLoginInUsername() {
        return this.getUsername();
    }

    @Override
    public int getLoginInSSN() {
        return this.getSSN();
    }

    @Override
    public String getLoginInEmail() {
        return this.getEmail();
    }

    @Override
    public void addManagementEmployee(float salary, int age, int SSN, String username, String email) throws RemoteException {
     ManagementEmployee newMangEmp = new ManagementEmployee( age, SSN, username, email,salary);
     DB_SC_Manager.getManagmentEmployees_S().add(newMangEmp);
    }
    @Override
    public void removeManagemenetEmployee(int userID) throws RemoteException {
        for (ManagementEmployee MangEmp : DB_SC_Manager.getManagmentEmployees_S()) {
            if (MangEmp.getUserID() == userID) {
                DB_SC_Manager.getManagmentEmployees_S().remove(MangEmp);
                break;
            }
        }
    }
}
