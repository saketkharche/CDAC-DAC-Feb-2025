class MainMethodDemo{

	/* static public void main(String[] args){
		
		System.out.println("In main()");
		//String s[] = {"1"};
		//MainMethodDemo.main(s);
		//MainMethodDemo.main(1);
		//return 1;
	
	}*/
	
	/*public static void main(int a){
		//MainMethodDemo.main(1);
		System.out.println("In main(int)");
	
	}*/
	
	/*public static int main(String[] args){
		System.out.println("In main(int)");
	
	}*/

	//command-line argument
	 public static void main(String[] args){ 
		
		System.out.println(args.length);
		/*System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		System.out.println(args[3]);
		System.out.println(args[4]);*/
		int a = Integer.parseInt(args[0]);
		float f = Float.parseFloat(args[1]);
		System.out.println(a + 10);
		System.out.println(f + 10.0f);


	}
}

/*
Wrapper classes in java 
int - Integer   pasrseInt()
short - Short
byte - Byte
long - Long
float - Float
double - Double
boolean - Boolean
char - Char
*/