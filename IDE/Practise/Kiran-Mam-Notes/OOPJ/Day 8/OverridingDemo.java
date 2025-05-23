
class Parent{
	void display(){
	System.out.println("Display()::Parent class");
	}
}

class Child extends Parent{
	void display(){// Method Overrriding
	System.out.println("Display()::Child class");
	}
}

class OverridingDemo{
	public static void main(String args[]){
		
		Child c1 = new Child();
		c1.display();
				
	}
}