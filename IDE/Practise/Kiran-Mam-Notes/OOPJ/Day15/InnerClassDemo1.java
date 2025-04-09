package Day15;


/*class OuterClass{
		int x = 100;
		
		public void display(){
			System.out.println("Outer class : Method");
			//System.out.println(y);//CE
			
		}
		class InnerClass{
			int y = 200;
			public void display1(){
				System.out.println("Inner class : Method");
				System.out.println(x);
				display();
			}
		}

	}*/
	public class InnerClassDemo1 {

		public static void main(String[] args) {
			OuterClass o1 = new OuterClass();//Ref of Outer class
			
			System.out.println(o1.x);//100
			o1.display();
			
			
			OuterClass.InnerClass o2 = o1.new InnerClass();//Ref of Inner class
			System.out.println(o2.y);
			o2.display1();
		}

	}
