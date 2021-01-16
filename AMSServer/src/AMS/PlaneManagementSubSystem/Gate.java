
package AMS.PlaneManagementSubSystem;

import AMS.DB_SC_Manager;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import org.bson.Document;

public class Gate implements Serializable {
    private int gateNum;
    private boolean isAvailable; 

    public Gate() throws RemoteException{
         UnicastRemoteObject.exportObject((Remote) this, 0);
    }


    public Gate(boolean isAvailable) {
        this.gateNum = DB_SC_Manager.getID_Counter();
        this.isAvailable = isAvailable;
        
        Document doc = new Document("gateNum", gateNum)
        .append("isAvailable", isAvailable);

        DB_SC_Manager.getGates().insertOne(doc);
        DB_SC_Manager.getGates_S().add(this);
         int count = DB_SC_Manager.getID_Counter()+1;
        DB_SC_Manager.setID_Counter(count);
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