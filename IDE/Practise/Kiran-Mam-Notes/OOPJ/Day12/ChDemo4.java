import java.io.*;
class ChDemo4{
	public static void main(String [] args) throws IOException {
			
		m1();
		System.out.println("3");
		
	}
	static void m1() throws IOException{
		System.out.println("1");
		m2();
		System.out.println("1");
	}
	
	static void m2()throws IOException{
		System.out.println("2");
		System.out.println("Enter any character: ");
		int j = System.in.read();//Checked Exception
		System.out.println("Enter char = " +(char)j);
		System.out.println("2");
		
	}
}




