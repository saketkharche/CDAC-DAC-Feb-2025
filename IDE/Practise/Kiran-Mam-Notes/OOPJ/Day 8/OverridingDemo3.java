
class Parent{
	protected void display(){
	System.out.println("Display()::Parent class");
	}
}

class Child extends Parent{
	@Override
	//protected or public
	void display(){// Method Overrriding
	//default: Error: Access modifier control
	
	System.out.println("Display()::Child class");
	}
}

class OverridingDemo3{
	public static void main(String args[]){
		
		Child c = new Child();
		c.display();
	}
}