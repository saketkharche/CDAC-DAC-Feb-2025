
class Employee{
	int id;
	String name;
	Address a;//HAS-A relationship with Address class
	
	Employee(int id, String name, Address a)
	{
		this.id = id;
		this.name = name;
		this.a = a;
	}
	
	void display()
	{
		System.out.println(id+" "+name);
		System.out.println(a.city+" "+a.state+" "+a.country);
	}
	
}

class Address{
	String city,state,country;
	
	Address(String city,String state, String country)
	{
		this.city = city;
		this.state = state;
		this.country = country;
	}
}

class AggregationDemo{
	public static void main(String args[]){
		Address a1 = new Address("New Mumbai","MH","India");
		Address a2 = new Address("Mumbai","MH","India");
		
		Employee e1 = new Employee(111, "Virat",a1);
		e1.display();
		Employee e2 = new Employee(112, "Viraj",a1);
		e2.display();
		
		
		
	}
}