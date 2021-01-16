/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.Controllers;

import AMS.Interfaces.SystemManagerInterface;
import AMS.LoginGUI;
import AMS.SignUpPassenger;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SystemManagerController {

    private static SystemManagerInterface currentSM;

    public SystemManagerController() {

    }

    public static void LookupSystemManager() {
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            SystemManagerInterface sm = (SystemManagerInterface) registry.lookup("SM");
            currentSM = sm;
        } catch (NotBoundException | RemoteException ex) {
            System.out.println("Exception occured, Error Client side try connection failed, can't read registery binds");
        }
    }

    public static void createAccPassengers_() {
        SignUpPassenger main = new SignUpPassenger();
        main.setVisible(true);
    }

    public static void CreateAccPassengers(int age, int SSN, String username, String email, String nationality) throws RemoteException {
        currentSM.createAccountPassengers(age, SSN, username, email, nationality);
    }

    public static void CreateAccEmployees(int age, int SSN, String username, String email, float salary) throws RemoteException {
        currentSM.createAccountEmployees(age, SSN, username, email, salary);
    }

    public static void RefundPayments(int id) throws RemoteException {
        currentSM.refundPayment(id, 3000);
    }

    public static void loginInvoke() {
        LoginGUI login = new LoginGUI();
        login.setVisible(true);
    }

}
