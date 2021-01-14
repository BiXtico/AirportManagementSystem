
package AMS.ResevationSubSystem;


public class BillingAccount {
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
    public void addBalance(double amountAdded){
      if(amountAdded> 0.0)
        this.balance += amountAdded;
    }
    public void subtractFromBalance (double amountSubtracted){
      if(amountSubtracted> 0.0)
       this.balance -= amountSubtracted;
    }
    
    
}
