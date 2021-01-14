
package AMS.ResevationSubSystem;


public class Booking {
    private int bookingID;
    private int numofseats;
    private String Destination;
    private String bookingDate;

    public Booking() {
    }

    public Booking(int bookingID, int numofseats,String bookingDate) {
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
