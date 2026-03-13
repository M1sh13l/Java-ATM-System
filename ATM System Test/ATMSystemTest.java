package JavaProject;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class ATMSystemTest extends JFrame {
    private ATM atm;

    public ATMSystemTest() {
        atm = new ATM();

        // Initialize sample data
        User user1 = new User("123", "1111");
        user1.addAccount(new CheckingAccount("1001", 5000, "John Doe", 1000));
        atm.addUser(user1);

        setupUI();
    }

    private void setupUI() {
        setTitle("ATM System");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome to the ATM System", SwingConstants.CENTER);
        add(welcomeLabel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        JButton loginButton = new JButton("Login");
        JButton adminButton = new JButton("Admin Panel");
        JButton exitButton = new JButton("Exit");

        mainPanel.add(loginButton);
        mainPanel.add(adminButton);
        mainPanel.add(exitButton);

        add(mainPanel, BorderLayout.CENTER);

        // Button Actions
        loginButton.addActionListener(e -> showLoginScreen());
        adminButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Admin Panel Coming Soon!"));
        exitButton.addActionListener(e -> System.exit(0));
    }

    private void showLoginScreen() {
        JPanel loginPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JTextField userIDField = new JTextField();
        JPasswordField pinField = new JPasswordField();

        loginPanel.add(new JLabel("User ID:"));
        loginPanel.add(userIDField);
        loginPanel.add(new JLabel("PIN:"));
        loginPanel.add(pinField);

        int option = JOptionPane.showConfirmDialog(this, loginPanel, "Login", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String userID = userIDField.getText();
            String PIN = new String(pinField.getPassword());

            User loggedInUser = atm.login(userID, PIN);
            if (loggedInUser != null) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                showUserMenu(loggedInUser);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showUserMenu(User user) {
        JFrame userMenuFrame = new JFrame("User Menu");
        userMenuFrame.setSize(400, 300);
        userMenuFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        userMenuFrame.setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome, " + user.getUserID(), SwingConstants.CENTER);
        userMenuFrame.add(welcomeLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton viewTransactionsButton = new JButton("View Transactions");
        JButton logoutButton = new JButton("Logout");

        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(viewTransactionsButton);
        buttonPanel.add(logoutButton);

        userMenuFrame.add(buttonPanel, BorderLayout.CENTER);

        // Button Actions
        depositButton.addActionListener(e -> performTransaction(user, "deposit"));
        withdrawButton.addActionListener(e -> performTransaction(user, "withdraw"));
        viewTransactionsButton.addActionListener(e -> viewTransactions(user));
        logoutButton.addActionListener(e -> userMenuFrame.dispose());

        userMenuFrame.setVisible(true);
    }

    private void performTransaction(User user, String type) {
        Account account = user.getAccounts().get(0); // Assuming a single account for simplicity
        String input = JOptionPane.showInputDialog(this, "Enter amount for " + type + ":");
        if (input != null && !input.isEmpty()) {
            try {
                double amount = Double.parseDouble(input);
                atm.performTransaction(account, type, amount);
                JOptionPane.showMessageDialog(this, "Transaction successful!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid amount!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void viewTransactions(User user) {
        List<Transaction> transactions = atm.viewTransactionHistory(user);
        StringBuilder details = new StringBuilder("Transaction History:\n");
        for (Transaction t : transactions) {
            details.append(t.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(this, details.toString(), "Transactions", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ATMSystemTest system = new ATMSystemTest();
            system.setVisible(true);
        });
    }
}
