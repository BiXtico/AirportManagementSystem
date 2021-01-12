/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.ResevationSubSystem;

import AMS.FlightManagementSubSystem.Flight;
import AMS.ResevationSubSystem.BillingAccount;
import AMS.DB_SC_Manager;
import AMS.Interfaces.PassengerInterface;
import AMS.User;
import com.mongodb.client.MongoCollection;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;


/**
 *
 * @author mahmo
 */
public class Passenger extends User implements PassengerInterface {
    private String status,nationality;
    private BillingAccount billingAcc;
    private ArrayList<Booking> bookings;

    public Passenger() {
    }
         
      public Passenger(int userID, int age, int SSN, String username,String status, String email,String nationality, BillingAccount billingAcc, ArrayList<Booking> bookings) throws RemoteException{
        super(userID, age, SSN, username, email);
        UnicastRemoteObject.exportObject((Remote) this, 0);
        this.nationality = nationality;
        this.status = status;
        this.billingAcc = billingAcc;
        this.bookings = bookings;
        List<Integer> books = new ArrayList<>();
        this.bookings.forEach((i) -> {
            books.add(i.getBookingID());
        });
        Document doc = new Document("userID", userID)
                .append("age",age)
                .append("SSN", SSN)
                .append("username", username)
                .append("status",status)
                .append("nationality", nationality)
                .append("billingAccount", billingAcc.getAccountID())
                .append("bookings",books);          
        DB_SC_Manager.getPassengers().insertOne(doc);
    }
    public Passenger(int userID, int age, int SSN, String username, String email,String nationality) throws RemoteException{
        super(userID, age, SSN, username, email);
        UnicastRemoteObject.exportObject(this, 0);
        Document doc = new Document("userID", userID)
                .append("age",age)
                .append("SSN", SSN)
                .append("username", username)
                .append("status", null)
                .append("nationality", nationality).append("billingAccount", null)
                .append("bookings", null);
        DB_SC_Manager.getPassengers().insertOne(doc);
        this.nationality = nationality;
    }

    @Override
    public String getStatus()throws RemoteException {
        return status;
    }

    @Override
    public String getNationality() throws RemoteException{
        return nationality;
    }

    @Override
    public BillingAccount getBillingAcc() throws RemoteException{
        return billingAcc;
    }

    @Override
    public ArrayList<Booking> getBookings() throws RemoteException{
        return bookings;
    }

    @Override
    public void setStatus(String status) throws RemoteException{
        this.status = status;
    }

    @Override
    public void setNationality(String nationality) throws RemoteException{
        this.nationality = nationality;
    }

    @Override
    public void setBillingAcc(BillingAccount billingAcc) throws RemoteException{
        this.billingAcc = billingAcc;
    }

    @Override
    public void setBookings(ArrayList<Booking> bookings) throws RemoteException{
        this.bookings = bookings;
    }
    
    @Override
    public void searchMethod() throws RemoteException{
        
    }
    @Override
    public void bookFlight() throws RemoteException{
        
    }
    @Override
    public void cancelBookedFlight() throws RemoteException{
        
    }
    @Override
    public void editBookedFlight() throws RemoteException{
        
    }
    @Override
    public Flight viewBookedFlight() throws RemoteException{
        
        return null;
    }
    
    @Override
    public ArrayList<Flight> viewFlighthistory() throws RemoteException{
        return null;
    }
    @Override
    public void createFeedback() throws RemoteException{
        
    }

    @Override
    public void Notify() throws RemoteException{
        
    }
}
