
class ThrowDemo1{
	
	
	public static void main(String[] args) {
		System.out.println("Started");
		
		try{
			throw new NullPointerException();
			
		}catch(NullPointerException e){
			e.printStackTrace();
			System.out.println("Null ko invoke mat karo!");
		}finally{
			System.out.println("Finally!!!");
		}
		
		
		System.out.println("Finished");
		
		
      
    }
}
