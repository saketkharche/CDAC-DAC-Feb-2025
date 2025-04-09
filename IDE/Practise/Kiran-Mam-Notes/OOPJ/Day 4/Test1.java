class Test1 {
    static int counter = 0;  // Static variable

    void increment() {
        counter++;
    }
}

public class Main {
    public static void main(String[] args) {
        Test obj1 = new Test();
        Test obj2 = new Test();

        obj1.increment();
        obj2.increment();

        System.out.println("Counter: " + Test.counter); // Shared across instances
    }
}