
interface Printer{
	void print();
}

interface Scanner{
	void scan();
}


class Computer implements Printer, Scanner{
	public void print(){
		System.out.println("Printer method");
	}
	
	public void scan(){
		System.out.println("Scanner method");
	}
}

class MultipleInheritanceDemo1{
	public static void main(String args[]){
		
		Computer c = new Computer();
		c.print();
		c.scan();
	}	
}
