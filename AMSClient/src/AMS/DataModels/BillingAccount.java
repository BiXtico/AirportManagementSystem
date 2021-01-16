
package AMS.DataModels;

import java.io.Serializable;



public class BillingAccount implements Serializable {
    private int AccountID;
    private double balance;

    public BillingAccount() {
    }

    public BillingAccount(int AccountID, double balance) {
        this.AccountID = AccountID;
        this.balance = balance;
    }

    public int getAccountID() {
        return AccountID;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
}
