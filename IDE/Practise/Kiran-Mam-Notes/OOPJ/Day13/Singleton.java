package Day13;

public class Singleton {
	//Step 1
	private static Singleton s1;
	//Step 2
	private Singleton() {
		System.out.println("Singleton reference instance is created!");
	}
	//Step 3
	public static Singleton getInstance() {
		if(s1 == null) {
		s1 = new Singleton();//Object will be created
		}
		return s1;
		
	}
	
	public void show() {
		System.out.println("Hello, I am here!");
	}
	
	public static void main(String args[]) {
		Singleton obj1 = s1.getInstance();
		Singleton obj2 = s1.getInstance();
		
		obj1.show();
		System.out.println(obj1 == obj2);//true
		
	}
	

}
