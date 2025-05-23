public class StackOverflowCatchExample {
    public static void recursiveMethod() {
        try {
            recursiveMethod(); // Infinite recursion
        } catch (StackOverflowError e) {
            System.out.println("StackOverflowError caught! Too much recursion.");
        }
    }

    public static void main(String[] args) {
        recursiveMethod();
        System.out.println("Program continues..."); // This won't be reached in most cases
    }
}
