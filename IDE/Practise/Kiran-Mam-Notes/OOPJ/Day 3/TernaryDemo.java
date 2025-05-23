class TernaryDemo {
    public static void main(String[] args) {
		
		int i =121;
		String s = (i%2 == 0)? i+ " is even" : i +"is odd";
		System.out.println(s); 
		
		System.out.println(i); 
		System.out.println("Result = "+i); // + : Concatenate operator
		System.out.println("Result = "+i+" Sahi hai!"); 
		boolean b = (i%2==0)? true : false;
		System.out.println(b); 
		
       
    }
}