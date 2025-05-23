
class FinalDemo2{
	final static int SPEED_LIMIT=100;//Final variable
	
	
	
	void display()
	{
		//SPEED_LIMIT = 120;//Error :
		System.out.println(SPEED_LIMIT);
	}
}	

class FinalDemo3{	
	public static void main(String args[]){//method
				
		FinalDemo2 f1 = new FinalDemo2();
		f1.display();
	}
}

// Instance variable, static variable, local variable
