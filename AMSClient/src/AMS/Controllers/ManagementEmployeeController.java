/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.Controllers;

import AMS.DataModels.Booking;
import AMS.Interfaces.ManagementEmployeeInterface;
import AMS.MainEmployeeGUI;
import AMS.ManagementEmployeeGUI.AddFlightGUI;
import AMS.ManagementEmployeeGUI.ManageFlightGUI;
import AMS.ManagementEmployeeGUI.ReassignPilotGUI;
import AMS.ManagementEmployeeGUI.RevokeBookingGUI;
import AMS.ManagementEmployeeGUI.ViewFlightBookingsGUI;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

/**
 *
 * @author mahmo
 */
public class ManagementEmployeeController {

    private static ManagementEmployeeInterface currentM;

    public ManagementEmployeeController() throws RemoteException {
    }

    public static void LookupPassenger(String username, int password) throws RemoteException {
        try {
            int i = 0;
            Registry registry = LocateRegistry.getRegistry(1099);
            while (registry.lookup("MEmployee" + i) != null) {
                ManagementEmployeeInterface me = (ManagementEmployeeInterface) registry.lookup("MEmployee" + i);
                if (me.getLoginInUsername().equals(username) && me.getLoginInSSN() == password) {
                    currentM = me;
                    break;
                }
                System.out.println("The new result is " + me);
                ++i;
            }
        } catch (NotBoundException | RemoteException ex) {
            System.out.println("Exception occured, Error Client side try connection failed, can't read registery binds");
        }
    }

    public static void invokeMainPage() throws RemoteException {
        MainEmployeeGUI main = new MainEmployeeGUI();
        main.setVisible(true);
        main.getUsername().setText(currentM.getLoginInUsername());
    }

    public static void AddFlight_() {
        AddFlightGUI main = new AddFlightGUI();
        main.setVisible(true);

    }

    public static void ManageFlight_() {
        ManageFlightGUI main = new ManageFlightGUI();
        main.setVisible(true);

    }

    public static void ReassignPilot_() {
        ReassignPilotGUI main = new ReassignPilotGUI();
        main.setVisible(true);

    }

    public static void RevokeBooking_() {
        RevokeBookingGUI main = new RevokeBookingGUI();
        main.setVisible(true);

    }

    public static void ViewFlightBookings_() {
        ViewFlightBookingsGUI main = new ViewFlightBookingsGUI();
        main.setVisible(true);
    }

    public static void addFlight(String destination, String airline, String departureDate, String departureTime) throws RemoteException {
        currentM.addFlight(destination, airline, departureDate, departureTime);
    }

    public static void editFlightInfo(int flightID, String destination, String airline, String departureDate, String departureTime) throws RemoteException {
        currentM.editFlightInfo(flightID, destination, airline, departureDate, departureTime);
    }

    public static void cancelFlight(int flightID) throws RemoteException {
        currentM.cancelFlight(flightID);
    }

    public static void revokeBooking(int bookingID) throws RemoteException {
        currentM.cancelFlight(bookingID);
    }

    public static void reassignPilot(int flightID) throws RemoteException {
        currentM.cancelFlight(flightID);
    }

    public static String viewFlightBookings(int flightID) throws RemoteException {
        ArrayList<Booking> BB = currentM.viewFlightBookings(flightID);
        String S = "";
        for (Booking B : BB) {
            S += "Booking ID : " + B.getBookingID() + "\n";
            S += "num of seats : " + B.getNumofseats() + "\n";
            S += "Destination : " + B.getDestination() + "\n";
            S += "bookingDate : " + B.getBookingDate() + "\n\n";
        }
        return S;
    }
}
