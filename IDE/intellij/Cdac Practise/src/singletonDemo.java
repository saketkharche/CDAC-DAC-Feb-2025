class SingletonDemo {
    private int number;

    // 2. Make constructor private
    private SingletonDemo() {
    }

    // 4. Declare static field inside class
    private static SingletonDemo reference; // null

    // 3. Define a static method to create instance of a class
    public static SingletonDemo getReference() {
        if (reference == null) {
            reference = new SingletonDemo();
        }
        return reference;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

class Program {
    public static void main(String[] args) {
        SingletonDemo s1 = SingletonDemo.getReference();
        s1.setNumber(123);
        System.out.println("Number : " + s1.getNumber());

        SingletonDemo s2 = SingletonDemo.getReference();
        System.out.println(s1 == s2); // true
    }
}