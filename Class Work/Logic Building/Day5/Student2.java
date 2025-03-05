class Student2{
	int id;
	String name;
	long mobNo;
	static String course = "PG-DAC";

	Student2(){
		this(100,100);
		System.out.println("Inside 0 para constr.");
	}
	
	Student2(int id){
		System.out.println("Inside 1 para constr.");
	}

	Student2(int id, String name, long mobNo){
		this();
		System.out.println("Inside 3 para constr.");
	}
	
	public static void main(String args[]){ 
		Student2 s = new Student2(); 
		Student2 s1 = new Student2(1,"ABC",9L);
				
		

/*
	super()
*/
}