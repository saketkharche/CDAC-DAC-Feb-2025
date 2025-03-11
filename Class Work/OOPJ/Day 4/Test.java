public class Test {
    int a;  // Instance variable
    private String name;  // Private instance variable

    void display() {
        System.out.println("a: " + a);
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {
        Test obj = new Test();
        obj.a = 10;
        obj.name = "Java";
        obj.display();
    }
}