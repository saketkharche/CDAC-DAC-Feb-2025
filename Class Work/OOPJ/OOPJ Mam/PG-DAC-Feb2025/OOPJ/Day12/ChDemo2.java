import java.io.*;
class ChDemo2{
	public static void main(String [] args) {
			
		m1();
		
	}
	static void m1(){
		m2();
	}
	
	static void m2(){
		System.out.println("Enter any character: ");
		try{
		int j = System.in.read();//Exception
		System.out.println("Enter char = " +(char)j);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}


