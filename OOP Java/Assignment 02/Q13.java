import java.util.Scanner;

public class Q13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        scanner.close();

        int mask = num >> 31;  // -1 for negative, 0 for positive
        int abs = (num + mask) ^ mask; // Absolute value calculation

        System.out.println("Absolute value: " + abs);
    }
}
