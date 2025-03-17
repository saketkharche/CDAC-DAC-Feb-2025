

class Employee1 {
    String name;
    int id;
    
    public Employee1(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    @Override
    public int hashCode() {
        return id;  // Using ID as a unique hash code
    }
    
    
}
public class ObjectDemo1 {

	public static void main(String[] args) {
		Employee1 emp1 = new Employee1("Alice", 101);
	    System.out.println("HashCode: " + emp1.hashCode());

	}

}
