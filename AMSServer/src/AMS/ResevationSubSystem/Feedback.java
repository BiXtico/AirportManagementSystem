/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.ResevationSubSystem;

import AMS.DB_SC_Manager;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import org.bson.Document;


public class Feedback implements Serializable {
int feedbackID;
String description;
int rating;

    public Feedback() throws RemoteException{
        UnicastRemoteObject.exportObject((Remote) this, 0);
    }

    public Feedback(String description, int rating) {
        this.feedbackID = DB_SC_Manager.getID_Counter();
        this.description = description;
        this.rating = rating;
        Document doc = new Document("feedbackID", this.feedbackID)
                .append("description", description)
                .append("rating", rating);

        DB_SC_Manager.getFeedbacks().insertOne(doc);
        DB_SC_Manager.getFeedbacks_S().add(this);
        int count = DB_SC_Manager.getID_Counter()+1;
        DB_SC_Manager.setID_Counter(count);
        
    }

    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
}
