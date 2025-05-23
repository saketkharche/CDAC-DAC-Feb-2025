

public class MethodOverloading4 {
    void sum(int a, long b) {
        System.out.println("Method with int and long called: " + (a + b));
    }

    void sum(int a, int b, int c) {
        System.out.println("Method with three int called: " + (a + b + c));
    }

    public static void main(String[] args) {
        MethodOverloading4 obj = new MethodOverloading4();
        obj.sum(10, 20L);   // Calls method with int and long
        obj.sum(10, 20, 30); // Calls method with three int
    }
}