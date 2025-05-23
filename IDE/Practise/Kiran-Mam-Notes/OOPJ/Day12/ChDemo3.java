import java.io.*;
class ChDemo3{
	public static void main(String [] args) {
			
		try{
			m1();
		}catch(IOException e){
			System.out.println("Executed ");
		}
		
		System.out.println("3");
		
	}
	static void m1() throws IOException{
		System.out.println("1");
		m2();
		System.out.println("1");
	}
	
	static void m2() throws IOException{
		System.out.println("2");
		System.out.println("Enter any character: ");
		System.in.close();
		int j = System.in.read();//Exception
		
		System.out.println("Enter char = " +j);
		System.out.println("2");
		
	}
}


