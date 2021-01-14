/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS;

/**
 *
 * @author mahmo
 */
public class User  {

    private int userID,age,SSN;
    private String username,email;

    public User() {
        
    }

    public User(int userID, int age, int SSN, String username, String email) { 
        this.userID = userID;
        this.age = age;
        this.SSN = SSN;
        this.username = username;
        this.email = email;
    }
    
    public User (String username, int SSN){
      this.username= username;
      this.SSN = SSN;
    }
    
    
}
