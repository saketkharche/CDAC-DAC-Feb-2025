
class StringDemo2{


	public static void main(String args[]){
		
	StringBuffer sb = new StringBuffer("Hello");
	System.out.println(sb);
	sb.append("Duniya!");
	System.out.println(sb);
	
	StringBuilder sb1 = new StringBuilder("Hello");
	System.out.println(sb1);
	sb1.append("CDAC!");
	System.out.println(sb1);
	
	String s = "Hello";
	System.out.println(s);
	s.concat("Bhai!");
	System.out.println(s);
	s=s.concat("Bhai!");
	System.out.println(s);
	}
	
	
}

