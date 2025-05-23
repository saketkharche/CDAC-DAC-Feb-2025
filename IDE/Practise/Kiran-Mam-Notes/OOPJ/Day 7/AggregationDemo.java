class Address{
	String city, state, country;
	
	Address(String city, String state, String country){
		this.city = city;
		this.state = state;
		this.country = country;
	}
}
class Employee{
	int id;
	String name;
	Address a;//Aggregation: HAS-A:create reference of address class
	
	Employee(int id, String name, Address a){
		this.id = id;
		this.name= name;
		this.a = a;
	}
	
	void display(){
		System.out.println();
	}
	
}
class AggregationDemo{
	
	public static void main(String args[]){
		Teacher t1 = new Teacher("Vipul sir");
		Student s1 = new Student("Raviraj");
		Student s2 = new Student("Jay");
		System.out.println(t1.name+" "+s1.name+" "+s2.name);
	}	
}
