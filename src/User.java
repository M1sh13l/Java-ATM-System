package JavaProject;

import java.util.ArrayList;
import java.util.List;

class User {
    private String userID;
    private String PIN;
    private List<Account> accounts;

    public User(String userID, String PIN) {
        this.userID = userID;
        this.PIN = PIN;
        this.accounts = new ArrayList<>();
    }

    public String getUserID() {
        return userID;
    }

    public boolean authenticate(String PIN) {
        return this.PIN.equals(PIN);
    }

    public void setPIN(String newPIN) {
        this.PIN = newPIN;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }
}
