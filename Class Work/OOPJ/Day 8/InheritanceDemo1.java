class Parent{
	int x =10;
	Abc a2;//Ref of Abc
}

class Child extends Parent{
	int y=20;
	
}

class Abc{
	
}


class InheritanceDemo1{
	public static void main(String args[]){
		
		Child c = new Child();//Ref for child class
		Abc a = new Abc();//Ref for Abc class
		Abc a1;
	}
}