class Employee{
	float salary = 40000;//Parent class

}

class Programmer extends Employee{
	int bonus = 10000;//child class
	
}
class SingleInheritanceDemo{
	public static void main(String args[]){
		
		Employee e = new Programmer();
		System.out.println("Sal = "+e.salary);
		System.out.println("Bonus = "+e.bonus);
		
		Programmer e1= new Programmer();
		System.out.println("Sal = "+e1.salary);
		System.out.println("Bonus = "+e1.bonus);
	}	
}