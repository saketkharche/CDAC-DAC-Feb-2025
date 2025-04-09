class ExceptionDemo5{
			
    public static void main(String[] args) {
		System.out.println("Execution started");
		String ar[] = {"12","g"};
		
		
		
		try{
			String s1 = ar[0];
			String s2 = ar[1];
			System.out.println(s1);
			System.out.println(s2);
			
			int i = Integer.parseInt(s1);//converted String to int : 12
			System.out.println(i);
			int j = Integer.parseInt(s2);//converted String to int : g
			System.out.println(i);
			System.out.println(j);
			int result = i/j;//Exception =>12/0
			
			System.out.println(result);
			
		}catch(NumberFormatException e){
			System.out.println("Give integer numbers....");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Use array element....");
		}catch(ArithmeticException e){
			System.out.println("Cannot divide by zero....");
		}
		System.out.println("Excution finished");
		
	    
    }
}
