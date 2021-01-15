/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.DataModels;

import AMS.Interfaces.PassengerInterface;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mahmo
 */
public class Passenger extends User {

    private String status, nationality;
    private BillingAccount billingAcc;
    private ArrayList<Booking> bookings;
    
    public Passenger() throws RemoteException {
        UnicastRemoteObject.exportObject((Remote) this, 0);
    }

    public Passenger(int userID, int age, int SSN, String username, String status, String email, String nationality, BillingAccount billingAcc, ArrayList<Booking> bookings) throws RemoteException {
        super(userID, age, SSN, username, email);
        UnicastRemoteObject.exportObject((Remote) this, 0);
        this.nationality = nationality;
        this.status = status;
        this.billingAcc = billingAcc;
        this.bookings = bookings;
       
    }

    public Passenger(int userID, int age, int SSN, String username, String email, String nationality) throws RemoteException {
        super(userID, age, SSN, username, email);
        UnicastRemoteObject.exportObject((Remote) this, 0);
        this.nationality = nationality;
        this.billingAcc = null;
        this.bookings = null;
    }

    
}
