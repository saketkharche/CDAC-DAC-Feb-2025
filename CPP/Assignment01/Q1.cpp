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
    // Constructor
    Student() : rollNumber(0), marks(0.0), grade('F') {}

    // Setter functions
    void setName(string n) {
        name = n;
    }

    void setRollNumber(int rn) {
        rollNumber = rn;
    }

    void setMarks(float m) {
        if (m >= 0 && m <= 100) {
            marks = m;
        } else {
            cout << "Invalid marks! Marks should be between 0 and 100." << endl;
            marks = 0;
        }
    }

    void setGrade(char g) {
        grade = g;
    }

    // Getter functions
    string getName() {
        return name;
    }

    int getRollNumber() {
        return rollNumber;
    }

    float getMarks() {
        return marks;
    }

    char getGrade() {
        return grade;
    }

    // Calculate grade based on marks
    void calculateGrade() {
        if (marks >= 90 && marks <= 100) {
            grade = 'A';
        } else if (marks >= 80 && marks < 90) {
            grade = 'B';
        } else if (marks >= 70 && marks < 80) {
            grade = 'C';
        } else if (marks >= 60 && marks < 70) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }
};

int main() {
    Student student;
    int choice;

    while (true) {
        cout << "\n=== Student Management System ===" << endl;
        cout << "1. Accept Information" << endl;
        cout << "2. Display Information" << endl;
        cout << "3. Calculate Grade" << endl;
        cout << "4. Exit" << endl;
        cout << "Enter your choice (1-4): ";
        cin >> choice;

        switch (choice) {
            case 1: {
                string name;
                int roll;
                float marks;

                cin.ignore(); // Clear input buffer
                cout << "Enter name: ";
                getline(cin, name);
                cout << "Enter roll number: ";
                cin >> roll;
                cout << "Enter marks: ";
                cin >> marks;

                student.setName(name);
                student.setRollNumber(roll);
                student.setMarks(marks);
                break;
            }

            case 2: {
                cout << "\nStudent Information:" << endl;
                cout << "Name: " << student.getName() << endl;
                cout << "Roll Number: " << student.getRollNumber() << endl;
                cout << "Marks: " << student.getMarks() << endl;
                cout << "Grade: " << student.getGrade() << endl;
                break;
            }

            case 3: {
                student.calculateGrade();
                cout << "Grade calculated: " << student.getGrade() << endl;
                break;
            }

            case 4: {
                cout << "Exiting program..." << endl;
                return 0;
            }

            default:
                cout << "Invalid choice! Please enter a number between 1 and 4." << endl;
        }
    }

    return 0;
}