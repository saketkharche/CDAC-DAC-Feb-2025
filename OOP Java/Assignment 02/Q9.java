import java.util.Scanner;

public class Q9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from user
        System.out.print("Enter a number: ");
        int N = scanner.nextInt();
        
        scanner.close(); // Close scanner after input

        // Print whether the number is within the range using logical AND (&&)
        System.out.println("Is the number in the range 20 to 50? " + (N >= 20 && N <= 50));
    }
}
