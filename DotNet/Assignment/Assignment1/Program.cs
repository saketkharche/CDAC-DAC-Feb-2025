using System;

class Employee
{
    private string name;
    private int empNo;
    private decimal basic;
    private short deptNo;

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

    public int EmpNo
    {
        get => empNo;
        set
        {
            if (value <= 0)
                throw new ArgumentException("EmpNo must be greater than 0.");
            empNo = value;
        }
    }

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

    public decimal GetNetSalary()
    {
        return Basic + (Basic * 0.4m) + (Basic * 0.1m);
    }

    public Employee() : this(1, "Default", 10000, 1) { }

    public Employee(int empNo) : this(empNo, "Default", 10000, 1) { }

    public Employee(int empNo, string name) : this(empNo, name, 10000, 1) { }

    public Employee(int empNo, string name, decimal basic) : this(empNo, name, basic, 1) { }

    public Employee(int empNo, string name, decimal basic, short deptNo)
    {
        EmpNo = empNo;
        Name = name;
        Basic = basic;
        DeptNo = deptNo;
    }

    public void Display()
    {
        Console.WriteLine($"EmpNo: {EmpNo}, Name: {Name}, Basic: {Basic}, DeptNo: {DeptNo}, Net Salary: {GetNetSalary()}");
    }
}

class Program
{
    static void Main()
    {
        try
        {
            Employee o1 = new Employee(1, "Amol", 123465, 10);
            Employee o2 = new Employee(2, "Meera", 95000);
            Employee o3 = new Employee(3, "Raj");
            Employee o4 = new Employee(4);
            Employee o5 = new Employee();

            o1.Display();
            o2.Display();
            o3.Display();
            o4.Display();
            o5.Display();
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error: {ex.Message}");
        }
    }
}