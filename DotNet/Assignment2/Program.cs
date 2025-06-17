using System;

namespace EmployeeDemo
{
    // The Employee class represents an employee with a Name, auto-generated Employee Number (EmpNo),
    // Basic salary, and Department number. It also provides a method to calculate the net salary.
    public class Employee
    {
        // This static counter is used to assign a unique EmpNo to each employee.
        private static int counter = 0;

        // Property: Name (cannot be blank)
        private string name;
        public string Name
        {
            get { return name; }
            private set
            {
                // Check that the name is not blank or just spaces.
                if (string.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentException("Name cannot be blank.");
                }
                name = value;
            }
        }

        // Property: EmpNo (read-only and auto-generated)
        public int EmpNo { get; }

        // Property: Basic salary (must be within a specific range)
        private decimal basic;
        public decimal Basic
        {
            get { return basic; }
            private set
            {
                // Set an example valid range: between 5000 and 100000.
                if (value < 5000 || value > 100000)
                {
                    throw new ArgumentException("Basic salary must be between 5000 and 100000.");
                }
                basic = value;
            }
        }

        // Property: DeptNo (must be greater than 0)
        private short deptNo;
        public short DeptNo
        {
            get { return deptNo; }
            private set
            {
                // Check that DeptNo is greater than 0.
                if (value <= 0)
                {
                    throw new ArgumentException("DeptNo must be greater than zero.");
                }
                deptNo = value;
            }
        }

        // Constructor that accepts Name, Basic, and DeptNo.
        public Employee(string name, decimal basic, short deptNo)
        {
            Name = name;     // Validate and set Name
            Basic = basic;   // Validate and set Basic salary
            DeptNo = deptNo; // Validate and set DeptNo

            // Auto-generate EmpNo. Each new Employee gets a unique number.
            EmpNo = ++counter;
        }

        // Constructor that accepts Name and Basic. It defaults DeptNo to 1.
        public Employee(string name, decimal basic) : this(name, basic, 1) { }

        // Constructor that accepts only Name. It defaults Basic to 10000 and DeptNo to 1.
        public Employee(string name) : this(name, 10000, 1) { }

        // Parameterless constructor that uses default values.
        public Employee() : this("Default Name", 10000, 1) { }

        // Method: GetNetSalary calculates the net salary.
        // For example, it returns 90% of the Basic salary assuming a 10% deduction.
        public decimal GetNetSalary()
        {
            return Basic * 0.9m;
        }
    }

    // Class to test the Employee class.
    class Program
    {
        static void Main()
        {
            // Create Employee objects using the parameterless constructor.
            Employee o1 = new Employee();
            Employee o2 = new Employee();
            Employee o3 = new Employee();

            // Display the automatically generated EmpNo for each employee.
            Console.WriteLine(o1.EmpNo); // Expected output: 1
            Console.WriteLine(o2.EmpNo); // Expected output: 2
            Console.WriteLine(o3.EmpNo); // Expected output: 3

            // You can also print them in any order.
            Console.WriteLine(o3.EmpNo); // Prints 3
            Console.WriteLine(o2.EmpNo); // Prints 2
            Console.WriteLine(o1.EmpNo); // Prints 1

            // Example of using the GetNetSalary() method:
            Console.WriteLine("Net Salary of Employee o1: " + o1.GetNetSalary());
        }
    }
}