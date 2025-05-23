
class StringDemo{


	public static void main(String args[]){
		//Method 1 : String literals
		String s1 = "ABC";//String literal
		String s2 = "ABC";
		String s3 = "ABCD";
		String s4 = "ABCD";
		
		//== will compare reference content
		//and not the object content (values)
		System.out.println((s1 == s2));//true
		System.out.println((s3 == s4));
		System.out.println((s1 == s3));
		
		//Method 2
		String s5 = new String("ABC");
		String s6 = new String("ABCD");
		System.out.println((s5 == s6));//false
		System.out.println((s3 == s6));//false
		
		//.equals(): we are comparing values of the reference
		System.out.println((s1.equals(s5)));
		System.out.println((s5.equals(s6)));
		
		String s7 = new String("ABC");
		
		System.out.println(s1);
		s1.concat("XYZD");
		System.out.println(s1);
		s1 = s1.concat("XYZD");
		System.out.println(s1);
	}
	
	
}

