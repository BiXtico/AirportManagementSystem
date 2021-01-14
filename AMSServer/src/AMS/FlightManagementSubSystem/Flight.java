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
public class Flight {
    String destination,airline;

    public Flight(String destination, String airline) {
        this.destination = destination;
        this.airline = airline;
    }

    public Flight() {
    }

    public String getDestination() {
        return destination;
    }

    public String getAirline() {
        return airline;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
    

    
}
