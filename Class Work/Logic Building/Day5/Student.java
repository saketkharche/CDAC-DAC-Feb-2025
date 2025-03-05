class Student{
	int id;
	String name;
	long mobNo;
	static String course = "PG-DAC";

	Student(){

	}
	
	void display(){
		System.out.println(id+" "+course);
	}

	static void display(int id, String name){
		System.out.println(id+" "+course+" "+mobNo);
	
	}

	public static void main(String args[]){ 
		Student s = new Student();
		
		s.display();
		s.display(1);
		
	}


}