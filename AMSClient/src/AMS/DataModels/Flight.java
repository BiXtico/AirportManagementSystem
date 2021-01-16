/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.DataModels;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


/**
 *
 * @author mahmo
 */
public class Flight implements Serializable {
     private int flightID;
    private Plane plane;
    private Gate gate;
    private Pilot pilot;
    private String destination,airline;
    private String departureDate;
    private String departureTime;
    private ArrayList<Booking> bookings;
    private ArrayList<Feedback> feedbackList;

    public Flight() throws RemoteException{
         UnicastRemoteObject.exportObject((Remote) this, 0);
    }

    public Flight(int flightID, Plane plane, Gate gate, Pilot pilot,
            String destination, String airline, String departureDate,
            String departureTime, ArrayList<Booking> bookings, ArrayList<Feedback> feedbackList) {
        this.flightID = flightID;
        this.plane = plane;
        this.gate = gate;
        this.pilot = pilot;
        this.destination = destination;
        this.airline = airline;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.bookings = bookings;
        this.feedbackList = feedbackList; 
    }


    public int getFlightID(){
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public Plane getPlane(){
        return plane;
    }

    public void setPlane(Plane plane){
        this.plane = plane;
    }

    public Gate getGate(){
        return gate;
    }

    public void setGate(Gate gate){
        this.gate = gate;
    }

    public Pilot getPilot(){
        return pilot;
    }

    public void setPilot(Pilot pilot){
        this.pilot = pilot;
    }

    public String getDestination(){
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAirline(){
        return airline;
    }

    public void setAirline(String airline){
        this.airline = airline;
    }

    public String getDepartureDate(){
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime(){
        return departureTime;
    }

    public void setDepartureTime(String departureTime){
        this.departureTime = departureTime;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings){
        this.bookings = bookings;
    }

    public ArrayList<Feedback> getFeedbackList(){
        return feedbackList;
    }

    public void setFeedbackList(ArrayList<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

}