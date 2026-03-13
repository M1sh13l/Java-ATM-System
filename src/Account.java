package JavaProject;

import java.util.ArrayList;
import java.util.List;

abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected String accountHolderName;
    protected List<Transaction> transactions;  // Store account-specific transactions


    public Account(String accountNumber, double balance, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolderName = accountHolderName;
        this.transactions = new ArrayList<>();

    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;  // Method to retrieve transactions
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);  // Add a transaction to the account
    }

    public abstract void deposit(double amount);

    public abstract boolean withdraw(double amount);
}