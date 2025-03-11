class Adder {
    // Method with two parameters
    static int add(int a, int b) {
        return a + b;
    }

    // Overloaded method with three parameters
    static int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class MethodOverloading1 {
    public static void main(String[] args) {
        System.out.println(Adder.add(10, 20));     // Output: 30
        System.out.println(Adder.add(10, 20, 30)); // Output: 60
    }
}