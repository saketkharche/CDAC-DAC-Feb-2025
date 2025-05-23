package Day02.Assignment1;

import java.util.Scanner;

public class Q5 {
    // Recursive function to reverse the number
    static int reverseNumber(int n, int temp) {
        if (n == 0) {
            return temp; // Base case: return the reversed number
        }
        temp = (temp * 10) + (n % 10); // Add last digit to temp
        return reverseNumber(n / 10, temp); // Recursive call
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        sc.close();

        int reversed = reverseNumber(n, 0); // Call recursive function

        // Compare reversed number with original number
        if (reversed == n) {
            System.out.println("Yes, it is a Palindrome.");
        } else {
            System.out.println("No, it is not a Palindrome.");
        }
    }
}
