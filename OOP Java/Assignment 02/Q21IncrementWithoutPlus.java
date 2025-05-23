import java.util.Scanner;

public class Q21IncrementWithoutPlus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input a number
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        // Increment using bitwise NOT
        int incrementedNum = -~num;  // Equivalent to num + 1

        // Output result
        System.out.println("Incremented number: " + incrementedNum);

        sc.close();
    }
}
