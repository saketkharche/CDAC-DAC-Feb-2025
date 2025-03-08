import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        // Swapping using a temporary variable
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After swapping (using temp variable): a = " + a + ", b = " + b);

        // Swapping without using a temporary variable
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After swapping (without temp variable): a = " + a + ", b = " + b);

        sc.close();
    }
}
