	//Pass by reference
	/*
	-Pass by reference : java not supported, 
	but it passes object reference by value.
	-Since both references point to the same object, 
	modifications inside the method reflects 
	in the original object.
	
	
	*/
	
	class Example{
		void modify(Wrapper w){
			w.num = 20;//value is update
			System.out.println(w.num);//20
		}
	
			
	}
	
	class Wrapper{
		int num;//10
		String name;
		
		Wrapper(int num, String name){
			this.num = num;
			this.name = name;
		}
	}
	class ExampleDemo2{
		public static void main(String args[]){
			
			Wrapper w = new Wrapper(10);
			Example e = new Example();
			e.modify(w);//20
			
			System.out.println(w.num);//20
			w.num = 34;
			System.out.println(w.num);
			
		}
		
		
	}