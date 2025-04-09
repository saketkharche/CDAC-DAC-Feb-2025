
interface Printer{
	void print();
}



interface Scanner{
	void scan();
	static int square(int x)
	{
		return x*x;
	}
}


class Computer implements Printer, Scanner{
	public void print(){
		System.out.println("Printer method");
	}
	
	public void scan(){
		System.out.println("Scanner method");
	}
	
	void msg(){
		System.out.println("Default method");
	}
	
	
}

class MultipleInheritanceDemo2{
	public static void main(String args[]){
		
		Computer c = new Computer();
		c.print();
		c.scan();
		c.msg();
		System.out.println(Scanner.square(2));
		
	}	
}
