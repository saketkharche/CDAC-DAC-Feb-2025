
class ExceptionDemo4{
	
	void m1(){
		System.out.println("M1 :: Started");
	}
			
    public static void main(String[] args) {
		System.out.println("Started");
		
		ExceptionDemo4 a = null;
		try{
			a.m1();//Excetion e : NPE
		}catch(NullPointerException e){
			e.printStackTrace();
			System.out.println("Null ko inboke mat karo!");
		}
		
		System.out.println("Finished");
		
		
      
    }
}
