
//Immutable Reference
// A final refernce variable cannot be reassigned, but the object's content can change.
class FinalDemo6{	
	public static void main(String args[]){//method
			
	
	final StringBuilder sb = new StringBuilder("CDAC");
	//sb=Immutable reference, Object
	System.out.println(sb);
	
	sb.append("JUHU-Kharghar");
	System.out.println(sb);
	
	//sb = new StringBuilder("Hello");//Error
	//sb = new StringBuilder("CDAC");
	sb.append("Good Morning");
	System.out.println(sb);
	}
	
	
}

