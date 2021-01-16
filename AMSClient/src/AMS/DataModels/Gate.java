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

/**
 *
 * @author mahmo
 */
public class Gate implements Serializable  {
     private int gateNum;
    private boolean isAvailable; 

    public Gate() throws RemoteException{
         UnicastRemoteObject.exportObject((Remote) this, 0);
    }


    public Gate(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public int getGateNum()throws RemoteException {
        return gateNum;
    }

    public void setGateNum(int gateNum)throws RemoteException {
        this.gateNum = gateNum;
    }

    public boolean isIsAvailable()throws RemoteException {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable)throws RemoteException {
        this.isAvailable = isAvailable;
    }
}
