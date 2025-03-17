class Finally{
	public static void main(String [] args){
			
			
			//Not a correct way to stop finally from execution
		try{
			
			System.exit(0);
			
		}catch(Exception e){
			System.out.println("Exception aagaya!!");
			
		}
		finally{
			System.out.println("Finally");
		}
	}
}


