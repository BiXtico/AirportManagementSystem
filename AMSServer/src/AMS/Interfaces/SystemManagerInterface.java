/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.Interfaces;

import AMS.FlightManagementSubSystem.Pilot;
import AMS.PlaneManagementSubSystem.Gate;
import AMS.PlaneManagementSubSystem.Plane;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SystemManagerInterface extends Remote {

    public void createAccountPassengers(int age, int SSN, String username, String email, String nationality) throws RemoteException;

    public void createAccountEmployees(int age, int SSN, String username, String email, float salary) throws RemoteException;

    public void refundPayment(int AccountID, double balance) throws RemoteException;

    public Gate assignPassengerGate() throws RemoteException;

    public Plane assignPlane() throws RemoteException;

    public Pilot assignFlightStaff() throws RemoteException;
}
