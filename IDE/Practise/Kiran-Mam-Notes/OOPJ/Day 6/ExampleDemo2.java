	class Example{
		void modify(Wrapper w){
			w.num = 20;
			System.out.println(w.num);
		}
		
		
			
	}
	
	class Wrapper{
		int num;
		
		Wrapper(int num){
			this.num = num;
		}
	}
	class ExampleDemo2{
		public static void main(String args[]){
			
			Wrapper w = new Wrapper(10);
			Example e = new Example();
			e.modify(w);
			System.out.println(w.num);
			
		}
		
		
	}