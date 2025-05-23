class Student{
	int id;
	String name;// void setName(String n){}, String getName(){}
	long mobNo;
	static String course = "PG-DAC CDAC Mumbai";

	Student(){
		id=0;
		name="XYZ";
		mobNo=0L;

	}

	Student(int id, String name, long mobNo){
		this.id = id;
		this.name = name;
		this.mobNo = mobNo;
	}
	
	void display(int id){
		System.out.println(this.id+" "+course+" " +id);
	}
	
	static void display(){
		System.out.println("In static Display().");
	}

	/*void setId(int id){ 	this.id = id ; 	}
	int getId(){	return id; 	}*/

}
class StudentDemo{
	public static void main(String args[]){ 
		Student s = new Student();
		/*System.out.println(s.id);
		System.out.println(s.name);
		System.out.println(s.mobNo);
		System.out.println(s.course);*/
		/*s.setId(100);
		int id = s.getID();*/


		
		
		//display();		
		//Student.display();		
	}

}