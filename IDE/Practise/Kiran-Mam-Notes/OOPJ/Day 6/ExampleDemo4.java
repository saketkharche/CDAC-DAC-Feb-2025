		
	class Example{
		
		int num1;
		int num2;
		
		Example(int num1, int num2){
			this.num1 = num1;
			this.num2 = num2;
		
		}
		
	
			
	}
	
	
	class ExampleDemo4{
		public static void main(String args[]){
			
			Example e1 = new Example(10,20);
			Example e2 = new Example(20,30);
			e1 = e2;
			
			Example e3 = new Example(120,130);
			e2 = e3;
			
			Example e4 = null;//Explicit call :  for the garbage collection.
			//we are making it eligible for GC
			
			System.out.println(e1);
			System.out.println(e4);
			
		}
		
		
	}