/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.FlightManagementSubSystem;

/**
 *
 * @author mahmo
 */
import AMS.DB_SC_Manager;
import AMS.Interfaces.ManagementEmployeeInterface;
import AMS.ResevationSubSystem.Booking;
import AMS.User;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import org.bson.Document;

public class ManagementEmployee extends User implements ManagementEmployeeInterface,Serializable  {

    private double salary;

    public ManagementEmployee() throws RemoteException {
        UnicastRemoteObject.exportObject((Remote) this, 0);
    }

    public ManagementEmployee(int age, int SSN, String username, String email, float salary) throws RemoteException {
        super(DB_SC_Manager.getID_Counter(), age, SSN, username, email);
        UnicastRemoteObject.exportObject((Remote) this, 0);
        this.salary = salary;
        Document doc = new Document("userID", DB_SC_Manager.getID_Counter())
                .append("age", age)
                .append("SSN", SSN)
                .append("username", username)
                .append("email", email)
                .append("salary", salary);
        DB_SC_Manager.getManagmentEmployees().insertOne(doc);
        DB_SC_Manager.getManagmentEmployees_S().add(this);
        int count = DB_SC_Manager.getID_Counter()+1;
        DB_SC_Manager.setID_Counter(count);
    }

    @Override
    public void addFlight(int flightID, String destination, String airline, String departureDate, String departureTime) {

    }

    @Override
    public void cancelFlight(int flightID) {

        for (Flight f : DB_SC_Manager.getFlights_S()) {
            if (f.getFlightID() == flightID) {
                DB_SC_Manager.getFlights_S().remove(f);

                // call function of database
            }
        }
    }

    @Override
    public void revokeBooking(int bookingID) {

        for (Booking b : DB_SC_Manager.getBookings_S()) {
            if (b.getBookingID() == bookingID) {
                DB_SC_Manager.getBookings_S().remove(b);

                // call function of database
            }
        }
    }

    @Override
    public void reassignPilot(int flightID) {

        for (Flight f : DB_SC_Manager.getFlights_S()) {
            if (f.getFlightID() == flightID) {

                //Assign pilot of system manager
                //f.setPilot();
                // call function of database
            }
        }
    }

    @Override
    public ArrayList<Booking> viewFlightBookings(int flightID) {

        for (Flight f : DB_SC_Manager.getFlights_S()) {
            if (f.getFlightID() == flightID) {
                return f.getBookings();
            }
        }
        return null;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void setSalary(double salary) {
        this.salary = salary;
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
}
