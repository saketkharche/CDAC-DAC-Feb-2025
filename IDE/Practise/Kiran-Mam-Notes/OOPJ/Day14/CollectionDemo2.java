
package Day14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

/*class Employee implements Comparable<Employee>{
	private int empId;
	private String empName;
	
	public Employee(int empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}

	@Override
	public String toString() {
		return  empId + " :=> " + empName;
	}
	
	@Override
	public int compareTo(Employee o) {
		return empId - o.empId;
	}
	
	
	
}*/
public class CollectionDemo2 {

	public static void main(String[] args) {
		
		TreeSet<Employee> a = new TreeSet<>();
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

