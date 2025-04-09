class StaticDemo1{
	
	static int x =10;//static 
	static int y=20;//static
	int z =30;//instance
	
	static{
		String name = "Rutuja";
	}
	
	void show(){
		x =20;
		System.out.println(x);//ok
		System.out.println(z);
	}
	static void show1(){
		int m=5;
		x =20;
		System.out.println(m);//ok
		//System.out.println(z);//Error : Non static is not accessible
	}
		
	public static void main(String args[]){
		
		StaticDemo s1 = new StaticDemo();
		
		s1.show();
		//show();//Error: Instance method require reference object
		
		show1();// no need of reference
		StaticDemo.show1();
		
		
		
	}
		
		
}
