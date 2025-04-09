
//Nesting of interfaces

interface OuterInterface1{
	void print();
	
	interface InnerInterface2{
		void scan();
		
	}
}
//NEsting interfaces are allowed to access methods of nested interfaces
class TestInterface implements OuterInterface1.InnerInterface2{
	public void scan(){
		System.out.println("Outer interface !");
	}
	
}

class MultipleInheritanceDemo4{
	
	public static void main(String args[]){
		
		TestInterface t1 = new TestInterface();
		t1.scan();
	}	
}
