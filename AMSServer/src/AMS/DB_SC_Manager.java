/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS;

import AMS.FlightManagementSubSystem.Flight;
import AMS.FlightManagementSubSystem.ManagementEmployee;
import AMS.FlightManagementSubSystem.Pilot;
import AMS.Interfaces.PassengerInterface;
import AMS.PlaneManagementSubSystem.Gate;
import AMS.PlaneManagementSubSystem.Plane;
import AMS.PlaneManagementSubSystem.PlaneSlot;
import AMS.ResevationSubSystem.BillingAccount;
import AMS.ResevationSubSystem.Booking;
import AMS.ResevationSubSystem.Feedback;
import AMS.ResevationSubSystem.Passenger;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;
import static com.mongodb.client.model.Updates.set;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author mahmo
 */
public final class DB_SC_Manager {

    private static ArrayList<Passenger> Passengers_S;
    private static ArrayList<BillingAccount> BilligAccounts_S;
    private static ArrayList<Feedback> Feedbacks_S;
    private static ArrayList<Booking> Bookings_S;
    private static ArrayList<Gate> Gates_S;
    private static ArrayList<Plane> Planes_S;
    private static ArrayList<PlaneSlot> PlaneSlots_S;
    private static ArrayList<ManagementEmployee> ManagmentEmployees_S;
    private static ArrayList<Flight> Flights_S;
    private static ArrayList<Pilot> Pilots_S;

    private static MongoClient mongoClient;
    private static MongoCollection<Document> Passengers;
    private static MongoCollection<Document> BilligAccounts;
    private static MongoCollection<Document> Feedbacks;
    private static MongoCollection<Document> Bookings;
    private static MongoCollection<Document> Gates;
    private static MongoCollection<Document> Planes;
    private static MongoCollection<Document> PlaneSlots;
    private static MongoCollection<Document> ManagmentEmployees;
    private static MongoCollection<Document> Flights;
    private static MongoCollection<Document> Pilots;

    public DB_SC_Manager() throws RemoteException {
        String connectionString = "mongodb+srv://Admin:ydv4FZVwlrw5fAOF@ams.ff92t.mongodb.net/<dbname>?retryWrites=true&w=majority";
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try {
            mongoClient = new MongoClient(new MongoClientURI(connectionString));
            Passengers = DB_SC_Manager.getMongoClient().getDatabase("AMS").getCollection("Passenger");
            BilligAccounts = DB_SC_Manager.getMongoClient().getDatabase("AMS").getCollection("BillingAccount");
            Feedbacks = DB_SC_Manager.getMongoClient().getDatabase("AMS").getCollection("Feedback");
            Bookings = DB_SC_Manager.getMongoClient().getDatabase("AMS").getCollection("booking");
            Gates = DB_SC_Manager.getMongoClient().getDatabase("AMS").getCollection("Gate");
            Planes = DB_SC_Manager.getMongoClient().getDatabase("AMS").getCollection("plane");
            PlaneSlots = DB_SC_Manager.getMongoClient().getDatabase("AMS").getCollection("planeSlot");
            ManagmentEmployees = DB_SC_Manager.getMongoClient().getDatabase("AMS").getCollection("MananagmentEmployee");
            Flights = DB_SC_Manager.getMongoClient().getDatabase("AMS").getCollection("Flights");
            Pilots = DB_SC_Manager.getMongoClient().getDatabase("AMS").getCollection("Pilot");

            MongoIterable<String> mc = mongoClient.listDatabaseNames();
            MongoCursor<String> cursor = mc.cursor();
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        } catch (Exception ex) {
            System.out.println("Exception occured, Database connection Error");
        }

        Passengers_S = new ArrayList<>();
        BilligAccounts_S = new ArrayList<>();
        Feedbacks_S = new ArrayList<>();
        Bookings_S = new ArrayList<>();
        Gates_S = new ArrayList<>();
        Planes_S = new ArrayList<>();
        PlaneSlots_S = new ArrayList<>();
        ManagmentEmployees_S = new ArrayList<>();
        Flights_S = new ArrayList<>();
        Pilots_S = new ArrayList<>();

    }

    public static void UpdatePassengers() throws RemoteException {
        List<Integer> bb = new ArrayList<>();
        for(Passenger p: Passengers_S){
            Passengers.findOneAndUpdate(new Document("userID", p.getUserID()), set("status", p.getStatus()));
            Passengers.findOneAndUpdate(new Document("userID", p.getUserID()), set("age", p.getAge()));
            Passengers.findOneAndUpdate(new Document("userID", p.getUserID()), set("SSN", p.getSSN()));
            Passengers.findOneAndUpdate(new Document("userID", p.getUserID()), set("nationality", p.getNationality()));
            Passengers.findOneAndUpdate(new Document("userID", p.getUserID()), set("AccountID", p.getBillingAcc().getAccountID()));
            for(Booking b :p.getBookings()){
                bb.add(b.getBookingID());
            }
            Passengers.findOneAndUpdate(new Document("bookings",p.getUserID()), set("bookings", bb));
        }
    }

    public static void readPassengers() throws RemoteException {
        Passenger p = new Passenger();
        BillingAccount acc = new BillingAccount();
        ArrayList<Booking> B = new ArrayList<>();
        int AI = 0;
        try {
            ArrayList<Document> docs = Passengers.find().into(new ArrayList<>());
            for (Document i : docs) {
                p.setUserID(i.getInteger("userID"));
                p.setAge(i.getInteger("age"));
                p.setSSN(i.getInteger("SSN"));
                p.setStatus(i.getString("status"));
                p.setUsername(i.getString("username"));
                p.setNationality(i.getString("nationality"));
                AI = i.getInteger("AccountID");
                for(BillingAccount b:BilligAccounts_S){
                    if(b.getAccountID() == AI){
                        acc = b;
                        break;
                    }
                }    
                List<Integer> books = (List<Integer>) i.get("bookings");
                for (int j : books) {
                    for (Booking k : Bookings_S) {
                        if (k.getBookingID() == j) {
                            B.add(k);
                            break;
                        }
                    }
                }
                p.setBookings(B);
                p.setBillingAcc(acc);
                Passengers_S.add(p);
            }
        } catch (RemoteException ex) {
            System.out.print("Error reading files form mongoose");
        }
    }

    public void RegisterPassenger() {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            // My remote object [Skeleton]
            for(int i =0;i<Passengers_S.size();i++){
                PassengerInterface PI = (PassengerInterface)Passengers_S.get(i) ;
                registry.bind("pass" +i, PI);
            }
            System.out.println("Passenger Registered....");
        } catch (AlreadyBoundException | RemoteException ex) {
            System.out.println("Exception occured, problem connecting RegisterPassenger.");
        }
    }

    public static MongoClient getMongoClient() {
        return mongoClient;
    }
    

    public static MongoCollection<Document> getPassengers() {
        return Passengers;
    }

    public static MongoCollection<Document> getBilligAccounts() {
        return BilligAccounts;
    }

    public static MongoCollection<Document> getFeedbacks() {
        return Feedbacks;
    }

    public static MongoCollection<Document> getGates() {
        return Gates;
    }

    public static MongoCollection<Document> getPlanes() {
        return Planes;
    }

    public static MongoCollection<Document> getPlaneSlots() {
        return PlaneSlots;
    }

    public static MongoCollection<Document> getManagmentEmployees() {
        return ManagmentEmployees;
    }

    public static MongoCollection<Document> getFlights() {
        return Flights;
    }

    public static MongoCollection<Document> getPilots() {
        return Pilots;
    }

    public static ArrayList<Passenger> getPassengers_S() {
        return Passengers_S;
    }

    public static ArrayList<BillingAccount> getBilligAccounts_S() {
        return BilligAccounts_S;
    }

    public static ArrayList<Feedback> getFeedbacks_S() {
        return Feedbacks_S;
    }

    public static ArrayList<Booking> getBookings_S() {
        return Bookings_S;
    }

    public static ArrayList<Gate> getGates_S() {
        return Gates_S;
    }

    public static ArrayList<Plane> getPlanes_S() {
        return Planes_S;
    }

    public static ArrayList<PlaneSlot> getPlaneSlots_S() {
        return PlaneSlots_S;
    }

    public static ArrayList<ManagementEmployee> getManagmentEmployees_S() {
        return ManagmentEmployees_S;
    }

    public static ArrayList<Flight> getFlights_S() {
        return Flights_S;
    }

    public static ArrayList<Pilot> getPilots_S() {
        return Pilots_S;
    }

    public static MongoCollection<Document> getBookings() {
        return Bookings;
    }

    
}
