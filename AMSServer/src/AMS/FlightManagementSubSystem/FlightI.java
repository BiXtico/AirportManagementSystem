/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.FlightManagementSubSystem;

import AMS.ResevationSubSystem.PObserver;

/**
 *
 * @author mahmo
 */
public interface FlightI {

    public void addNotificationObserver(PObserver PO);

    //public void removeNotificationObserver(PObserver PO)throws RemoteException;
   public void NotifyAll(String news);
}

