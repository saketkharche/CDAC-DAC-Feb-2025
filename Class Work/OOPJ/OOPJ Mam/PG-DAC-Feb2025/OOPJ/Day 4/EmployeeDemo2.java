class Employee{
	//Instance variable
	private int empId;
	private String empName;
	private static int total; //static variable
	
	
	//Instance menthod
	void set(int id, String name, int t){
		empId = id;
		empName = name;
		total = t;
	}
	
	void show()
	{
		System.out.println(empId+" "+empName+" "+total);
	}
}


//Driver class
class EmployeeDemo2{
	public static void main(String args[]){
		
		Employee e1 = new Employee();
		
		e1.set(111,"Rahul", 11);
		e1.show();
		
		Employee e2 = new Employee();
		
		e1.set(222,"Shital",12);
		e1.show();
		
	}
}
