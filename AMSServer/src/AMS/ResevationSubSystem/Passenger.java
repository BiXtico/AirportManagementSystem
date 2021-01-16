/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.ResevationSubSystem;

import AMS.FlightManagementSubSystem.Flight;
import AMS.DB_SC_Manager;
import AMS.Interfaces.PassengerInterface;
import AMS.User;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author mahmo
 */
public class Passenger extends User implements PassengerInterface,PObserver,Serializable  {

    private String status, nationality;
    private BillingAccount billingAcc;
    private ArrayList<Booking> bookings;
    private SearchStrategy str;

    public Passenger() throws RemoteException {
        UnicastRemoteObject.exportObject((Remote) this, 0);
    }
    
    public Passenger( int age, int SSN, String username, String status, String email, String nationality, BillingAccount billingAcc) throws RemoteException {
        super(DB_SC_Manager.getID_Counter(), age, SSN, username, email);
        UnicastRemoteObject.exportObject((Remote) this, 0);
        this.nationality = nationality;
        this.status = status;
        this.billingAcc = billingAcc;
        Document doc = new Document("userID", DB_SC_Manager.getID_Counter())
                .append("age", age)
                .append("SSN", SSN)
                .append("username", username)
                .append("status", status)
                .append("nationality", nationality)
                .append("AccountID", billingAcc.getAccountID())
                .append("bookings", null);
        DB_SC_Manager.getPassengers().insertOne(doc);
        DB_SC_Manager.getPassengers_S().add(this);
        int count = DB_SC_Manager.getID_Counter()+1;
        DB_SC_Manager.setID_Counter(count);
    }

    public Passenger( int age, int SSN, String username, String status, String email, String nationality, BillingAccount billingAcc, ArrayList<Booking> bookings) throws RemoteException {
        super(DB_SC_Manager.getID_Counter(), age, SSN, username, email);
        UnicastRemoteObject.exportObject((Remote) this, 0);
        this.nationality = nationality;
        this.status = status;
        this.billingAcc = billingAcc;
        this.bookings = bookings;
        List<Integer> books = new ArrayList<>();
        this.bookings.forEach((i) -> {
            books.add(i.getBookingID());
        });
        Document doc = new Document("userID", DB_SC_Manager.getID_Counter())
                .append("age", age)
                .append("SSN", SSN)
                .append("username", username)
                .append("status", status)
                .append("nationality", nationality)
                .append("AccountID", billingAcc.getAccountID())
                .append("bookings", books);
        DB_SC_Manager.getPassengers().insertOne(doc);
        DB_SC_Manager.getPassengers_S().add(this);
        int count = DB_SC_Manager.getID_Counter()+1;
        DB_SC_Manager.setID_Counter(count);
    }

    public Passenger(int age, int SSN, String username, String email, String nationality) throws RemoteException {
        super(DB_SC_Manager.getID_Counter(), age, SSN, username, email);
        UnicastRemoteObject.exportObject(this, 0);
        this.nationality = nationality;
        this.billingAcc = null;
        this.bookings = null;
        Document doc = new Document("userID", DB_SC_Manager.getID_Counter())
                .append("age", age)
                .append("SSN", SSN)
                .append("username", username)
                .append("status", null)
                .append("nationality", nationality).append("billingAccount", null)
                .append("bookings", null);
        DB_SC_Manager.getPassengers().insertOne(doc);
        DB_SC_Manager.getPassengers_S().add(this);
        int count = DB_SC_Manager.getID_Counter()+1;
        DB_SC_Manager.setID_Counter(count);
    }

    @Override
    public String getStatus() throws RemoteException {
        return status;
    }

    @Override
    public String getNationality() throws RemoteException {
        return nationality;
    }

    @Override
    public BillingAccount getBillingAcc() throws RemoteException {
        return billingAcc;
    }

    @Override
    public ArrayList<Booking> getBookings() throws RemoteException {
        return bookings;
    }

    @Override
    public void setStatus(String status) throws RemoteException {
        this.status = status;

    }

    @Override
    public void setNationality(String nationality) throws RemoteException {
        this.nationality = nationality;
    }

    @Override
    public void setBillingAcc(BillingAccount billingAcc) throws RemoteException {
        this.billingAcc = billingAcc;
    }

    @Override
    public void setBookings(ArrayList<Booking> bookings) throws RemoteException {
        this.bookings = bookings;

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
    public ArrayList<Flight> searchMethod(String searchable,int num) throws RemoteException {
        if(num == 1) str = new SearchByDestination();
        else str = new SearchByAirline();
        return str.searchMethod(searchable);
    }   
    @Override
    public boolean bookFlight(int numOfSeats, String bookingDate, String Destination) throws RemoteException {
        for(Flight f:DB_SC_Manager.getFlights_S()){
            if(f.getDestination().equals(Destination)){
                Booking newBook = new Booking(DB_SC_Manager.getID_Counter(), numOfSeats, bookingDate);
                 this.bookings.add(newBook);
                 return true;
            }
        }
        return false;
    }
    @Override
    public boolean cancelBookedFlight(String Destination) throws RemoteException {
        for (Booking b : DB_SC_Manager.getBookings_S()) {
            if (b.getDestination() == null ? Destination == null : b.getDestination().equals(Destination)) {
                DB_SC_Manager.getBookings_S().remove(b);
                this.bookings.remove(b);
                DB_SC_Manager.removeBooking(Destination);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean editBookedFlight(int bookingID, int numOfSeats) throws RemoteException {
        for (Booking b : DB_SC_Manager.getBookings_S()) {
            if (b.getBookingID() == bookingID) {
                b.setNumofseats(numOfSeats);
                for (Booking bb : this.bookings) {
                    if (bb.getBookingID() == bookingID) {
                        bb.setNumofseats(numOfSeats);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    @Override
    public ArrayList<Booking> viewBookedFlights() throws RemoteException {
        return this.bookings;
    }
    @Override
    public void createFeedback(String Feedback, int FlightID, int rating) throws RemoteException {
        for(Flight f:DB_SC_Manager.getFlights_S()){
            if(f.getFlightID() == FlightID){
                Feedback feedback = new Feedback(Feedback, rating);
                DB_SC_Manager.getFeedbacks_S().add(feedback);
            }
        }
    }
    @Override
    public void Notify(String news) throws RemoteException {
        System.out.print("You have one update !!  " + news);
    }
}
