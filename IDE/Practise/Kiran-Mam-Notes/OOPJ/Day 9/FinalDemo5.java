
final class Parent{
	
	
	final void display(){
		
		System.out.println("Final Method :: Parent");
	}
}

class Child extends Parent{
	
}

class FinalDemo5{	
	public static void main(String args[]){//method
			
	
	
	Child c = new Child();
	c.display();
		
	}
}

