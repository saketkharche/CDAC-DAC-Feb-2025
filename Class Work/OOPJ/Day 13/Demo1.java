public class Demo1 {
    public static void recursiveMethod() {
        try {
            // Artificially checking the stack depth (not reliable)
            if (Thread.currentThread().getStackTrace().length > 1000) {
                throw new StackOverflowError();
            }
            recursiveMethod();
        } catch (StackOverflowError e) {
            System.err.println("System Message: StackOverflowError detected! Too much recursion.");
            e.printStackTrace(); // Prints the full stack trace
        }
    }

    public static void main(String[] args) {
        recursiveMethod();
        System.out.println("Program continues..."); // Usually not reached
    }
}
