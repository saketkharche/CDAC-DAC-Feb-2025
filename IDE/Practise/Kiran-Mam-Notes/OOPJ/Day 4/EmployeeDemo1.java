class Employee{
	//Instance variable
	private int empId;
	private String empName;
	
	
	//Instance menthod
	void set(int id, String name){
		empId = id;
		empName = name;
	}
	
	void show()
	{
		System.out.println(empId+" "+empName);
	}
}


//Driver class
class EmployeeDemo1{
	public static void main(String args[]){
		
		Employee e1 = new Employee();
		
		e1.set(111,"Rahul");
		e1.show();
		
		Employee e2 = new Employee();
		
		e1.set(222,"Shital");
		e1.show();
		
	}
}
