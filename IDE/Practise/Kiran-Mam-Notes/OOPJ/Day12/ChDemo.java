import java.io.*;
class ChDemo{
	public static void main(String [] args){
			
		//int i = Integer.parseInt("ab");//Unchecked Ex 
		
		//int j = System.in.read();
		//Method 1 : try-catch()
		try{
			int j = System.in.read();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
}


