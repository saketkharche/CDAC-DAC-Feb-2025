interface A{
	default void msg(){
		System.out.println("A: Method of interface A");
	}
}

interface B{
	default void msg(){
		System.out.println("B: Method of interface B");
	}
}

class C implements A, B{
	/*public void msg(){
		System.out.println("C: Method of class C");
	}*/
	
}


class MultipleInheritanceDemo{
	public static void main(String args[]){
		
		C c1  = new C();
		c1.msg();
		c1.msg();
		c1.msg();
		
	}	
}
