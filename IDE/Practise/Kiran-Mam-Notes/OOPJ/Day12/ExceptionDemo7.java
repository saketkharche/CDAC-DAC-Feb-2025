
class ExceptionDemo7{
	
	void m1(){
		System.out.println("M1 :: Started");
	}
			
    public static void main(String[] args) {
		System.out.println("Started");
		
		ExceptionDemo7 a = null;
		try{
			a.m1();//Excetion e : NPE
		}finally{
			System.out.println("Release resources!!!");
		}
		
		System.out.println("Finished");
		
		
      
    }
}
