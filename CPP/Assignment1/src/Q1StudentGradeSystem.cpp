#include <iostream>
#include <string>
using namespace std;

class Student {
private:
    string name;
    int rollNumber;
    float marks;
    char grade;

public:
    void setName(string n) { name = n; }
    void setRollNumber(int r) { rollNumber = r; }
    void setMarks(float m) { marks = m; }
    void setGrade(char g) { grade = g; }

    string getName() { return name; }
    int getRollNumber() { return rollNumber; }
    float getMarks() { return marks; }
    char getGrade() { return grade; }

    void calculateGrade() {
        if (marks >= 90) grade = 'A';
        else if (marks >= 80) grade = 'B';
        else if (marks >= 70) grade = 'C';
        else if (marks >= 60) grade = 'D';
        else grade = 'F';
        cout << "Grade calculated successfully.\n";
    }

    void displayInfo() {
        cout << "Name: " << name << "\nRoll No: " << rollNumber
             << "\nMarks: " << marks << "\nGrade: " << grade << endl;
    }
};

int main() {
    Student s;
    int choice;
    do {
        cout << "\n--- Student Menu ---\n1. Accept Information\n2. Display Information\n3. Calculate Grade\n4. Exit\nEnter choice: ";
        cin >> choice;
        switch (choice) {
        case 1:
            {
                string n;
                int r;
                float m;
                cout << "Enter Name: ";
                cin.ignore(); getline(cin, n);
                cout << "Enter Roll Number: "; cin >> r;
                cout << "Enter Marks: "; cin >> m;
                s.setName(n); s.setRollNumber(r); s.setMarks(m);
            }
            break;
        case 2: s.displayInfo(); break;
        case 3: s.calculateGrade(); break;
        case 4: cout << "Exiting...\n"; break;
        default: cout << "Invalid choice.\n";
        }
    } while (choice != 4);
    return 0;
}
