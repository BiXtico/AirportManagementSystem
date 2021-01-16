
package AMS.PlaneManagementSubSystem;


import AMS.DB_SC_Manager;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import org.bson.Document;

public class Plane implements Serializable  {
    private int planeID;
    private int planeCapacity;
    private PlaneSlot slot;

    public Plane()throws RemoteException{
         UnicastRemoteObject.exportObject((Remote) this, 0);

    }

    public Plane(int planeCapacity, PlaneSlot slot) {
        this.planeID = DB_SC_Manager.getID_Counter();
        this.planeCapacity = planeCapacity;
        this.slot = slot;
        Document doc = new Document("planeID", this.planeID)
        .append("planeCapacity", planeCapacity)
        .append("slotID", slot);
        DB_SC_Manager.getPlanes().insertOne(doc);
        DB_SC_Manager.getPlanes_S().add(this);
         int count = DB_SC_Manager.getID_Counter()+1;
        DB_SC_Manager.setID_Counter(count);
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