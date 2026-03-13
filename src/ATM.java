package JavaProject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class ATM {
    private List<User> users;
    private List<Transaction> transactions;

    public ATM() {
        users = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User login(String userID, String PIN) {
        for (User user : users) {
            if (userID.equals(user.getUserID()) && user.authenticate(PIN)) {
                return user;
            }
        }
        return null;
    }

    public void performTransaction(Account account, String type, double amount) {
        String transactionID = UUID.randomUUID().toString();
        String timestamp = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.util.Date());
        boolean success = false;

        if (type.equalsIgnoreCase("deposit")) {
            account.deposit(amount);
            success = true;
        } else if (type.equalsIgnoreCase("withdraw")) {
            success = account.withdraw(amount);
        }

        if (success) {
            transactions.add(new Transaction(transactionID, account.accountNumber, amount, type, timestamp));
        } else {
            throw new IllegalArgumentException("Transaction failed: Insufficient funds or invalid operation.");
        }
    }

    public List<Transaction> viewTransactionHistory(User user) {
        List<Transaction> userTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            for (Account account : user.getAccounts()) {
                if (transaction.getAccountNumber().equals(account.accountNumber)) {
                    userTransactions.add(transaction);
                }
            }
        }
        return userTransactions;
    }
}
