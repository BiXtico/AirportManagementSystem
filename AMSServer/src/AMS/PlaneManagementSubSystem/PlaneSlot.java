/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.PlaneManagementSubSystem;


import AMS.DB_SC_Manager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import org.bson.Document;

public class PlaneSlot {
    private int slotID;
    private boolean isAvailable;

    public PlaneSlot()throws RemoteException{
         UnicastRemoteObject.exportObject((Remote) this, 0);
    }
    public PlaneSlot(int slotID, boolean isAvailable) {
        this.slotID = slotID;
        this.isAvailable = isAvailable;
        Document doc = new Document("slotID", slotID)
        .append("isAvailable", isAvailable);
        DB_SC_Manager.getPlaneSlots().insertOne(doc);
        DB_SC_Manager.getPlaneSlots_S().add(this);
    }

    public int getSlotID() {
        return slotID;
    }

    public void setSlotID(int slotID) {
        this.slotID = slotID;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

}
