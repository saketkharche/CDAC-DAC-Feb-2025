
class ExceptionDemo9{
	
	
    public static void main(String[] args) {
		System.out.println("Start");
		String ar[] = {"15", "s"};
		
		try{
			String s1 = ar[0];
			String s2 = ar[1];
		
			int i = Integer.parseInt(s1);
			int j = Integer.parseInt(s2);
			//throw new NumberFormatException
			
			int k = i/j;// Throw Exception e : 
			//throw new ArithmeticException e
			//throw new NullPointerException e
			
			
			
			System.out.println(k);
		}catch(NumberFormatException | ArithmeticException | NullPointerException e){
			e.printStackTrace();
			System.out.println(" NumberFormatException Exception");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("  Exception");
		}finally{
			System.out.println("Release the resources !!!");
		}
		System.out.println("Finished");
		
		Abc a1 = new Abc();
       
    }
}
