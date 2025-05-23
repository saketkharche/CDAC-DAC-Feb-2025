import java.util.Scanner;

public class Q25ReverseInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input a number
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();

        int rev = 0;
        while (num != 0) {
            rev = rev * 10 + num % 10; // Extract last digit and add to reversed number
            num /= 10; // Remove last digit
        }

        // Output result
        System.out.println("Reversed number: " + rev);

        sc.close();
    }
}
