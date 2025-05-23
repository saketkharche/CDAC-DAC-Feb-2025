public class Q6 {
    public static void main(String[] args) {
        // Character literal
        char charLiteral = 'A';
        int charAsciiValue = (int) charLiteral;
        System.out.println("Character literal: " + charLiteral + ", ASCII value: " + charAsciiValue);

        // String literal
        String stringLiteral = "Hello";
        System.out.println("String literal: " + stringLiteral);
        System.out.print("ASCII values: ");
        for (int i = 0; i < stringLiteral.length(); i++) {
            System.out.print((int) stringLiteral.charAt(i) + " ");
        }
    }
}
