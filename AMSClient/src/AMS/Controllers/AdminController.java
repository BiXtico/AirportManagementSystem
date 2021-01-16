/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.Controllers;

import AMS.Interfaces.AdminInterface;
import AMS.MainAdminGUI;
import AMS.ManagementEmployeeGUI.AddEmployeeGUI;
import AMS.ManagementEmployeeGUI.RemoveEmployeeGUI;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author mahmo
 */
public class AdminController {

    private static AdminInterface currentA;

    public static void setCurrentA(AdminInterface currentA) {
        AdminController.currentA = currentA;
    }

    public static void LookupAdmin(String username, int password) throws RemoteException {
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
                AdminInterface AI = (AdminInterface) registry.lookup("Admin");
                if (AI.getLoginInUsername().equals(username) && AI.getLoginInSSN() == password) {
                    currentA = AI;
                System.out.println("The new result is " + AI);
            }
        } catch (NotBoundException | RemoteException ex) {
            System.out.println("Exception occured, Error Client side try connection failed, can't read registery binds");
        }
    }

    public static void invokeMainPage() throws RemoteException {
        MainAdminGUI main = new MainAdminGUI();
        main.setVisible(true);
        main.getUsername().setText(currentA.getLoginInUsername());
    }

    public static void AddEmployee_() {
        AddEmployeeGUI main = new AddEmployeeGUI();
        main.setVisible(true);
    }

    public static void RemoveEmployee_() {
        RemoveEmployeeGUI main = new RemoveEmployeeGUI();
        main.setVisible(true);
    }

    public static void AddManagementEmployee(int age, int SSN, String username, String email, float salary) throws RemoteException {
        currentA.addManagementEmployee(salary, age, SSN, username, email);
    }

    public static void RemoveManagementEmployee(int userID) throws RemoteException {
        currentA.removeManagemenetEmployee(userID);
    }

    public static AdminInterface getCurrentA() {
        return currentA;
    }
}
