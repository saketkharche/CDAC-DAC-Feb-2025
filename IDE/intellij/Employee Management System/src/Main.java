import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Employee{
    private String name;
    private int id;
    public Employee(String name,int id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public int getId()
    {
        return id;
    }
    public abstract double calculateSalary();
    @Override
    public String toString(){
        return "Employee [name="+name+",id="+id+",salary="+calculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;
    public FullTimeEmployee(String name,int id,double monthlySalary)
    {
        super(name,id);
        this.monthlySalary=monthlySalary;
    }
        @Override
        public double calculateSalary(){
            return monthlySalary;
        }


}
//error show due to abstract class get rem body is provided
class PartTimeEmployee extends Employee{
    private int hoursworked;
    private double hourlyrate;
    public PartTimeEmployee(String name,int id,int hoursworked,double hourlyrate){
        super(name,id);
        this.hoursworked=hoursworked;
        this.hourlyrate=hourlyrate;

    }

    @Override
    public double calculateSalary() {
        return hoursworked*hourlyrate;
    }
}
class PayRollSystem{
    private ArrayList<Employee> employeeList;

    public PayRollSystem(){
        employeeList =new ArrayList<>();

    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);

    }
    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee : employeeList){
            if (employee.getId()==id){
               employeeToRemove = employee;
               break;
            }
        }
        if (employeeToRemove !=null){
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployees(){
        for (Employee employee:employeeList){
            System.out.println(employee);
        }

    }
}

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);



        PayRollSystem payRollSystem =new PayRollSystem();
        System.out.println("Enter Employee Details");
        FullTimeEmployee emp1 = new FullTimeEmployee(sc.next(),sc.nextInt(),sc.nextDouble());
        System.out.println("Enter Employee Details");
        PartTimeEmployee emp2 = new PartTimeEmployee(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble());

        payRollSystem.addEmployee(emp1);
        payRollSystem.addEmployee(emp2);
        System.out.println("Initial Employee Details:");
        payRollSystem.displayEmployees();
        System.out.println("Removing Employees:");
        payRollSystem.removeEmployee(2);
        System.out.println("Remaining Employee Details:");
        payRollSystem.displayEmployees();

    }
}