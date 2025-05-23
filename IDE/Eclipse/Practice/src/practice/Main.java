package practice;

import java.util.Scanner;

class Employee {
    public int EmpId;
    public int Salary;
    public String Name;

    // Constructor
    public Employee(int id, int sal, String name) {
        this.EmpId = id;
        this.Salary = sal;
        this.Name = name;
    }

    // Static method to take input and modify the Employee object
    static void Insert(Employee e1) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID, Salary, and Name:");

        e1.EmpId = sc.nextInt();
        e1.Salary = sc.nextInt();
        sc.nextLine();  // Consume newline character
        e1.Name = sc.nextLine();
    }

    // Display method to check values
    void display() {
        System.out.println("Employee ID: " + EmpId);
        System.out.println("Salary: " + Salary);
        System.out.println("Name: " + Name);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an empty Employee object with default values
        Employee emp = new Employee(0, 0, "");
        

        // Call Insert method to update values
        Employee.Insert(emp);

        // Display updated values
        emp.display();
    }
}
