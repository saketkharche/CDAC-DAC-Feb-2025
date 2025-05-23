package Day15;

public class GenericDemo2<T> {
	T x;
	T y;
	GenericDemo2(T x, T y){
		this.x = x;
		this.y = y;
	}
	public T show(T x, T y){
		return this.x;
	}

	public static void main(String[] args) {
		
		GenericDemo2<Integer> g1 = new GenericDemo2<>(15);
		GenericDemo2<Double> g2 = new GenericDemo2<>(15.45657587);
		GenericDemo2<String> g3 = new GenericDemo2<>("Generics");
		
		System.out.println(g1.show());
		System.out.println(g2.show());
		System.out.println(g3.show());

	}

}
