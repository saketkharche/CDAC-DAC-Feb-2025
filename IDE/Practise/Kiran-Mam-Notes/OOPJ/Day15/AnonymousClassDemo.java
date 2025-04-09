package Day15;

interface Hello{
	void sayHello();
}

interface Helloworld{
	void msg();
}

abstract Morning{
	abstract void manage();
}
public class AnonymousClassDemo {

	public static void main(String[] args) {
		Hello h1 = new Hello(){
			public void sayHello() {
				System.out.println("Hello world!");
			
			}
		};
		
		//--------------------------------------------------
		Helloworld h2 = new Helloworld() {
			
			public void msg() {
				System.out.println("Testing");
			}
		};
			
		
		
		//call for method
		h1.sayHello();
		h2.msg();
	}

}
