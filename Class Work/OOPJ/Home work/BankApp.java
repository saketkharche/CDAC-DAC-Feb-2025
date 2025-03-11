import java.util.Scanner;

// Interface for bank services
interface BankServices {
    void deposit(double amount);
    void withdraw(double amount);
    void checkBalance();
}

// Abstract class for Bank Account
abstract class BankAccount implements BankServices {
    String accountHolder;
    String accountNumber;
    double balance;

    // Constructor
    public BankAccount(String holder, String accNumber, double initialBalance) {
        this.accountHolder = holder;
        this.accountNumber = accNumber;
        this.balance = initialBalance;
    }

    // Abstract method to display account details
    abstract void displayAccountDetails();

    // Common method for deposit
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }

    // Common method for withdraw
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal failed.");
        } else {
            System.out.println("Invalid amount. Withdrawal failed.");
        }
    }

    // Common method to check balance
    @Override
    public void checkBalance() {
        System.out.println("Available balance: ₹" + balance);
    }
}

// Subclass SavingsAccount inheriting from BankAccount
class SavingsAccount extends BankAccount {

    // Constructor
    public SavingsAccount(String holder, String accNumber, double initialBalance) {
        super(holder, accNumber, initialBalance);
    }

    // Implement abstract method
    @Override
    void displayAccountDetails() {
        System.out.println("===== Account Details =====");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: Savings");
        System.out.println("Balance: ₹" + balance);
    }
}

// Driver class
public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SavingsAccount account = null;
        boolean exit = false;

        while (!exit) {
            // Display menu
            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    if (account == null) {
                        System.out.print("Enter Account Holder Name: ");
                        String holder = sc.nextLine();
                        System.out.print("Enter Account Number: ");
                        String accNumber = sc.nextLine();
                        System.out.print("Enter Initial Balance: ");
                        double initialBalance = sc.nextDouble();

                        account = new SavingsAccount(holder, accNumber, initialBalance);
                        System.out.println("Account created successfully!");
                    } else {
                        System.out.println("Account already exists!");
                    }
                    break;

                case 2:
                    if (account != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Please create an account first!");
                    }
                    break;

                case 3:
                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        account.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Please create an account first!");
                    }
                    break;

                case 4:
                    if (account != null) {
                        account.checkBalance();
                    } else {
                        System.out.println("Please create an account first!");
                    }
                    break;

                case 5:
                    if (account != null) {
                        account.displayAccountDetails();
                    } else {
                        System.out.println("Please create an account first!");
                    }
                    break;

                case 6:
                    System.out.println("Exiting... Thank you for using the system!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        sc.close();
    }
}
