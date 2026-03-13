package JavaProject;

class Transaction {
    private String transactionID;
    private String accountNumber;
    private double amount;
    private String transactionType;
    private String timestamp;

    public Transaction(String transactionID, String accountNumber, double amount, String transactionType, String timestamp) {
        this.transactionID = transactionID;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionType = transactionType;
        this.timestamp = timestamp;
    }

    public String getTransactionType() {
        return transactionType;
    }

    

    public String getTransactionID() {
        return transactionID;
    }

    public double getAmount() {
        return amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "TransactionID: " + transactionID + ", Account: " + accountNumber + 
               ", Amount: " + amount + ", Type: " + transactionType + 
               ", Timestamp: " + timestamp;
    }
}
