/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.DataModels;

import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author mahmo
 */
public class Passenger extends User implements Serializable{
    private String status,nationality;
    private BillingAccount billingAcc;
    private ArrayList<Booking> bookings;

    public Passenger(int userID, int SSN) {
       super(userID, SSN);
    }

    public Passenger() {
    }


    public Passenger(String nationality, BillingAccount billingAcc, ArrayList<Booking> bookings) {
        this.nationality = nationality;
        this.billingAcc = billingAcc;
        this.bookings = bookings;
    }
        public String getStatus() {
        return status;
    }

    public String getNationality() {
        return nationality;
    }

    public BillingAccount getBillingAcc() {
        return billingAcc;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setBillingAcc(BillingAccount billingAcc) {
        this.billingAcc = billingAcc;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }
}
