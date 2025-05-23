
class GarbageCollectionDemo{

	protected void finalize(){
		System.out.println("Finalize method called ....");
	}
	public static void main(String args[]){
		
		GarbageCollectionDemo g1 = new GarbageCollectionDemo();	
		g1 = null;
		
		System.gc();//Request GC
		
	
	}
	
	
}

