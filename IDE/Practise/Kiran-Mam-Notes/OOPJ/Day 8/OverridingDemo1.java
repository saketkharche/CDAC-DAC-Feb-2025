
class Parent{
	void display(){
	System.out.println("Display()::Parent class");
	}
}

class Child extends Parent{
	@Override
	void display(){// Method Overrriding
	System.out.println("Display()::Child class");
	}
}

class OverridingDemo1{
	public static void main(String args[]){
		
		Child c1 = new Child();
		c1.display();
		
		Parent p1 = new Parent();
		p1.display();
		
		Parent p2 = new Child();
		p2.display();
				
	}
}