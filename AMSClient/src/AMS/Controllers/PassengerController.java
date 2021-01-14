/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.Controllers;

import AMS.DataModels.Passenger;
import AMS.Interfaces.PassengerInterface;
import java.awt.List;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

/**
 *
 * @author mahmo
 */
public final class PassengerController {

    private static PassengerInterface currentP;

    public PassengerController() throws RemoteException {
        
    }

    public void LookupPassenger(String username, int password) throws RemoteException {
        try {
            int i = 0;
            Registry registry = LocateRegistry.getRegistry(1099);
            while (registry.lookup("pass" + i) != null) {
                PassengerInterface sm = (PassengerInterface) registry.lookup("pass" + i);
                if (sm.getLoginInUsername().equals(username) && sm.getLoginInSSN() == password) {
                    currentP = sm;
                    break;
                }
                System.out.println("The new result is " + sm);
                ++i;
            }
        } catch (NotBoundException | RemoteException ex) {
            System.out.println("Exception occured, Error Client side try connection failed, can't read registery binds");
        }
    }

    public PassengerInterface getCurrentP() {
        return currentP;
    }

}
