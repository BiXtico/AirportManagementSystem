package AMS.ResevationSubSystem;

import AMS.DB_SC_Manager;
import java.io.Serializable;
import org.bson.Document;

public class BillingAccount implements Serializable {

    private int AccountID;
    private double balance;

    public BillingAccount() {
    }

    public BillingAccount(double balance) {
        this.AccountID = DB_SC_Manager.getID_Counter();
        this.balance = balance;
        Document doc = new Document("AccountID", this.AccountID)
                .append("balance", balance);

        DB_SC_Manager.getBilligAccounts().insertOne(doc);
        DB_SC_Manager.getBilligAccounts_S().add(this);
        int count = DB_SC_Manager.getID_Counter() + 1;
        DB_SC_Manager.setID_Counter(count);
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

    public void addBalance(double amountAdded) {
        if (amountAdded > 0.0) {
            this.balance += amountAdded;
        }
    }

    public void subtractFromBalance(double amountSubtracted) {
        if (amountSubtracted > 0.0) {
            this.balance -= amountSubtracted;
        }
    }
}
