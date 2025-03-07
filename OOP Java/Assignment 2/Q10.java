import java.util.Scanner;

public class Q10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking character input from user
        System.out.print("Enter a character: ");
        char ch = scanner.next().charAt(0);

        scanner.close(); // Close scanner after input

        // Convert to lowercase to handle uppercase inputs
        ch = Character.toLowerCase(ch);

        // Check if the character is a vowel or consonant using ternary operator
        String result = (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') ? "Vowel" : "Consonant";

        // Print result
        System.out.println(ch + " is a " + result + ".");
    }
}
