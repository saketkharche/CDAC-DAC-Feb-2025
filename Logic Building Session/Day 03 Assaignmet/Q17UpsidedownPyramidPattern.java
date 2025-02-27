class Q17UpsidedownPyramidPattern {
    public static void main(String[] args) {
        int rows = 5;

        for (int i = rows; i >= 1; i--) {

            // Calculate spaces required to center the pyramid in terminal, i = 5
            int spaces = rows - i;

            // Print leading spaces
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            // Print asterisk pattern in a row
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
                if (k < i) {
                    System.out.print(" ");
                }
            }

            // Move to the next line to replicate above steps for the remaing rows
            System.out.println();
        }
    }
}

// * * * * *
//  * * * *
//   * * *
//    * *
//     *