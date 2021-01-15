/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.FlightManagementSubSystem;
import AMS.DB_SC_Manager;
import java.rmi.RemoteException;
import org.bson.Document;

public class Pilot {
    private int pilotID;
    private String name;
    private boolean isAvailable;


    public Pilot(int pilotID, String name, boolean isAvailable) {
        this.pilotID = pilotID;
        this.name = name;
        this.isAvailable = isAvailable;
        Document doc = new Document("pilotID", pilotID)
        .append("name", name)
        .append("isAvailable", isAvailable);
        DB_SC_Manager.getPilots().insertOne(doc);
        DB_SC_Manager.getPilots_S().add(this);
    }

    public Pilot()throws RemoteException{

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