/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS;

import AMS.Interfaces.SystemManagerInterface;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mahmo
 */
public class DB_SC_Manager {

    public DB_SC_Manager(){
        try {
            // My remote object [Skeleton]
            SystemManagerInterface sm = new SystemManager();
            // My RMI Registry
            Registry registry = LocateRegistry.createRegistry(1099);

            //Add my object to the RMI Registry
            registry.bind("ss", sm);
            System.out.println("My calculator is ready...");
        } catch (AlreadyBoundException | RemoteException ex) {
            System.out.println("Exception occured, problem connecting the server main.");
        }
        String connectionString = "mongodb+srv://Admin:ydv4FZVwlrw5fAOF@ams.ff92t.mongodb.net/<dbname>?retryWrites=true&w=majority";
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try {
            MongoClient mongoClient = new MongoClient(new MongoClientURI(connectionString));
            MongoIterable<String> mc = mongoClient.listDatabaseNames();
            MongoCursor<String> cursor = mc.cursor();
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        } catch (Exception ex) {
            System.out.println("Exception occured, Database connection Error");
        }
    }
    
    
}
