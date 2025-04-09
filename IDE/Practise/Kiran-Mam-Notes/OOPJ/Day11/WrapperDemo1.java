class WrapperDemo1{
		
    public static void main(String[] args) {
		
		Integer a = new Integer(30);
		//Method 1: 		
		int i = a.intValue();//Explicit call: Unboxing
		System.out.println(i);
		
		//Method 2:
		int j = a;//compiler automatic conversion kiya
		
		System.out.println(j);
      
    }
}
