public class NumberFormatExample {
    public static void main(String[] args) {
        try {
            int num = Integer.parseInt("abc"); // Causes NumberFormatException
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        }
    }
}
