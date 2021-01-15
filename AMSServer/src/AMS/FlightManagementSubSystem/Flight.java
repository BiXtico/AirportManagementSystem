
package AMS.FlightManagementSubSystem;
import AMS.Interfaces.FlightI;
import AMS.DB_SC_Manager;
import AMS.ResevationSubSystem.PObserver;
import AMS.PlaneManagementSubSystem.Gate;
import AMS.PlaneManagementSubSystem.Plane;
import AMS.ResevationSubSystem.Booking;
import AMS.ResevationSubSystem.Feedback;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;


public class Flight implements FlightI {
    private int flightID;
    private Plane plane;
    private Gate gate;
    private Pilot pilot;
    private String destination,airline;
    private String departureDate;
    private String departureTime;
    private ArrayList<Booking> bookings;
    private ArrayList<PObserver> PObservers;
    private ArrayList<Feedback> feedbackList;

    public Flight() throws RemoteException{
         UnicastRemoteObject.exportObject((Remote) this, 0);
    }

    public Flight(int flightID, Plane plane, Gate gate, Pilot pilot, String destination, String airline, String departureDate, String departureTime, ArrayList<Booking> bookings, ArrayList<PObserver> PObservers, ArrayList<Feedback> feedbackList) {
        this.flightID = flightID;
        this.plane = plane;
        this.gate = gate;
        this.pilot = pilot;
        this.destination = destination;
        this.airline = airline;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.bookings = bookings;
        this.PObservers = PObservers;
        this.feedbackList = feedbackList;
         List<Integer> booking = new ArrayList<>();
        this.bookings.forEach((i) -> {
            booking.add(i.getBookingID());
        });
         List<Integer> feedback = new ArrayList<>();
        this.feedbackList.forEach((i) -> {
            feedback.add(i.getFeedbackID());
        });
                Document doc = new Document("flightID", flightID)
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
    }

    

    
  
    @Override
    public int getFlightID() {
        return flightID;
    }
    @Override
    public void setFlightID(int flightID)  {
        this.flightID = flightID;
    }
    @Override
    public Plane getPlane()  {
        return plane;
    }
    @Override
    public void setPlane(Plane plane)  {
        this.plane = plane;
    }
    @Override
    public Gate getGate()  {
        return gate;
    }
    @Override
    public void setGate(Gate gate) {
        this.gate = gate;
    }
    @Override
    public Pilot getPilot() {
        return pilot;
    }
    @Override
    public void setPilot(Pilot pilot){
        this.pilot = pilot;
    }
    @Override
    public String getDestination(){
        return destination;
    }
    @Override
    public void setDestination(String destination){
        this.destination = destination;
    }
    @Override
    public String getAirline(){
        return airline;
    }
    @Override
    public void setAirline(String airline){
        this.airline = airline;
    }
    @Override
    public String getDepartureDate() {
        return departureDate;
    }
    @Override
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }
    @Override
    public String getDepartureTime() {
        return departureTime;
    }
    @Override
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }


    @Override
    public ArrayList<Booking> getBookings(){
        return bookings;
    }
    @Override
    public void setBookings(ArrayList<Booking> bookings){
        this.bookings = bookings;
    }
    @Override
    public ArrayList<PObserver> getPObservers(){
        return PObservers;
    }
    @Override
    public void setPObservers(ArrayList<PObserver> PObservers){
        this.PObservers = PObservers;
    }

  
    @Override
    public ArrayList<Feedback> getFeedbackList(){
        return feedbackList;
    }
    @Override
    public void setFeedbackList(ArrayList<Feedback> feedbackList){
        this.feedbackList = feedbackList;
    }
    @Override
     public void addNotificationObserver(PObserver PO){
     //PObservers.add(PO);
     }
     
     @Override
     public void removeNotificationObserver(PObserver PO){
     //PObservers.remove(PO);
     }
     
     @Override
     public void NotifyAll(String n){
     //PObservers.notifyAll();
     }

   

    
}
