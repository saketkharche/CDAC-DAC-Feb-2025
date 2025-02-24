class Q15Pattern {
    public static void main(String[] args) {
        int rows = 5;

        for (int i = 1; i <= rows; i++) {
            // Spaces before asterisks
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }

            // Asterisks and spaces in between
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
                if (k < i) {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
}

// Q15Pattern.java && java Q15Pattern
//     *
//    * *
//   * * *
//  * * * *
// * * * * *