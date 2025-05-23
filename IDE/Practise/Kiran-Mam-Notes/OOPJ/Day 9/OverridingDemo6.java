class Parent{
	int i=100;
	void show(){
		System.out.println("Parent Method: P1");
	}
	
	void show1(){
		
	}
}

class Child extends Parent{
	int num =50;
	//int i=40;
	
	void show(){
		super.show();//Parent class method : call
		super.show1();
		System.out.println("Child Method: C1");
	}
	void display(){
		System.out.println(num);
		System.out.println(i);//preference child class
		System.out.println(super.i);// parent class
	}
}
class OverridingDemo6{
	public static void main(String args[]){
		
		Parent p = new Parent();
		p.show();//Parent class : show()
		
		
		Child c = new Child();
		c.show();//Child class : show()
		c.display();
		c.show1();
		
		
		
		
		
	}
}