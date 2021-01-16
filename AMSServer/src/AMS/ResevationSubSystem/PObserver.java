/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.ResevationSubSystem;

import java.rmi.RemoteException;

/**
 *
 * @author mahmo
 */
public interface PObserver {
    public void Notify(String news) throws RemoteException;
}
