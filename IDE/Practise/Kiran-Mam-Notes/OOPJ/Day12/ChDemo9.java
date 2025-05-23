import java.io.*;

class ChDemo8{
	static void m() throws FileNotFoundException {
		System.out.println("start");
		File f = new File("abcd.txt");
		
		FileReader fr = new FileReader(f);//Checked Exception
		System.out.println("end");
		
	}
	
	public static void main(String args[])throws FileNotFoundException{
		int k =3/0;//Unchecked
		m();//checked
	}
}




