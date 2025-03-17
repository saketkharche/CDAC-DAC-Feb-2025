class ExceptionDemo2{
			
    public static void main(String[] args) {
		System.out.println("Started");
		try{
			System.out.println("Entery point in try block");
			int a=100;
			int result = a/0;//Exception e
			System.out.println(result);
		}catch(ArithmeticException e){
			e.printStackTrace();
			System.out.println("Cannot divide by zero....");//user
		}
		
		System.out.println("Finished");
		
		
      
    }
}
