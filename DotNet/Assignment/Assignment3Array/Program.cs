using System; // Using the core C# system libraries

class Program
{
    // Main method - entry point of the program
    static void Main()
    {
        // Display header for CDAC Marks section
        Console.WriteLine("====== CDAC Batches and Student Marks ======\n");
        CDACMarks(); // Call the method to handle student marks

        // Display header for Employee section
        Console.WriteLine("\n====== Employee Management System ======\n");
        EmployeeDemo(); // Call the method to handle employee data
    }

    // Method to handle CDAC student marks
    static void CDACMarks()
    {
        // Get number of batches from user
        Console.Write("Enter number of batches: ");
        int numBatches = int.Parse(Console.ReadLine());

        // Create jagged array to store marks (array of arrays)
        int[][] marks = new int[numBatches][];//2

        // Loop through each batch
        for (int i = 0; i < numBatches; i++)
        {
            // Get number of students in current batch
            Console.Write($"Enter number of students in batch {i + 1}: ");
            int numStudents = int.Parse(Console.ReadLine()!);
            marks[i] = new int[numStudents]; // Initialize array for this batch

            // Loop through each student in current batch
            for (int j = 0; j < numStudents; j++)
            {
                // Get marks for current student
                Console.Write($"Enter marks for student {j + 1} in batch {i + 1}: ");
                marks[i][j] = int.Parse(Console.ReadLine()!);
            }
        }

        // Display all entered marks
        Console.WriteLine("\n--- Displaying Marks ---");
        for (int i = 0; i < marks.Length; i++)
        {
            Console.WriteLine($"Batch {i + 1} Marks:");
            for (int j = 0; j < marks[i].Length; j++)
            {
                Console.WriteLine($"  Student {j + 1}: {marks[i][j]}");
            }
        }
    }

    // Method to handle employee operations
    static void EmployeeDemo()
    {
        // Get number of employees from user
        Console.Write("\nEnter number of employees: ");
        int count = int.Parse(Console.ReadLine()!);
        Employee[] employees = new Employee[count]; // Create array to store employees

        // Loop to get details for each employee
        for (int i = 0; i < count; i++)
        {
            Console.WriteLine($"\n-- Enter details for Employee {i + 1} --");
            employees[i] = new Employee(); // Create new Employee object
            employees[i].AcceptDetails(); // Call method to input details
        }

        // Find employee with highest salary
        Employee highest = employees[0]; // Assume first employee has highest salary
        foreach (var emp in employees)
        {
            if (emp.Salary > highest.Salary)
                highest = emp; // Update if current employee has higher salary
        }

        // Display employee with highest salary
        Console.WriteLine("\n-- Employee with Highest Salary --");
        highest.Display();

        // Search for employee by ID
        Console.Write("\nEnter Employee Number to search: ");
        int searchId = int.Parse(Console.ReadLine()!);

        bool found = false; // Flag to track if employee was found
        foreach (var emp in employees)
        {
            if (emp.EmpNo == searchId) // Check if employee ID matches
            {
                Console.WriteLine("\n-- Employee Found --");
                emp.Display(); // Display found employee details
                found = true;
                break; // Exit loop since we found the employee
            }
        }

        if (!found) // If loop completed without finding employee
            Console.WriteLine("Employee not found.");
    }
}

// Employee class definition
class Employee
{
    // Properties
    public int EmpNo;    // Employee number
    public string Name; // Employee name
    public double Salary; // Employee salary

    // Method to accept employee details from user
    public void AcceptDetails()
    {
        Console.Write("Enter Employee Number: ");
        EmpNo = int.Parse(Console.ReadLine()!);

        Console.Write("Enter Name: ");
        Name = Console.ReadLine()!;

        Console.Write("Enter Salary: ");
        Salary = double.Parse(Console.ReadLine()!);
    }

    // Method to display employee details
    public void Display()
    {
        Console.WriteLine($"EmpNo: {EmpNo}, Name: {Name}, Salary: ₹{Salary}");
    }
}