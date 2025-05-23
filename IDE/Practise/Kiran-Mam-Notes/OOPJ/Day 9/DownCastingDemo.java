

class A{
	void show(){
		System.out.println("Parent class");
	}
	
}
class B extends A{
	void show(){
		System.out.println("Child class");
	}
	
}
class DownCastingDemo{	
	public static void main(String args[]){//method
			
			A a1 = new A();
			B b1 = new B();
			A a2 = new B();// Upcasting : Polymophism
			//B a2 = new A();//Not Correct to declare downcasting
			B b2 = (B) a2;//Downcasting
			b2.show();
			
	
	
	}
	
	
}

