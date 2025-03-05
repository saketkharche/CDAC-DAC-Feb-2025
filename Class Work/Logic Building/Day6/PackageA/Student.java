package PackageA;

public class Student{
	//protected int id; //find a solution

	public int id;
	public String name;// void setName(String n){}, String getName(){}
	public long mobNo;
	public static String course = "PG-DAC CDAC Mumbai";

	public Student(){
		id=0;
		name="XYZ";
		mobNo=0L;

	}

	public Student(int id, String name, long mobNo){
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

	
}
