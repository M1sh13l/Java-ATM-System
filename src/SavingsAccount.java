package JavaProject;

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, String accountHolderName, double interestRate) {
        super(accountNumber, balance, accountHolderName);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double calculateInterest() {
        return balance * interestRate;
    }
}
