
package AMS.ResevationSubSystem;


public class Booking {
    private int bookingID;
    private int numofseats;

    public Booking() {
    }

    public Booking(int bookingID, int numofseats) {
        this.bookingID = bookingID;
        this.numofseats = numofseats;
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
