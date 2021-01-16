/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.FlightManagementSubSystem;

import AMS.DB_SC_Manager;
import java.io.Serializable;
import java.rmi.RemoteException;
import org.bson.Document;

public class Pilot implements Serializable {

    private int pilotID;
    private String name;
    private boolean isAvailable;

    public Pilot(String name, boolean isAvailable) {
        this.pilotID = DB_SC_Manager.getID_Counter();
        this.name = name;
        this.isAvailable = isAvailable;
        Document doc = new Document("pilotID", this.pilotID)
                .append("name", name)
                .append("isAvailable", isAvailable);
        DB_SC_Manager.getPilots().insertOne(doc);
        DB_SC_Manager.getPilots_S().add(this);
        int count = DB_SC_Manager.getID_Counter() + 1;
        DB_SC_Manager.setID_Counter(count);
    }

    public Pilot() throws RemoteException {

    }

    public int getPilotID() {
        return pilotID;
    }

    public void setPilotID(int pilotID) {
        this.pilotID = pilotID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
