class Parent{
	Parent(String name){
		System.out.println("Parent Constructor::P1= "+name);
	}
	
}

class Child extends Parent{
	
	Child(String name){
		super(name);//Explicit call for constructor
		System.out.println("Child Constructor::C1= "+name);
	}
	
}
class OverridingDemo8{
	public static void main(String args[]){
		
		//Parent p = new Parent();
			
		
		Child c = new Child();
		Child c1 = new Child("OOPs");
		
		
		
		
		
	}
}