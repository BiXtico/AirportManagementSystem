/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.Controllers;
import AMS.Interfaces.SystemManagerInterface;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class SystemManagerController {

    public SystemManagerController() {     
    }
    public void LookupSystemManager(){
         try {
            Registry registry = LocateRegistry.getRegistry(1082);  
            SystemManagerInterface sm = (SystemManagerInterface) registry.lookup("ss");
           // System.out.println("The new result is " + sm.add(7, 7));
        } catch (NotBoundException | RemoteException ex) {
            System.out.println("Exception occured, Error Client side try connection failed, can't read registery binds");
        }
    }
    
}
