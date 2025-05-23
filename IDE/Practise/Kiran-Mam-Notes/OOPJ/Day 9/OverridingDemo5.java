class Parent{
	void show(){
		System.out.println("Parent Method: P1");
	}
}

class Child extends Parent{
	void show(){
		super.show();//Parent class method : call
		System.out.println("Child Method: C1");
	}
}
class OverridingDemo5{
	public static void main(String args[]){
		
		Parent p = new Parent();
		p.show();//Parent class : show()
		
		
		Child c = new Child();
		c.show();//Child class : show()
		
		
		
		
		
	}
}