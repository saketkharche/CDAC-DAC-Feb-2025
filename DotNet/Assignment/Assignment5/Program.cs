using System;
using System.Collections.Generic;

class Employee
{
    public int EmpNo { get; set; }
    public string Name { get; set; } = "";
    public double Salary { get; set; }

    public void AcceptDetails()
    {
        Console.Write("Enter Employee Number: ");
        EmpNo = int.Parse(Console.ReadLine() ?? "0");

        Console.Write("Enter Name: ");
        Name = Console.ReadLine() ?? "Unknown";

        Console.Write("Enter Salary: ");
        Salary = double.Parse(Console.ReadLine() ?? "0");
    }

    public void Display()
    {
        Console.WriteLine($"EmpNo: {EmpNo}, Name: {Name}, Salary: ₹{Salary}");
    }
}

class Program
{
    static void Main()
    {
        List<Employee> empList = new List<Employee>();

        Console.WriteLine("===== Task 1: Input Employees until user says 'no' =====");
        string? choice;
        do
        {
            Employee e = new Employee();
            e.AcceptDetails();
            empList.Add(e);

            Console.Write("Add another employee? (yes/no): ");
            choice = Console.ReadLine()?.Trim().ToLower();
        } while (choice == "yes");

        // Display employee with highest salary
        Employee highest = empList[0];
        foreach (Employee emp in empList)
        {
            if (emp.Salary > highest.Salary)
                highest = emp;
        }
        Console.WriteLine("\n-- Employee with Highest Salary --");
        highest.Display();

        // Search by EmpNo
        Console.Write("\nEnter EmpNo to search: ");
        int searchId = int.Parse(Console.ReadLine() ?? "0");
        bool found = false;
        foreach (Employee emp in empList)
        {
            if (emp.EmpNo == searchId)
            {
                Console.WriteLine("-- Employee Found --");
                emp.Display();
                found = true;
                break;
            }
        }
        if (!found)
            Console.WriteLine("Employee not found.");

        // Display Nth employee
        Console.Write("\nEnter N (position) to display that employee: ");
        int n = int.Parse(Console.ReadLine() ?? "0");
        if (n >= 1 && n <= empList.Count)
        {
            Console.WriteLine("-- Nth Employee --");
            empList[n - 1].Display();
        }
        else
        {
            Console.WriteLine("Invalid position.");
        }

        // Task 2: Array → List
        Console.WriteLine("\n===== Task 2: Array to List =====");
        Employee[] empArray = new Employee[]
        {
            new Employee { EmpNo = 101, Name = "Amit", Salary = 50000 },
            new Employee { EmpNo = 102, Name = "Sneha", Salary = 62000 }
        };
        List<Employee> empListFromArray = new List<Employee>(empArray);

        foreach (Employee emp in empListFromArray)
            emp.Display();

        // Task 3: List → Array
        Console.WriteLine("\n===== Task 3: List to Array =====");
        Employee[] arrayFromList = empList.ToArray();

        foreach (Employee emp in arrayFromList)
            emp.Display();
    }
}