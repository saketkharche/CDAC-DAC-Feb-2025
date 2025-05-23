
class ExceptionDemo5{
	
	void m1(){
		System.out.println("M1 :: Started");
	}
			
    public static void main(String[] args) {
		System.out.println("Started");
		
		ExceptionDemo5 a = null;
		try{
			//a.m1();//Excetion e : NPE
		}catch(NullPointerException e){
			e.printStackTrace();
			System.out.println("Null ko invoke mat karo!");
		}finally{
			System.out.println("Release resources!!!");
		}
		
		System.out.println("Finished");
		
		
      
    }
}
