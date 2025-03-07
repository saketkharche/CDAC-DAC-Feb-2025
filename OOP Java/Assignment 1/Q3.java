public class Q3 {
    public static void main(String[] args) {
        // Implicit Type Casting (Widening)
        int intVal = 100;
        double doubleVal = intVal;
        System.out.println("Implicit Casting (int to double): " + doubleVal);

        // Explicit Type Casting (Narrowing)
        double d = 99.99;
        int i = (int) d;
        System.out.println("Explicit Casting (double to int): " + i);
    }
}
