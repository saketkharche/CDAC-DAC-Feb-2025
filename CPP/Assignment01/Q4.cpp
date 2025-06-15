#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Employee {
private:
    int empID;
    string empName;
    double empSalary;
    double grossSalary;

public:
    Employee(int id, string name, double salary)
            : empID(id), empName(name), empSalary(salary), grossSalary(0) {}

    void setName(string name) { empName = name; }
    void setSalary(double salary) { empSalary = salary; }

    int getID() { return empID; }

    void calculateGrossSalary() {
        if (empSalary <= 5000) grossSalary = empSalary * 1.10;
        else if (empSalary <= 10000) grossSalary = empSalary * 1.15;
        else grossSalary = empSalary * 1.20;
        cout << "Gross Salary: " << grossSalary << endl;
    }

    void displayEmployeeDetails() {
        cout << "ID: " << empID << "\nName: " << empName
             << "\nSalary: " << empSalary << "\nGross Salary: " << grossSalary << endl;
    }
};

int main() {
    vector<Employee> employees;
    int choice;

    do {
        cout << "\n--- Employee Menu ---\n"
             << "1. Add Employee\n2. Calculate Gross Salary\n3. Display Details\n"
             << "4. Update Info\n5. Exit\nEnter choice: ";
        cin >> choice;
        switch (choice) {
            case 1: {
                int id;
                string name;
                double salary;
                cout << "Enter ID: "; cin >> id;
                cout << "Enter Name: "; cin.ignore(); getline(cin, name);
                cout << "Enter Salary: "; cin >> salary;
                employees.emplace_back(id, name, salary);
                break;
            }
            case 2: {
                int id;
                cout << "Enter ID to calculate gross: ";
                cin >> id;
                for (auto& emp : employees) {
                    if (emp.getID() == id) {
                        emp.calculateGrossSalary();
                    }
                }
                break;
            }
            case 3:
                for (auto& emp : employees)
                    emp.displayEmployeeDetails();
                break;
            case 4: {
                int id;
                cout << "Enter ID to update: ";
                cin >> id;
                for (auto& emp : employees) {
                    if (emp.getID() == id) {
                        string name;
                        double salary;
                        cout << "Enter new name: "; cin.ignore(); getline(cin, name);
                        cout << "Enter new salary: "; cin >> salary;
                        emp.setName(name);
                        emp.setSalary(salary);
                        cout << "Employee updated.\n";
                    }
                }
                break;
            }
            case 5:
                cout << "Exiting Payroll System.\n";
                break;
            default:
                cout << "Invalid choice.\n";
        }
    } while (choice != 5);

    return 0;
}
