public class Q7 {
    public static void main(String[] args) {
        boolean condition = true; // Boolean literal

        if (condition) {
            System.out.println("The condition is true.");
        } else {
            System.out.println("The condition is false.");
        }

        // Another example with a false condition
        condition = false;

        if (condition) {
            System.out.println("This will not be printed because the condition is false.");
        } else {
            System.out.println("The condition is now false.");
        }
    }
}
