using System;

class Employee
{
    // Static counter to auto-increment EmpNo
    private static int empCounter = 0;

    // Auto-generated, readonly property
    public int EmpNo { get; }

    private string name;
    private decimal basic;
    private short deptNo;

    // Name: no blank allowed
    public string Name
    {
        get => name;
        set
        {
            if (string.IsNullOrWhiteSpace(value))
                throw new ArgumentException("Name cannot be blank.");
            name = value;
        }
    }

    // Basic: within range
    public decimal Basic
    {
        get => basic;
        set
        {
            if (value < 10000 || value > 500000)
                throw new ArgumentException("Basic must be between 10,000 and 500,000.");
            basic = value;
        }
    }

    // DeptNo: > 0
    public short DeptNo
    {
        get => deptNo;
        set
        {
            if (value <= 0)
                throw new ArgumentException("DeptNo must be greater than 0.");
            deptNo = value;
        }
    }

    // Method to calculate Net Salary
    public decimal GetNetSalary()
    {
        return Basic + (Basic * 0.25m) + 2000; // 25% allowance + fixed 2000 bonus
    }

    // Constructors
    public Employee() : this("Default", 10000, 1) { }

    public Employee(string name) : this(name, 10000, 1) { }

    public Employee(string name, decimal basic) : this(name, basic, 1) { }

    public Employee(string name, decimal basic, short deptNo)
    {
        EmpNo = ++empCounter;
        Name = name;
        Basic = basic;
        DeptNo = deptNo;
    }
}

class Program
{
    static void Main()
    {
        Employee o1 = new Employee();
        Employee o2 = new Employee();
        Employee o3 = new Employee();

        Console.WriteLine(o1.EmpNo); // Output: 1
        Console.WriteLine(o2.EmpNo); // Output: 2
        Console.WriteLine(o3.EmpNo); // Output: 3

        Console.WriteLine(o3.EmpNo); // 3
        Console.WriteLine(o2.EmpNo); // 2
        Console.WriteLine(o1.EmpNo); // 1
    }
}