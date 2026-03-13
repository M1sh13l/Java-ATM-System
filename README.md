# Java ATM System

## Overview
This project is a Java-based ATM System developed as part of an Object-Oriented Programming project.

The system simulates core ATM operations such as user login, account management, deposits, withdrawals, and transaction history tracking. It also includes an admin component for managing users and generating reports.

The project demonstrates the use of object-oriented programming principles through a modular class-based design, and it provides a simple graphical interface using Java Swing.

---

## Features
- User login with ID and PIN
- Deposit money into an account
- Withdraw money from an account
- View transaction history
- Support for different account types:
  - Checking Account
  - Savings Account
- Admin functionality for:
  - Adding users
  - Creating accounts
  - Resetting user PINs
  - Generating reports
- Java Swing graphical user interface

---

## Technologies Used
- **Programming Language:** Java
- **GUI Framework:** Java Swing
- **Concepts:** Object-Oriented Programming (OOP)

---

## OOP Concepts Demonstrated
- Classes and Objects
- Encapsulation
- Inheritance
- Abstract Classes
- Method Overriding
- Modular Design

---

## Project Structure
```
JavaProject/
│
├── Account.java
├── Admin.java
├── ATM.java
├── ATMSystemTest.java
├── CheckingAccount.java
├── SavingsAccount.java
├── Transaction.java
├── User.java
└── README.md
```

---

## File Descriptions
- **Account.java** → Abstract base class for bank accounts
- **CheckingAccount.java** → Checking account implementation with overdraft support
- **SavingsAccount.java** → Savings account implementation with interest calculation
- **User.java** → Represents system users and stores their accounts
- **Transaction.java** → Stores transaction details such as amount, type, and timestamp
- **ATM.java** → Core ATM logic including login and transaction handling
- **Admin.java** → Admin operations such as user management and report generation
- **ATMSystemTest.java** → Main GUI application using Java Swing

---

## How to Run
1. Clone the repository:

```bash
git clone https://github.com/M1sh13l/Java-ATM-System.git
```

2. Open the project in any Java IDE such as:
   - IntelliJ IDEA
   - Eclipse
   - VS Code

3. Make sure all `.java` files are inside the same package/folder.

4. Run:

```bash
ATMSystemTest.java
```

This will launch the ATM System GUI.

---

## Example Functionality
A user can:
- Log in using a user ID and PIN
- Access their account
- Deposit money
- Withdraw money
- View previous transactions

The admin can:
- Add users
- Create accounts
- Reset PINs
- Generate transaction reports

---

## Learning Objectives
This project was created to practice:
- Designing systems using OOP principles
- Building Java applications with multiple interacting classes
- Creating a simple GUI with Java Swing
- Managing account and transaction logic in a modular way

---

## Notes
- This project is a simulation and does not connect to a real banking database.
- The admin panel interface is currently marked as “coming soon” in the GUI.
- Sample user data is initialized in the main application for testing.

---

## Author
Computer Science Student – Effat University

---

## License
This project is for educational purposes only.
