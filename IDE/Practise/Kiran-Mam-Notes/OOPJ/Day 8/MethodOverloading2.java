class Adder {
    // Method with integer parameters
    static int add(int a, int b) {
        return a + b;
    }

    // Overloaded method with double parameters
    static double add(double a, double b) {
        return a + b;
    }
}

public class MethodOverloading2 {
    public static void main(String[] args) {
       System.out.println(Adder.add(10, 20));      // Output: 30
        System.out.println(Adder.add(10.5, 20.5));  // Output: 31.0
    }
}