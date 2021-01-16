/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.DataModels;

import java.io.Serializable;

/**
 *
 * @author mahmo
 */
public class Feedback implements Serializable {

    int feedbackID;
    String description;
    int rating;

    public Feedback() {
    }

    public Feedback(int feedbackID, String description, int rating) {
        this.feedbackID = feedbackID;
        this.description = description;
        this.rating = rating;
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
