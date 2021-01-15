
package AMS.PlaneManagementSubSystem;


import AMS.DB_SC_Manager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import org.bson.Document;

public class Plane {
    private int planeID;
    private int planeCapacity;
    private PlaneSlot slot;

    public Plane()throws RemoteException{
         UnicastRemoteObject.exportObject((Remote) this, 0);

    }

    public Plane(int planeID, int planeCapacity, PlaneSlot slot) {
        this.planeID = planeID;
        this.planeCapacity = planeCapacity;
        this.slot = slot;
        Document doc = new Document("planeID", planeID)
        .append("planeCapacity", planeCapacity)
        .append("slotID", slot);
        DB_SC_Manager.getPlanes().insertOne(doc);
        DB_SC_Manager.getPlanes_S().add(this);
    }

    public int getPlaneID() {
        return planeID;
    }

    public void setPlaneID(int planeID) {
        this.planeID = planeID;
    }

    public int getPlaneCapacity() {
        return planeCapacity;
    }

    public void setPlaneCapacity(int planeCapacity) {
        this.planeCapacity = planeCapacity;
    }

    public PlaneSlot getSlot() {
        return slot;
    }

    public void setSlot(PlaneSlot slot) {
        this.slot = slot;
    }

}