class Parent{
	void show(){
		System.out.println("Parent Method: P1");
	}
}

class Child extends Parent{
	void show1(){
		System.out.println("Child Method: C1");
	}
}
class OverridingDemo4{
	public static void main(String args[]){
		
		Parent p = new Parent();
		p.show();
		//p.show1();//Error: CTE
		
		Child c = new Child();
		c.show1();
		c.show();
		
		
		
		
	}
}