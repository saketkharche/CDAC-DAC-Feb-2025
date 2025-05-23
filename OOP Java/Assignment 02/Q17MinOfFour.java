import java.util.Scanner;

public class Q17MinOfFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input four numbers
        System.out.print("Enter four numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        // Nested ternary operator to find the minimum of four numbers
        int min = (a < b) ? 
                     ((a < c) ? ((a < d) ? a : d) : ((c < d) ? c : d)) 
                  : ((b < c) ? ((b < d) ? b : d) : ((c < d) ? c : d));

        // Output the result
        System.out.println("The minimum number is: " + min);

        sc.close(); // Close the scanner to prevent resource leak
    }
}
