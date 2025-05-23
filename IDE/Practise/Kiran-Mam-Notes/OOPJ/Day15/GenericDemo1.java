package Day15;

public class GenericDemo1<T> {
	T x;
	GenericDemo1(T x){
		this.x = x;
	}
	public T show(){
		return this.x;
	}

	public static void main(String[] args) {
		
		GenericDemo1<Integer> g1 = new GenericDemo1<>(15);
		GenericDemo1<Double> g2 = new GenericDemo1<>(15.45657587);
		GenericDemo1<String> g3 = new GenericDemo1<>("Generics");
		
		System.out.println(g1.show());
		System.out.println(g2.show());
		System.out.println(g3.show());

	}

}
