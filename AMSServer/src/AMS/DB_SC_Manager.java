/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS;

import AMS.Interfaces.PassengerInterface;
import AMS.ResevationSubSystem.Passenger;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author mahmo
 */
public class DB_SC_Manager {
    
     private static MongoClient mongoClient;

    
    public DB_SC_Manager(){
        String connectionString = "mongodb+srv://Admin:ydv4FZVwlrw5fAOF@ams.ff92t.mongodb.net/<dbname>?retryWrites=true&w=majority";
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try {
            mongoClient = new MongoClient(new MongoClientURI(connectionString));
            MongoIterable<String> mc = mongoClient.listDatabaseNames();
            MongoCursor<String> cursor = mc.cursor();
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        } catch (Exception ex) {
            System.out.println("Exception occured, Database connection Error");
        }
    }
    
    public void RegisterPassenger(){
         try {
            // My remote object [Skeleton]
            PassengerInterface PI = (PassengerInterface) new Passenger();
            // My RMI Registry
            Registry registry = LocateRegistry.createRegistry(1099);

            //Add my object to the RMI Registry
            registry.bind("Passenger", PI);
            System.out.println("Passenger Registered....");
        } catch (AlreadyBoundException | RemoteException ex) {
            System.out.println("Exception occured, problem connecting RegisterPassenger.");
        }
    }
    public static MongoClient getMongoClient() {
        return mongoClient;
    }
    
    
    
}
