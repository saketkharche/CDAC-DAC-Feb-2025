class Employee{
	//Instance variable
	int empId;
	String empName;
	
	{
		empId =111;
	}
	
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
class EmployeeDemo{
	public static void main(String args[]){
		int i=10;
		Employee e1 = new Employee();
		
		e1.set(111,"Rahul");
		e1.show();
		
	}
}
//javac EmployeeDemo.java
//java Employee
//java EmployeeDemo