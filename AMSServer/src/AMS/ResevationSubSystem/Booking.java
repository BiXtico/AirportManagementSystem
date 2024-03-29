
package AMS.ResevationSubSystem;


import AMS.DB_SC_Manager;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import org.bson.Document;


public class Booking implements Serializable {
    private int bookingID;
    private int numofseats;
    private String Destination;
    private String bookingDate;

    public Booking()throws RemoteException{
         UnicastRemoteObject.exportObject((Remote) this, 0);
    }

    public Booking(int numofseats, String Destination, String bookingDate) {
        this.bookingID = DB_SC_Manager.getID_Counter();
        this.numofseats = numofseats;
        this.Destination = Destination;
        this.bookingDate = bookingDate;
        Document doc = new Document("bookingID", this.bookingID)
        .append("numofseats", numofseats)
        .append("Destination", Destination)
        .append("bookingDate", bookingDate);
        DB_SC_Manager.getBookings().insertOne(doc);
        DB_SC_Manager.getBookings_S().add(this);
        int count = DB_SC_Manager.getID_Counter()+1;
        DB_SC_Manager.setID_Counter(count);
    }

    public Booking(int bookingID, int numofseats, String bookingDate) {
        this.bookingID = bookingID;
        this.numofseats = numofseats;
        this.bookingDate = bookingDate;
    }

 

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getDestination() {
        return Destination;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public int getBookingID() {
        return bookingID;
    }

    public int getNumofseats() {
        return numofseats;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public void setNumofseats(int numofseats) {
        this.numofseats = numofseats;
    }


}
