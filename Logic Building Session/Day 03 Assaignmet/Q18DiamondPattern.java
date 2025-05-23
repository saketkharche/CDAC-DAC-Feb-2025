class Q18DiamondPattern {
    public static void main(String[] args) {
        int rows = 5;

        // Upper triangle and middle line
        for (int i = 1; i <= rows; i++) {
            // Spaces for alignment
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // Asterisks
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Lower inverted triangle
        for (int i = rows - 1; i >= 1; i--) {
            // Spaces for alignment
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // Asterisks
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

// 
//     *
//    ***
//   *****
//  *******
// *********
//  *******
//   *****
//    ***
//     *
