import java.util.Scanner;

public class Q12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        scanner.close();

        int result = n << 3; // Multiply by 8
        System.out.println(n + " * 8 = " + result);
    }
}
