package PackageB;
import PackageA.Student;

class StudentDemo{
	public static void main(String args[]){ 
		Student s = new Student();
		//System.out.println(s.id); // 0 , error
		/*System.out.println(s.name);
		System.out.println(s.mobNo);
		System.out.println(s.course);*/
		/*s.setId(100);
		int id = s.getID();*/


		s.display(1);

	
	}

}