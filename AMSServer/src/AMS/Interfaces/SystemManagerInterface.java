/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author mahmo
 */
public interface SystemManagerInterface extends Remote {
    
    public void createAccount() throws RemoteException ;
    public void createBillingAccount() throws RemoteException ;
    public void refundPayment() throws RemoteException ;
    public void assignPassengerGate() throws RemoteException ;
    public void assignPlane() throws RemoteException ; 
    public void assignFlightStaff() throws RemoteException ;  
}
