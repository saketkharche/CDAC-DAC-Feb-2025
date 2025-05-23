package Day13.priv;

public class Employee {
	 private double salary;

	 
	  public Employee() {
		
	}

	 public Employee(double salary) {
		
		this.salary = salary;
	}
	
	 public void display() {
		System.out.println("Salary = "+salary);
	}
	
	public void show() {
		System.out.println("Salary = "+salary);
		display();
	}
	/*public static void main(String[] args) {
		Employee e1 = new Employee(40000);
		e1.display();
	}*/
	


}
