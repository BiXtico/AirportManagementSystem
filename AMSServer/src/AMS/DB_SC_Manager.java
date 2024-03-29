/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS;

import AMS.FlightManagementSubSystem.Flight;
import AMS.FlightManagementSubSystem.ManagementEmployee;
import AMS.FlightManagementSubSystem.Pilot;
import AMS.Interfaces.AdminInterface;
import AMS.Interfaces.ManagementEmployeeInterface;
import AMS.Interfaces.PassengerInterface;
import AMS.Interfaces.SystemManagerInterface;
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
import static com.mongodb.client.model.Filters.in;
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
    private static int ID_Counter;
    private static int ID_Counter_ID;
    private static Admin Admin_S;

    private static MongoClient mongoClient;
    private static MongoCollection<Document> IDCounter;
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
    private static Document Admins;

    public DB_SC_Manager() throws RemoteException {
        String connectionString = "mongodb+srv://Admin:ydv4FZVwlrw5fAOF@ams.ff92t.mongodb.net/<dbname>?retryWrites=true&w=majority";
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try {
            mongoClient = new MongoClient(new MongoClientURI(connectionString));
            IDCounter = DB_SC_Manager.getMongoClient().getDatabase("AMS").getCollection("IDCounter");
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
        Admin_S = null;
    }

    public static void UpdatePassengers() throws RemoteException {
        List<Integer> bb = new ArrayList<>();
        for (Passenger p : Passengers_S) {
            bb.clear();
            Passengers.findOneAndUpdate(new Document("userID", p.getUserID()), set("status", p.getStatus()));
            Passengers.findOneAndUpdate(new Document("userID", p.getUserID()), set("age", p.getAge()));
            Passengers.findOneAndUpdate(new Document("userID", p.getUserID()), set("SSN", p.getSSN()));
            Passengers.findOneAndUpdate(new Document("userID", p.getUserID()), set("nationality", p.getNationality()));
            Passengers.findOneAndUpdate(new Document("userID", p.getUserID()), set("AccountID", p.getBillingAcc().getAccountID()));
            for (Booking b : p.getBookings()) {
                bb.add(b.getBookingID());
            }
            Passengers.findOneAndUpdate(new Document("bookings", p.getUserID()), set("bookings", bb));
        }
    }

    public static void removeFlight(int id) throws RemoteException {
        Flights.deleteMany(in("flightID", id));
    }

    public static void removeBooking(int id) throws RemoteException {
        Bookings.deleteMany(in("bookingID", id));
    }

    public static void removeBooking(String des) throws RemoteException {
        Bookings.deleteMany(in("Destination", des));
    }

    public static void removeManagementEmployee(int id) throws RemoteException {
        ManagmentEmployees.deleteMany(in("userID", id));
    }

    public static void readFlights() throws RemoteException {
        Flight f = new Flight();
        Plane plane = new Plane();
        Gate gate = new Gate();
        Pilot pilot = new Pilot();
        ArrayList<Booking> B = new ArrayList<>();
        ArrayList<Feedback> feedbackList = new ArrayList<>();
        int PI = 0;
        int GI = 0;
        int pilotID = 0;
        try {
            ArrayList<Document> docs = Flights.find().into(new ArrayList<>());
            for (Document i : docs) {
                B.clear();
                feedbackList.clear();
                f.setAirline(i.getString("airline"));
                f.setDepartureDate(i.getString("departureDate"));
                f.setDepartureTime(i.getString("departureTime"));
                f.setDestination(i.getString("destination"));
                f.setFlightID(i.getInteger("flightID"));
                f.setGate(gate);
                f.setPilot(pilot);
                f.setPlane(plane);
                PI = i.getInteger("planeID");
                GI = i.getInteger("gateID");
                pilotID = i.getInteger("pilotID");
                for (Plane p : Planes_S) {
                    if (p.getPlaneID() == PI) {
                        plane = p;
                        break;
                    }
                }
                for (Gate g : Gates_S) {
                    if (g.getGateNum() == GI) {
                        gate = g;
                        break;
                    }
                }
                for (Pilot P : Pilots_S) {
                    if (P.getPilotID() == pilotID) {
                        pilot = P;
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
                List<Integer> feed = (List<Integer>) i.get("feedbackList");
                for (int j : feed) {
                    for (Feedback F : Feedbacks_S) {
                        if (F.getFeedbackID() == j) {
                            feedbackList.add(F);
                            break;
                        }
                    }
                }
                f.setPlane(plane);
                f.setGate(gate);
                f.setPilot(pilot);
                f.setBookings(B);
                f.setFeedbackList(feedbackList);
                Flights_S.add(f);
            }
        } catch (RemoteException ex) {
            System.out.print("Error reading files form mongoose");
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
                B.clear();
                p.setUserID(i.getInteger("userID"));
                p.setAge(i.getInteger("age"));
                p.setSSN(i.getInteger("SSN"));
                p.setStatus(i.getString("status"));
                p.setUsername(i.getString("username"));
                p.setNationality(i.getString("nationality"));
                AI = i.getInteger("AccountID");
                for (BillingAccount b : BilligAccounts_S) {
                    if (b.getAccountID() == AI) {
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

    public static void UpdateFlights() throws RemoteException {
        List<Integer> bb = new ArrayList<>();
        List<Integer> fb = new ArrayList<>();
        for (Flight f : Flights_S) {
            bb.clear();
            fb.clear();
            Flights.findOneAndUpdate(new Document("flightID", f.getFlightID()), set("airline", f.getAirline()));
            Flights.findOneAndUpdate(new Document("flightID", f.getFlightID()), set("departureDate", f.getDepartureDate()));
            Flights.findOneAndUpdate(new Document("flightID", f.getFlightID()), set("departureTime", f.getDepartureTime()));
            Flights.findOneAndUpdate(new Document("flightID", f.getFlightID()), set("destination", f.getDestination()));
            Flights.findOneAndUpdate(new Document("flightID", f.getFlightID()), set("planeID", f.getPlane().getPlaneID()));
            Flights.findOneAndUpdate(new Document("flightID", f.getFlightID()), set("pilotID", f.getPilot().getPilotID()));
            Flights.findOneAndUpdate(new Document("flightID", f.getFlightID()), set("gateID", f.getGate().getGateNum()));
            for (Booking b : f.getBookings()) {
                bb.add(b.getBookingID());
            }
            for (Feedback ff : f.getFeedbackList()) {
                fb.add(ff.getFeedbackID());
            }
            Flights.findOneAndUpdate(new Document("bookings", f.getFlightID()), set("bookings", bb));
            Flights.findOneAndUpdate(new Document("feedbackList", f.getFlightID()), set("feedbackList", fb));
        }
    }

    public static void readGates() throws RemoteException {
        Gate g = new Gate();
        try {
            ArrayList<Document> docs = Gates.find().into(new ArrayList<>());
            for (Document i : docs) {
                g.setGateNum(i.getInteger("gateNum"));
                g.setIsAvailable(i.getBoolean("isAvailable"));
                Gates_S.add(g);
            }
        } catch (RemoteException ex) {
            System.out.print("Error reading files form mongoose");
        }
    }

    public static void UpdateGates() throws RemoteException {
        for (Gate g : Gates_S) {
            Gates.findOneAndUpdate(new Document("gateNum", g.getGateNum()), set("isAvailable", g.isIsAvailable()));
        }
    }

    public static void readCounter() throws RemoteException {
        Document document = (Document) IDCounter;
        ID_Counter_ID = document.getInteger("IDCounter_ID");
        ID_Counter = document.getInteger("IDCounter");
    }

    public static void UpdateCounter() throws RemoteException {
        IDCounter.findOneAndUpdate(new Document("ID_Counter_ID", ID_Counter_ID), set("counter", ID_Counter));
    }

    public void RegisterPassenger() {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            // My remote object [Skeleton]
            for (int i = 0; i < Passengers_S.size(); i++) {
                PassengerInterface PI = (PassengerInterface) Passengers_S.get(i);
                registry.bind("pass" + i, PI);
            }
            System.out.println("Passenger Registered....");
        } catch (AlreadyBoundException | RemoteException ex) {
            System.out.println("Exception occured, problem connecting RegisterPassenger.");
        }
    }

    public void RegisterManagementEmployee() {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            // My remote object [Skeleton]
            for (int i = 0; i < ManagmentEmployees_S.size(); i++) {
                ManagementEmployeeInterface M = (ManagementEmployeeInterface) ManagmentEmployees_S.get(i);
                registry.bind("MEmployee" + i, M);
            }
            System.out.println("Management Employee Registered....");
        } catch (AlreadyBoundException | RemoteException ex) {
            System.out.println("Exception occured, problem connecting RegisterFlight.");
        }
    }

    public static void readManagementEmployees() throws RemoteException {
        ManagementEmployee M = new ManagementEmployee();
        ArrayList<Document> docs = ManagmentEmployees.find().into(new ArrayList<>());
        for (Document i : docs) {
            M.setUserID(i.getInteger("userID"));
            M.setAge(i.getInteger("age"));
            M.setSSN(i.getInteger("SSN"));
            M.setUsername(i.getString("username"));
            M.setEmail(i.getString("email"));
            M.setSalary(i.getDouble("salary"));

        }
        ManagmentEmployees_S.add(M);
    }

    public static void UpdateManagementEmployees() throws RemoteException {
        for (ManagementEmployee M : ManagmentEmployees_S) {
            ManagmentEmployees.findOneAndUpdate(new Document("userID", M.getUserID()), set("age", M.getAge()));
            ManagmentEmployees.findOneAndUpdate(new Document("userID", M.getUserID()), set("SSN", M.getSSN()));
            ManagmentEmployees.findOneAndUpdate(new Document("userID", M.getUserID()), set("username", M.getUsername()));
            ManagmentEmployees.findOneAndUpdate(new Document("userID", M.getUserID()), set("email", M.getEmail()));
            ManagmentEmployees.findOneAndUpdate(new Document("userID", M.getUserID()), set("salary", M.getSalary()));
        }
    }

    //////////////////////UpdatePilot//////////////////////////
    public static void UpdatePilots() throws RemoteException {
        for (Pilot p : Pilots_S) {
            Pilots.findOneAndUpdate(new Document("pilotID", p.getPilotID()), set("name", p.getName()));
            Pilots.findOneAndUpdate(new Document("pilotID", p.getPilotID()), set("isAvailable", p.isIsAvailable()));
        }
    }

    //////////////////////ReadPilot//////////////////////////
    public static void readPilots() throws RemoteException {
        Pilot p = new Pilot();

        ArrayList<Document> docs = Pilots.find().into(new ArrayList<>());
        for (Document i : docs) {
            p.setPilotID(i.getInteger("pilotID"));
            p.setName(i.getString("name"));
            p.setIsAvailable(i.getBoolean("isAvailable"));
            Pilots_S.add(p);
        }
    }

    public static void readPlanes() throws RemoteException {
        Plane p = new Plane();
        PlaneSlot slot = new PlaneSlot();
        int SI = 0;
        ArrayList<Document> docs = Planes.find().into(new ArrayList<>());
        for (Document i : docs) {
            p.setPlaneID(i.getInteger("planeID"));
            p.setPlaneCapacity(i.getInteger("planeCapacity"));
            p.setSlot(slot);

            for (PlaneSlot P : PlaneSlots_S) {
                if (P.getSlotID() == SI) {
                    slot = P;
                    break;
                }
            }
            p.setSlot(slot);
            Planes_S.add(p);
        }
    }

    public static void UpdatePlanes() throws RemoteException {
        for (Plane P : Planes_S) {
            Planes.findOneAndUpdate(new Document("planeID", P.getPlaneID()), set("planeCapacity", P.getPlaneCapacity()));
            Planes.findOneAndUpdate(new Document("planeID", P.getPlaneID()), set("slotID", P.getSlot().getSlotID()));

        }
    }

    public static void readPlaneSlots() throws RemoteException {
        PlaneSlot slot = new PlaneSlot();
        ArrayList<Document> docs = PlaneSlots.find().into(new ArrayList<>());
        for (Document i : docs) {
            slot.setSlotID(i.getInteger("slotID"));
            slot.setIsAvailable(i.getBoolean("isAvailable"));

            PlaneSlots_S.add(slot);
        }
    }

    public static void UpdatePlaneSlots() throws RemoteException {

        for (PlaneSlot S : PlaneSlots_S) {
            PlaneSlots.findOneAndUpdate(new Document("slotID", S.getSlotID()), set("isAvailable", S.isIsAvailable()));
        }
    }

    public static void readBillingAccounts() throws RemoteException {
        BillingAccount B = new BillingAccount();
        ArrayList<Document> docs = BilligAccounts.find().into(new ArrayList<>());
        for (Document i : docs) {
            B.setAccountID(i.getInteger("AccountID"));
            B.setBalance(i.getDouble("balance"));

            BilligAccounts_S.add(B);
        }
    }

    public static void UpdateBillingAccounts() throws RemoteException {

        for (BillingAccount B : BilligAccounts_S) {
            BilligAccounts.findOneAndUpdate(new Document("AccountID", B.getAccountID()), set("balance", B.getBalance()));
        }
    }

    public static void readBookings() throws RemoteException {
        Booking B = new Booking();
        ArrayList<Document> docs = Bookings.find().into(new ArrayList<>());
        for (Document i : docs) {
            B.setBookingID(i.getInteger("bookingID"));
            B.setNumofseats(i.getInteger("numofseats"));
            B.setDestination(i.getString("Destination"));
            B.setBookingDate(i.getString("bookingDate"));

            Bookings_S.add(B);
        }
    }

    public static void UpdateBookings() throws RemoteException {

        for (Booking B : Bookings_S) {
            Bookings.findOneAndUpdate(new Document("bookingID", B.getBookingID()), set("numofseats", B.getNumofseats()));
            Bookings.findOneAndUpdate(new Document("bookingID", B.getBookingID()), set("Destination", B.getDestination()));
            Bookings.findOneAndUpdate(new Document("bookingID", B.getBookingID()), set("bookingDate", B.getBookingDate()));
        }
    }

    public static void readFeedbacks() throws RemoteException {
        Feedback f = new Feedback();
        ArrayList<Document> docs = Feedbacks.find().into(new ArrayList<>());
        for (Document i : docs) {
            f.setFeedbackID(i.getInteger("feedbackID"));
            f.setDescription(i.getString("description"));
            f.setRating(i.getInteger("rating"));

            Feedbacks_S.add(f);
        }
    }

    public static void UpdateFeedbacks() throws RemoteException {

        for (Feedback F : Feedbacks_S) {
            Feedbacks.findOneAndUpdate(new Document("feedbackID", F.getFeedbackID()), set("description", F.getDescription()));
            Feedbacks.findOneAndUpdate(new Document("feedbackID", F.getFeedbackID()), set("rating", F.getRating()));
        }
    }

    public static void readAdmins() throws RemoteException {
        Admin A = Admin.getInstance();
        Document doc = Admins;

        A.setUserID(doc.getInteger("userID"));
        A.setAge(doc.getInteger("age"));
        A.setSSN(doc.getInteger("SSN"));
        A.setUsername(doc.getString("username"));
        A.setEmail(doc.getString("email"));

        Admin_S = A;
    }

    public void RegisterSystemManager() throws AlreadyBoundException {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            // My remote object [Skeleton]
            SystemManagerInterface PI = new SystemManager();
            registry.bind("SM", PI);
            System.out.println("System Manager Registered....");
        } catch (RemoteException ex) {
            System.out.println("Exception occured, problem connecting RegisterSystemManager.");
        }
    }
    
     public void RegisterAdmin() throws AlreadyBoundException {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            // My remote object [Skeleton]
            AdminInterface PI = Admin.getInstance();
            registry.bind("Admin", PI);
            System.out.println("System Manager Registered....");
        } catch (RemoteException ex) {
            System.out.println("Exception occured, problem connecting RegisterSystemManager.");
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

    public static int getID_Counter() {
        return ID_Counter;
    }

    public static int getID_Counter_ID() {
        return ID_Counter_ID;
    }

    public static MongoCollection<Document> getIDCounter() {
        return IDCounter;
    }

    public static void setID_Counter(int ID_Counter) {
        DB_SC_Manager.ID_Counter = ID_Counter;
    }

}
