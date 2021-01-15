/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.Interfaces;

import AMS.FlightManagementSubSystem.Flight;
import AMS.ResevationSubSystem.BillingAccount;
import AMS.ResevationSubSystem.Booking;
import AMS.ResevationSubSystem.SearchStrategy;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author mahmo
 */
public interface PassengerInterface extends Remote {
    
    public String getStatus()throws RemoteException;

    public String getNationality() throws RemoteException; 

    public BillingAccount getBillingAcc() throws RemoteException;

    public ArrayList<Booking> getBookings() throws RemoteException;

    public void setStatus(String status) throws RemoteException;

    public void setNationality(String nationality) throws RemoteException;

    public void setBillingAcc(BillingAccount billingAcc) throws RemoteException;

    public void setBookings(ArrayList<Booking> bookings) throws RemoteException;
    
    public void bookFlight(int numOfSeats, String bookingDate,String Destination ) throws RemoteException;
    
    public void cancelBookedFlight(String Destination) throws RemoteException;
    
    public void editBookedFlight(int bookingID,int numOfSeats) throws RemoteException;
    
    public String viewBookedFlights() throws RemoteException;
    
    public String searchMethod(String Searchable,int num) throws RemoteException;
    
    public void createFeedback(String Feedback, int FlightID) throws RemoteException;

    public void Notify() throws RemoteException;
    
    public String getLoginInUsername() throws RemoteException;

    public int getLoginInSSN()throws RemoteException;
    
    public String getLoginInEmail() throws RemoteException;
    
    
}
