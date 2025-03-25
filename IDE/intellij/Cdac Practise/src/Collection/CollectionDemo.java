package Collection;

import java.util.Comparator;
import java.util.TreeSet;

class Employee{
    String EmpName;
    int EmpID;

    public Employee(int empID,String empName) {
        EmpID = empID;
        EmpName = empName;

    }

    @Override
    public String toString() {
        try {
            return EmpID+ " :=>"+EmpName;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.EmpID - e2.EmpID;
    }
}

class EmployeeComparator2 implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e2.EmpName.compareTo(e1.EmpName);
    }

}

class CollectionDemo {
    public static void main(String[] args) {
        TreeSet<Employee> a = new TreeSet<Employee>(new EmployeeComparator());
        a.add(new Employee(1,"Jane Doe"));
        a.add(new Employee(2,"John Doe1"));
        a.add(new Employee(3,"John Doe2"));
        a.add(new Employee(4,"John Doe3"));
        a.add(new Employee(5,"John Doe4"));
        a.add(new Employee(6,"John Doe5"));
        a.add(new Employee(7,"John Doe6"));
        System.out.println(a);

        for (Employee e : a) {
            System.out.println(e);
        }
    }
}