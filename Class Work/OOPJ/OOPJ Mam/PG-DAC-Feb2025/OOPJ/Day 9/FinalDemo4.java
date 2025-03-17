
class Parent{
	
	final void display(){
		System.out.println("Final Method :: Parent");
	}
}

class Child extends Parent{
	/*void display(){//Error: CTE
		System.out.println("Final Method :: Child");
	}*/
}

class FinalDemo4{	
	public static void main(String args[]){//method
			
	//Parent p = new Parent();	
	//p.display();	
	
	Child c = new Child();
	c.display();
		
	}
}

