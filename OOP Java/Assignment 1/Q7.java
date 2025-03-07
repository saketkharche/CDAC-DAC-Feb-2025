public class Q7 {
    public static void main(String[] args) {
        // Check if a number is provided as a command-line argument
        if (args.length == 0) {
            System.out.println("Please provide a number as a command-line argument.");
            return;
        }

        try {
            // Convert command-line argument to an integer
            int num = Integer.parseInt(args[0]);

            // Check if the number is even or odd
            if (num % 2 == 0) {
                System.out.println(num + " is even.");
            } else {
                System.out.println(num + " is odd.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }
}
