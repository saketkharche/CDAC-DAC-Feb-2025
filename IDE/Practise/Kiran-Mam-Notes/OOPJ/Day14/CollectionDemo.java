package Day14;

import java.util.ArrayList;

/*class Employee{
	private int empId;
	private String empName;
	
	public Employee(int empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}

	@Override
	public String toString() {
		return  empId + " " + empName;
	}
	
	
	
}*/
public class CollectionDemo {

	public static void main(String[] args) {
		
		ArrayList<Employee> a = new ArrayList<>();
		a.add(new Employee(11, "Ravi"));
		a.add(new Employee(21, "Ravi1"));
		a.add(new Employee(51, "Ravi2"));
		a.add(new Employee(61, "Ravi3"));
		a.add(new Employee(14, "Ravi4"));
		a.add(new Employee(66, "Ravi5"));
		a.add(new Employee(41, "Ravi6"));
		
		System.out.println(a);
		
		for(Employee x : a) {
			System.out.println(x);
		}
		

	}

}
