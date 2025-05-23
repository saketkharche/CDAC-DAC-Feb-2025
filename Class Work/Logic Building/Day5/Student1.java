class Student1{
	int id;
	String name;
	long mobNo;
	static String course = "PG-DAC";

	Student1(){
		id=0;
		name="XYZ";
		mobNo=0l;

	}

	Student1(int id, String name, long mobNo){
		//id = i;
		this.id = id;
		this.name = name;
		this.mobNo = mobNo;
	}
	
	void display(int id){
		System.out.println(this.id+" "+course+" " +id);
	}
	
	void display(){
		System.out.println(id+" "+name+" "+mobNo);
	}
	
	Student1 getStudent(){
		return this;
	}
	/*toString()*/

	public static void main(String args[]){ 
		//s.display();
		Student1 s = new Student1();
		Student1 s1 = new Student1(2,"a",9L);
		Student1 s2 = new Student1(3,"a",9L);
		
		/*s.display();
		s1.display();
		s2.display();*/
	
		/*s2.display(100);
		s1.display(10000);
		s.display(50);*/
	
		Student1 s3 = s2.getStudent();
		s3.display();
	
		System.out.println(s2);
		System.out.println(s3);
		
		
		
	}


}