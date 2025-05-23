
class UnCheckedDemo{
	static void m3(){
		System.out.println("4");
		int i = 1/0;//Excetion e
		System.out.println("4");
	}
	static void m2(){
		System.out.println("3");
		m3();
		System.out.println("3");
	}
	static void m1(){
		System.out.println("2");
		m2();
		System.out.println("2");
	}
	
	static void m(){
		System.out.println("1");
		m1();
		System.out.println("1");
	}
	
	public static void main(String[] args) {
		System.out.println("Started");
		m(); 
		
		
		
      
    }
}
