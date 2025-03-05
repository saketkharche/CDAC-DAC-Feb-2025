public class Q11 {
    public static void main(String[] args) {
        int number = 20; // Example integer value

        // Check if the number is positive and even
        if (number > 0 && number % 2 == 0) {
            System.out.println(number + " is positive and even.");
        } else {
            System.out.println(number + " is not positive and even.");
        }

        // Check if the number is negative or odd
        if (number < 0 || number % 2 != 0) {
            System.out.println(number + " is negative or odd.");
        } else {
            System.out.println(number + " is not negative or odd.");
        }

        // Check if the number is not positive
        if (!(number > 0)) {
            System.out.println(number + " is not positive.");
        } else {
            System.out.println(number + " is positive.");
        }
    }
}
