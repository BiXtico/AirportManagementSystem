/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.Interfaces;

import AMS.Admin;
import AMS.FlightManagementSubSystem.ManagementEmployee;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author M.Eid
 */
public interface AdminInterface extends Remote  {

    public String getLoginInUsername()  throws RemoteException;
    public int getLoginInSSN()  throws RemoteException;
    public String getLoginInEmail()  throws RemoteException;
    public void addManagementEmployee(float salary, int age, int SSN, String username, String email) throws RemoteException;
    public void removeManagemenetEmployee(int userID) throws RemoteException;
 
}
