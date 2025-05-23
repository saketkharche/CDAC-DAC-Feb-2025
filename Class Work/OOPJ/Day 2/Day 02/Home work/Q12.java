public class Q12 {
    public static void main(String[] args) {
        int num1 = 10; // Example integer value
        int num2 = 5; // Example integer value

        // Assignment operator
        int result = num1;
        System.out.println("Assignment: result = " + result);

        // Addition assignment operator
        result += num2;
        System.out.println("Addition assignment: result += " + num2 + " -> " + result);

        // Subtraction assignment operator
        result -= num2;
        System.out.println("Subtraction assignment: result -= " + num2 + " -> " + result);

        // Multiplication assignment operator
        result *= num2;
        System.out.println("Multiplication assignment: result *= " + num2 + " -> " + result);

        // Division assignment operator
        result /= num2;
        System.out.println("Division assignment: result /= " + num2 + " -> " + result);

        // Modulus assignment operator
        result %= num2;
        System.out.println("Modulus assignment: result %= " + num2 + " -> " + result);
    }
}
