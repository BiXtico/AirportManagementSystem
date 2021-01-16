/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.Interfaces;

/**
 *
 * @author mahmo
 */

import AMS.ResevationSubSystem.Booking;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ManagementEmployeeInterface extends Remote{

    public void addFlight(int flightID, String destination,
            String airline, String departureDate, String departureTime) 
            throws RemoteException;

    public void cancelFlight(int flightID) throws RemoteException;

    public void revokeBooking(int bookingID) throws RemoteException;

    public void reassignPilot(int flightID) throws RemoteException;

    public ArrayList<Booking> viewFlightBookings(int flightID) 
            throws RemoteException;

    public double getSalary() throws RemoteException;

    public void setSalary(double salary) throws RemoteException;

    public String getLoginInUsername() throws RemoteException;

    public int getLoginInSSN() throws RemoteException;

    public String getLoginInEmail() throws RemoteException;

}


