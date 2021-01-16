/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS;

import java.io.Serializable;

/**
 *
 * @author mahmo
 */
public class User implements Serializable  {

    private int userID, age, SSN;
    private String username, email;

    public User() {

    }

    public int getUserID() {
        return userID;
    }

    public int getAge() {
        return age;
    }

    public int getSSN() {
        return SSN;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(int userID, int age, int SSN, String username, String email) {
        this.userID = userID;
        this.age = age;
        this.SSN = SSN;
        this.username = username;
        this.email = email;
    }

}
