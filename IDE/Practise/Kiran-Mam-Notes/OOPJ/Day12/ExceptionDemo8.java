
class ExceptionDemo8{
	
	
    public static void main(String[] args) {
		System.out.println("Start");
		
		String s1 = "15";
		String s2 = "0";
		
		int i = Integer.parseInt(s1);
		int j = Integer.parseInt(s2);
		
		try{
			int k = i/j;
			System.out.println(k);
		}
		/*catch(ArithmeticException e){
			e.printStackTrace();
			System.out.println("Arithmetic Exception");
		}*/
		catch(NullPointerException e){
			//e.printStackTrace();
			System.out.println("NullPointer Exception");
		}finally{
			System.out.println("Release the resources !!!");
		}
		System.out.println("Finished");
		
		
      
    }
}
