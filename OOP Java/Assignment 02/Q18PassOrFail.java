import java.util.Scanner;

public class Q18PassOrFail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input student's percentage
        System.out.print("Enter the percentage: ");
        double percentage = sc.nextDouble();

        // Ternary operator to check pass or fail
        String result = (percentage >= 40) ? "Pass" : "Fail";

        // Output result
        System.out.println("Result: " + result);

        sc.close();
    }
}
