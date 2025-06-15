#include <iostream>
#include <string>
using namespace std;

class BankAccount {
private:
    int accountNumber;
    string accountHolderName;
    double balance;

public:
    void setAccountNumber(int num) { accountNumber = num; }
    void setHolderName(string name) { accountHolderName = name; }
    void setBalance(double bal) { balance = bal; }

    int getAccountNumber() { return accountNumber; }
    string getHolderName() { return accountHolderName; }
    double getBalance() { return balance; }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            cout << "Amount deposited successfully.\n";
        }
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            cout << "Withdrawal successful.\n";
        } else {
            cout << "Insufficient balance!\n";
        }
    }

    void displayAccountDetails() {
        cout << "Account No: " << accountNumber
             << "\nName: " << accountHolderName
             << "\nBalance: $" << balance << endl;
    }
};

int main() {
    BankAccount acc;
    acc.setAccountNumber(101); // Assuming single account
    acc.setHolderName("John Doe");
    acc.setBalance(1000.00);

    int choice;
    double amt;

    do {
        cout << "\n--- Bank Menu ---\n1. Deposit\n2. Withdraw\n3. Display Details\n4. Exit\nEnter choice: ";
        cin >> choice;
        switch (choice) {
            case 1:
                cout << "Enter amount to deposit: ";
                cin >> amt;
                acc.deposit(amt);
                break;
            case 2:
                cout << "Enter amount to withdraw: ";
                cin >> amt;
                acc.withdraw(amt);
                break;
            case 3:
                acc.displayAccountDetails();
                break;
            case 4:
                cout << "Thank you for banking with us.\n";
                break;
            default:
                cout << "Invalid choice!\n";
        }
    } while (choice != 4);
    return 0;
}
