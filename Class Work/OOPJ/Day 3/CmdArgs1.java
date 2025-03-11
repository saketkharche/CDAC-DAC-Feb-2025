class CmdArgs1 {
    public static void main(String[] args) {
		//int i =10;//compile time 
		//user input: input required at run time
		
		String s1 = args[0];
		String s2 = args[1];
		System.out.println(s1);
		System.out.println(s2);
		
		//Wrapper classes int=Integer, float = Float
		int i = Integer.parseInt(s1);//10 converted string into int data type
		int j = Integer.parseInt(s2);
		
		System.out.println(s1+s2);
		System.out.println(i+j);
		
		
		
		
		
		
       
    }
}