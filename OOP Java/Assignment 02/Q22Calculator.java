import java.util.Scanner;

public class Q22Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input two numbers
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();
        System.out.print("Enter operator (+, -, *, /): ");
        char operator = sc.next().charAt(0);

        // Using switch-case to perform operations
        double result = 0;
        boolean validOperation = true;

        switch (operator) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/': result = (num2 != 0) ? (num1 / num2) : Double.NaN; break;
            default:
                validOperation = false;
                System.out.println("Invalid operator");
        }

        // Output result if valid
        if (validOperation) {
            System.out.println("Result: " + result);
        }

        sc.close();
    }
}
