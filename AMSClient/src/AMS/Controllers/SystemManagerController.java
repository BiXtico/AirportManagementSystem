/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.Controllers;

import AMS.Interfaces.SystemManagerInterface;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SystemManagerController {

    private static SystemManagerInterface currentP;
    public SystemManagerController() {
          
    }
    public static void LookupSystemManager(){
         try {
            Registry registry = LocateRegistry.getRegistry(1099);  
            SystemManagerInterface sm = (SystemManagerInterface) registry.lookup("SM");
           sm.createAccountPassengers(21, 2138873673, "Salma", "Salma167227@bue.edu.eg", "Egyptian");
           currentP = sm;
        } catch (NotBoundException | RemoteException ex) {
            System.out.println("Exception occured, Error Client side try connection failed, can't read registery binds");
        }
    }
    public static void CreateAccPassengers() throws RemoteException{
        currentP.createAccountPassengers(21, 213887367, "Salma", "Salma167227@bue.edu.eg", "Egyptian");
        currentP.createAccountPassengers(35, 281888101, "Maha", "Maha182@gmail.com", "Canadian");
    }
    public static void CreateAccEmployees() throws RemoteException{
        currentP.createAccountEmployees(30, 318291091, "Mahmoud", "Mahmoud2070@gmail.com", 4000);
    }
        public static void CreateBillingAcc() throws RemoteException{
            currentP.createBillingAccount(2000);
    }
        public static void RefundPayments() throws RemoteException{
            currentP.refundPayment(186392, 3000);
    }
        public static void AssignPassengersGate() throws RemoteException{
            currentP.assignPassengerGate();
    }
     public static void AssignPlanes() throws RemoteException{
         currentP.assignPlane();
    }
           
}

