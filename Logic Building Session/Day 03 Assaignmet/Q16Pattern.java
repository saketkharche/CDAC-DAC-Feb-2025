class Q16Pattern {
    public static void main(String[] args) {
        int rows = 5;

        for (int i = 1; i <= rows; i++) {
            // Spaces for centering
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" "); // Single space for alignment
            }

            // Asterisks
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
