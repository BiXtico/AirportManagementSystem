/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS;

import AMS.Interfaces.SystemManagerInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author mahmo
 */
public class SystemManager implements SystemManagerInterface {

    public SystemManager() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public int add(int x, int y) throws RemoteException {
        return x + y;
    }

    @Override
    public int sub(int x, int y) throws RemoteException {
        return x - y;
    }

}
