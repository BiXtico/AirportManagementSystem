
package AMS.ResevationSubSystem;


public class BillingAccount {
    private int AccountID;
    private float balance;

    public BillingAccount() {
    }

    public BillingAccount(int AccountID, float balance) {
        this.AccountID = AccountID;
        this.balance = balance;
    }

    public int getAccountID() {
        return AccountID;
    }

    public float getBalance() {
        return balance;
    }

    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
    
    
}
