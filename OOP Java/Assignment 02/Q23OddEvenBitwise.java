import java.util.Scanner;

public class Q23OddEvenBitwise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input a number
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        // Check even or odd using & operator
        System.out.println("The number is: " + ((num & 1) == 0 ? "Even" : "Odd"));

        sc.close();
    }
}
