package Day15;

public class GenericDemo {
	
	static <T>void display(T x){
		System.out.println(x.getClass().getName()+ " "+x);
	}
	

	public static void main(String[] args) {
		
		display(11);
		display(11.4556767);
		display("Generics is too easy!");
		
	}

}
