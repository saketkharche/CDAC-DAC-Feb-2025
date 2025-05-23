class ExceptionDemo2{
			
    public static void main(String[] args) {
		try{
			int a=100;
			int result = a/0;//Exception
		}catch(ArithmeticException e){
			System.out.println("Cannot divide by zero....");
		}
		
		//System.out.println(result);
		
		
      
    }
}
