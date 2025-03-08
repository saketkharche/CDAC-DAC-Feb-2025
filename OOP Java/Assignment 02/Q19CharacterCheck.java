import java.util.Scanner;

public class Q19CharacterCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input character
        System.out.print("Enter a character: ");
        char ch = sc.next().charAt(0);

        // Ternary operator to check character type
        String result = (ch >= 'A' && ch <= 'Z') ? "Uppercase" :
                        (ch >= 'a' && ch <= 'z') ? "Lowercase" : "Not a letter";

        // Output result
        System.out.println("The character is: " + result);

        sc.close();
    }
}
