import java.util.Scanner;

public class Q12ArrayCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[20];
        int even = 0, odd = 0, multipleOfThree = 0;

        System.out.println("Enter 20 integers:");
        for (int i = 0; i < 20; i++) {
            arr[i] = scanner.nextInt();
            if (arr[i] % 2 == 0) even++;
            else odd++;
            if (arr[i] % 3 == 0) multipleOfThree++;
        }

        System.out.println("Even numbers: " + even);
        System.out.println("Odd numbers: " + odd);
        System.out.println("Multiples of 3: " + multipleOfThree);

        scanner.close();
    }
}
