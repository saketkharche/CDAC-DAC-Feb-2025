import java.util.Scanner;

// Interface for employee actions
interface EmployeeActions {
    void calculateSalary();
    void displayDetails();
}

// Abstract class for Employee
abstract class Employee implements EmployeeActions {
    int employeeId;
    String employeeName;
    String department;

    // Constructor
    public Employee(int id, String name, String dept) {
        this.employeeId = id;
        this.employeeName = name;
        this.department = dept;
    }

    // Abstract method to calculate salary
    public abstract void calculateSalary();

    // Common method to display employee details
    public void displayDetails() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + employeeName);
        System.out.println("Department: " + department);
    }
}

// Subclass Manager inheriting from Employee
class Manager extends Employee {
    double basicSalary;
    double bonus;

    // Constructor
    public Manager(int id, String name, String dept, double salary, double bonus) {
        super(id, name, dept);
        this.basicSalary = salary;
        this.bonus = bonus;
    }

    // Implement calculateSalary()
    @Override
    public void calculateSalary() {
        double totalSalary = basicSalary + bonus;
        System.out.println("Total Salary (including bonus): ₹" + totalSalary);
    }

    // Override displayDetails to include salary and bonus
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Basic Salary: ₹" + basicSalary);
        System.out.println("Bonus: ₹" + bonus);
    }
}

// Subclass Developer inheriting from Employee
class Developer extends Employee {
    double hourlyRate;
    int hoursWorked;

    // Constructor
    public Developer(int id, String name, String dept, double rate, int hours) {
        super(id, name, dept);
        this.hourlyRate = rate;
        this.hoursWorked = hours;
    }

    // Implement calculateSalary()
    @Override
    public void calculateSalary() {
        double totalSalary = hourlyRate * hoursWorked;
        System.out.println("Total Salary (hourly): ₹" + totalSalary);
    }

    // Override displayDetails to include hourly rate and hours worked
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Hourly Rate: ₹" + hourlyRate);
        System.out.println("Hours Worked: " + hoursWorked);
    }
}

// Driver class
public class EMSApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] employees = new Employee[10]; // Max 10 employees
        int count = 0;

        boolean exit = false;

        while (!exit) {
            // Display menu
            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Manager");
            System.out.println("2. Add Developer");
            System.out.println("3. Display All Employees");
            System.out.println("4. Calculate Salary");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (count < employees.length) {
                        System.out.print("Enter Employee ID: ");
                        int id = sc.nextInt();
                        sc.nextLine(); // Consume newline

                        System.out.print("Enter Employee Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();

                        System.out.print("Enter Basic Salary: ");
                        double salary = sc.nextDouble();

                        System.out.print("Enter Bonus: ");
                        double bonus = sc.nextDouble();

                        employees[count] = new Manager(id, name, dept, salary, bonus);
                        count++;
                        System.out.println("Manager added successfully!");
                    } else {
                        System.out.println("Employee list is full!");
                    }
                    break;

                case 2:
                    if (count < employees.length) {
                        System.out.print("Enter Employee ID: ");
                        int id = sc.nextInt();
                        sc.nextLine(); // Consume newline

                        System.out.print("Enter Employee Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();

                        System.out.print("Enter Hourly Rate: ");
                        double rate = sc.nextDouble();

                        System.out.print("Enter Hours Worked: ");
                        int hours = sc.nextInt();

                        employees[count] = new Developer(id, name, dept, rate, hours);
                        count++;
                        System.out.println("Developer added successfully!");
                    } else {
                        System.out.println("Employee list is full!");
                    }
                    break;

                case 3:
                    if (count > 0) {
                        System.out.println("\n===== Employee List =====");
                        for (int i = 0; i < count; i++) {
                            employees[i].displayDetails();
                            System.out.println("---------------------");
                        }
                    } else {
                        System.out.println("No employees found!");
                    }
                    break;

                case 4:
                    if (count > 0) {
                        System.out.print("Enter Employee ID to calculate salary: ");
                        int id = sc.nextInt();
                        boolean found = false;
                        for (int i = 0; i < count; i++) {
                            if (employees[i].employeeId == id) {
                                employees[i].calculateSalary();
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Employee not found!");
                        }
                    } else {
                        System.out.println("No employees found!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Thank you for using the system!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        sc.close();
    }
}
