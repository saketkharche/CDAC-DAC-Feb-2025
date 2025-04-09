
class A{
	int cube(final int n){
		n=n+2;
		return n*n*n;
	}
}

class FinalDemo7{	
	public static void main(String args[]){//method
			
	A a1 = new A();
	System.out.println(a1.cube(5));
	
	}
	
	
}

