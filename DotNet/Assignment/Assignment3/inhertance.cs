using System;

namespace EmployeeHierarchy
{
    public interface IDbFunctions
    {
        void Insert();
        void Update();
        void Delete();
    }

    public abstract class Employee : IDbFunctions
    {
        private static int empCounter = 0;

        public int EmpNo { get; }

        private string name;
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

        public abstract decimal Basic { get; set; }

        public abstract decimal CalcNetSalary();

        public Employee(string name = "Default", short deptNo = 1)
        {
            EmpNo = ++empCounter;
            Name = name;
            DeptNo = deptNo;
        }

        public void Insert() => Console.WriteLine($"Insert() called for {GetType().Name}");
        public void Update() => Console.WriteLine($"Update() called for {GetType().Name}");
        public void Delete() => Console.WriteLine($"Delete() called for {GetType().Name}");
    }

    public class Manager : Employee
    {
        private decimal basic;
        private string designation;

        public string Designation
        {
            get => designation;
            set
            {
                if (string.IsNullOrWhiteSpace(value))
                    throw new ArgumentException("Designation cannot be blank.");
                designation = value;
            }
        }

        public override decimal Basic
        {
            get => basic;
            set
            {
                if (value < 20000 || value > 300000)
                    throw new ArgumentException("Manager Basic must be between 20,000 and 300,000.");
                basic = value;
            }
        }

        public override decimal CalcNetSalary() => Basic + Basic * 0.3m + 5000;

        public Manager(string name, decimal basic, string designation, short deptNo = 1)
            : base(name, deptNo)
        {
            Basic = basic;
            Designation = designation;
        }
    }

    public class GeneralManager : Manager
    {
        public string Perks { get; set; }

        public GeneralManager(string name, decimal basic, string designation, string perks, short deptNo = 1)
            : base(name, basic, designation, deptNo)
        {
            Perks = perks;
        }

        public override decimal CalcNetSalary() => Basic + Basic * 0.4m + 8000;
    }

    public class CEO : Employee
    {
        private decimal basic;

        public override decimal Basic
        {
            get => basic;
            set
            {
                if (value < 100000 || value > 1000000)
                    throw new ArgumentException("CEO Basic must be between 100,000 and 1,000,000.");
                basic = value;
            }
        }

        public CEO(string name, decimal basic, short deptNo = 1)
            : base(name, deptNo)
        {
            Basic = basic;
        }

        public sealed override decimal CalcNetSalary() => Basic + Basic * 0.5m + 10000;
    }

    class Program
    {
        static void Main()
        {
            Employee m = new Manager("Saket", 250000, "Project Architect");
            Employee gm = new GeneralManager("Pranav", 280000, "Head Ops", "Club Access");
            Employee ceo = new CEO("Rhea", 900000);

            Console.WriteLine($"{m.Name} ({m.EmpNo}) - Net Salary: ₹{m.CalcNetSalary()}");
            Console.WriteLine($"{gm.Name} ({gm.EmpNo}) - Net Salary: ₹{gm.CalcNetSalary()}");
            Console.WriteLine($"{ceo.Name} ({ceo.EmpNo}) - Net Salary: ₹{ceo.CalcNetSalary()}");

            m.Insert();
            gm.Update();
            ceo.Delete();
        }
    }
}