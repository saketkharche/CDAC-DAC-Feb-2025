	class Example{
		void modify(int num){
			//num = 20;
			int n = num;
			System.out.println(n);
			
		}
		int modify1(int num){
			//num = 20;
			int n = num;
			return n;
			
		}
		
			
	}
	class ExampleDemo1{
		public static void main(String args[]){
			
			int x=10;
			Example e = new Example();
			//e.num =30;//Error
			//Method 1
			e.modify(100);
			
			System.out.println(x);
			//Method 2
			int y = e.modify1(100);
			System.out.println(y);
			System.out.println(e.modify1(100));
		}
		
		
	}