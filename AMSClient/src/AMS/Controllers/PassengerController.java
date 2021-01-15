/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.Controllers;

import AMS.DataModels.Passenger;
import AMS.Interfaces.PassengerInterface;
import AMS.MainPassengerGUI;
import AMS.PassengerGUI.BookFlightGUI;
import AMS.PassengerGUI.CancelBookedFlightGUI;
import AMS.PassengerGUI.CreateAccountGUI;
import AMS.PassengerGUI.ManageBookingGUI;
import AMS.PassengerGUI.ReviewFlightGUI;
import AMS.PassengerGUI.ViewFlightsGUI;
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

    public static void  LookupPassenger(String username, int password) throws RemoteException {
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
    public static void invokeMainPage() throws RemoteException{
        MainPassengerGUI main = new MainPassengerGUI();
        main.setVisible(true);
        main.getUsername().setText(currentP.getLoginInUsername());
    }
    
    public static void bookFlight_(){
        BookFlightGUI main = new BookFlightGUI();
        main.setVisible(true);
    }
    public static void cancelBookedFlight_(){
        CancelBookedFlightGUI main = new CancelBookedFlightGUI();
        main.setVisible(true);
    }
    public static void editBookedFlight_(){
        ManageBookingGUI main = new ManageBookingGUI();
        main.setVisible(true);
    }
    public static void viewFlights_(){
        ViewFlightsGUI main = new ViewFlightsGUI();
        main.setVisible(true);
    }

    public static void ReviewFlight_(){
        ReviewFlightGUI main = new ReviewFlightGUI();
        main.setVisible(true);
    }
    public static void SaveAndExit_(){
        
        System.exit(0);
    }

    public static PassengerInterface getCurrentP() {
        return currentP;
    }
    
    
    

}
