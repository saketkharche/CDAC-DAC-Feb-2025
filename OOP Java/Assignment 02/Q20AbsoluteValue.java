import java.util.Scanner;

public class Q20AbsoluteValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        // Ternary operator to find absolute value
        int absValue = (num < 0) ? -num : num;

        // Output result
        System.out.println("Absolute value: " + absValue);

        sc.close();
    }
}
