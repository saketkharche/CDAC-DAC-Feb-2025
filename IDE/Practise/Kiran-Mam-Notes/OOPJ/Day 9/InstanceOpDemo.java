

class A{
	
	InstanceOpDemo op;
}
class B extends A{
}
class InstanceOpDemo{	
	public static void main(String args[]){//method
			
			InstanceOpDemo op1 = new InstanceOpDemo();
			A a1 = new A();
			B b1 = new B();
			//syntax:<objectname> instanceof <classname>
			//op1 instanceof InstanceOpDemo
			
			System.out.println(op1 instanceof InstanceOpDemo);//true
			System.out.println(b1 instanceof A);//true
			System.out.println(a1 instanceof B);//false
			System.out.println(op instanceof A);//Error
	
	
	}
	
	
}

