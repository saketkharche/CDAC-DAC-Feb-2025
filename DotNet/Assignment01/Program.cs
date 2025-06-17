using System; // Import the System namespace which contains basic classes like Console and Exception

// Define a namespace called EmployeeApp to organize related classes together
namespace EmployeeApp
{
    // Define a class called Employee
    public class Employee
    {
        // Declare private fields to store data internally
        private string name;     // For storing employee's name
        private int empNo;       // For storing employee number
        private decimal basic;   // For storing basic salary
        private short deptNo;    // For storing department number

        // Define a property for Name with validation
        public string Name
        {
            get => name; // "get" means return the current value of 'name'
            set
            {
                // Check if the input name is blank or empty
                if (string.IsNullOrWhiteSpace(value))
                    throw new ArgumentException("Name cannot be blank.");
                name = value; // Set the value if it's valid
            }
        }

        // Property for EmpNo with validation
        public int EmpNo
        {
            get => empNo; // Return the empNo value
            set
            {
                // Employee number must be greater than 0
                if (value <= 0)
                    throw new ArgumentException("EmpNo must be greater than 0.");
                empNo = value;
            }
        }

        // Property for Basic salary with validation
        public decimal Basic
        {
            get => basic; // Return the basic salary
            set
            {
                // Salary must be between 10000 and 100000
                if (value < 10000 || value > 100000)
                    throw new ArgumentException("Basic salary must be between 10,000 and 100,000.");
                basic = value;
            }
        }

        // Property for Department number with validation
        public short DeptNo
        {
            get => deptNo; // Return the dept number
            set
            {
                // DeptNo must be greater than 0
                if (value <= 0)
                    throw new ArgumentException("DeptNo must be greater than 0.");
                deptNo = value;
            }
        }

        // Method to calculate the Net Salary
        public decimal GetNetSalary()
        {
            // Example formula:
            // HRA = 20% of basic salary
            // DA = 10% of basic
            // PF = 5% of basic (to be subtracted)
            decimal hra = 0.20m * Basic; // Calculate HRA
            decimal da = 0.10m * Basic;  // Calculate DA
            decimal pf = 0.05m * Basic;  // Calculate PF
            return Basic + hra + da - pf; // Return Net Salary
        }

        // Constructor that accepts all values
        public Employee(int empNo, string name, decimal basic, short deptNo)
        {
            EmpNo = empNo;       // Set employee number using property
            Name = name;         // Set name using property
            Basic = basic;       // Set basic salary using property
            DeptNo = deptNo;     // Set department number using property
        }

        // Constructor with 3 values (default deptNo = 1)
        public Employee(int empNo, string name, decimal basic) : this(empNo, name, basic, 1) { }

        // Constructor with 2 values (default basic = 10000, deptNo = 1)
        public Employee(int empNo, string name) : this(empNo, name, 10000, 1) { }

        // Constructor with 1 value (default name = "Unknown", basic = 10000, deptNo = 1)
        public Employee(int empNo) : this(empNo, "Unknown", 10000, 1) { }

        // Default constructor with all default values
        public Employee() : this(1, "Unknown", 10000, 1) { }
    }

    // Main program class that contains the entry point
    class Program
    {
        // Main method: the starting point of the program
        static void Main(string[] args)
        {
            try
            {
                // Create 5 employee objects using different constructors

                Employee o1 = new Employee(1, "Amol", 95000, 10); // All 4 values
                Employee o2 = new Employee(2, "Ravi", 50000);     // 3 values
                Employee o3 = new Employee(3, "Priya");           // 2 values
                Employee o4 = new Employee(4);                    // 1 value
                Employee o5 = new Employee();                     // No value

                // Call method to display each employee’s details
                DisplayEmployee(o1);
                DisplayEmployee(o2);
                DisplayEmployee(o3);
                DisplayEmployee(o4);
                DisplayEmployee(o5);
            }
            catch (Exception ex)
            {
                // If any error occurs, show the error message
                Console.WriteLine("Error: " + ex.Message);
            }
        }

        // Method to print employee details in a neat format
        static void DisplayEmployee(Employee emp)
        {
            Console.WriteLine($"EmpNo: {emp.EmpNo}, Name: {emp.Name}, Basic: {emp.Basic}, DeptNo: {emp.DeptNo}, Net Salary: {emp.GetNetSalary()}");
        }
    }
}
