package AMS.FlightManagementSubSystem;

import AMS.DB_SC_Manager;
import AMS.ResevationSubSystem.PObserver;
import AMS.PlaneManagementSubSystem.Gate;
import AMS.PlaneManagementSubSystem.Plane;
import AMS.ResevationSubSystem.Booking;
import AMS.ResevationSubSystem.Feedback;
import AMS.SystemManager;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

public class Flight implements FlightI, Serializable  {

    private int flightID;
    private Plane plane;
    private Gate gate;
    private Pilot pilot;
    private String destination, airline;
    private String departureDate;
    private String departureTime;
    private ArrayList<Booking> bookings;
    private ArrayList<PObserver> PObservers;
    private ArrayList<Feedback> feedbackList;

    public Flight() throws RemoteException {
        UnicastRemoteObject.exportObject((Remote) this, 0);
    }

    public Flight(String destination, String airline, String departureDate, String departureTime, ArrayList<Booking> bookings) throws RemoteException {
        SystemManager sm = new SystemManager();
        this.flightID = DB_SC_Manager.getID_Counter();
        this.plane = sm.assignPlane();
        this.gate = sm.assignPassengerGate();
        this.pilot = sm.assignFlightStaff();
        this.destination = destination;
        this.airline = airline;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.bookings = bookings;
        List<Integer> booking = new ArrayList<>();
        this.bookings.forEach((i) -> {
            booking.add(i.getBookingID());
        });
        List<Integer> feedback = new ArrayList<>();
        this.feedbackList.forEach((i) -> {
            feedback.add(i.getFeedbackID());
        });
        Document doc = new Document("flightID", this.flightID)
                .append("planeID", plane.getPlaneID())
                .append("gateID", gate)
                .append("pilotID", pilot)
                .append("destination", destination)
                .append("airline", airline)
                .append("departureDate", departureDate)
                .append("departureTime", departureTime)
                .append("bookings", booking)
                .append("feedbackList", feedback);
        DB_SC_Manager.getFlights().insertOne(doc);
        DB_SC_Manager.getFlights_S().add(this);
        int count = DB_SC_Manager.getID_Counter()+1;
        DB_SC_Manager.setID_Counter(count);
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    public ArrayList<PObserver> getPObservers() {
        return PObservers;
    }

    public void setPObservers(ArrayList<PObserver> PObservers) {
        this.PObservers = PObservers;
    }

    public ArrayList<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(ArrayList<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }


    public void removeNotificationObserver(PObserver PO) {
        //PObservers.remove(PO);
    }

    @Override
    public void addNotificationObserver(PObserver PO) {
        PObservers.add(PO);
    }

    @Override
    public void NotifyAll(String news){
        //PObservers.notifyAll();
        for (int i = 0; i < PObservers.size(); i++) {
            try {
                PObservers.get(i).Notify(news);
            } catch (RemoteException ex) {
                Logger.getLogger(Flight.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
