class StringDemo{

	public static void main(String[] args){
		
	String s = "ABC";  // string literals // 100
	
	//s="PQR";				//200
	String s2 = "ABC";
	String s1 = new String("XYZ"); // new keyword
	String s3 = new String("XYZ");
	//s3 = new String("vipul") 

	/* 
	System.out.println(s==s2); // true
	System.out.println(s1==s); // false
	System.out.println(s1==s3); // false

	
	System.out.println(s1.equals(s3)); // true
	System.out.println(s.equals(s2)); // true
	System.out.println(s1.equals(s2)); // false
	*/


	String concatString = s.concat(" Vipul");
	System.out.println(s);
	System.out.println(concatString);


	}
	



}


/*

String s = "ABC";
String s1 = "ABC";
String s2 = "ABC";
String s3 = "ABC";
String s4 = "ABC";
String s5 = "ABC";

int a = 10;   // 100
a = 20;

*/





















/*
toString();
equals()
*/