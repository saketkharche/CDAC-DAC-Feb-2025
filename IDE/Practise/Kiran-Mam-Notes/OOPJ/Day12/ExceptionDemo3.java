
class A{}
class B extends A{}
class ExceptionDemo3{
			
    public static void main(String[] args) {
		System.out.println("Started");
		A a = new A();
		try{
			B b =(B)a;//Downcasting: Exception e
		}catch(ClassCastException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println("Downcast me issue hai!");
		}
			
		
		System.out.println("Finished");
		
		
      
    }
}
