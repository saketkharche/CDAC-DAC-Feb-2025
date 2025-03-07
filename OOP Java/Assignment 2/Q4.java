import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        scanner.close();

        int sum = 0;
        int n = number;

        while (n > 0) {
            int lastDigit = n - ((n >> 1) << 1);
            sum = sum + lastDigit;
            n = n - lastDigit;
            n = n >> 1;
        }

        while (sum >= 3) {
            sum = sum - 3;
        }

        if (sum == 0) {
            System.out.println(number + " is divisible by 3");
        } else {
            System.out.println(number + " is NOT divisible by 3");
        }
    }
}
