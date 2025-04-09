import java.io.*;

class ChDemo6{
	public static void main(String [] args)  {
		File f = new File("abc.txt");
		try{
		FileReader fr = new FileReader(f);//Checked Exception
		}catch(FileNotFoundException e){
		}
		
	}
}




