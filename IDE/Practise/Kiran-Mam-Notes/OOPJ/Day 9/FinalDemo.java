class GrandParent{
	
	GrandParent(){
		System.out.println("GP");
	}
}

class Parent extends GrandParent{
	Parent(){
		//super();//calls GP constructor
		System.out.println("P");
	}
	
}

class Child extends Parent{
	
	Child(){
		//super();//call P constructor
		System.out.println("C");
	}
	
}
class OverridingDemo9{
	public static void main(String args[]){
		
		Child c = new Child();
		
	}
}

HW: Child: 2 constructors: default, parameterized + Constructor chaining