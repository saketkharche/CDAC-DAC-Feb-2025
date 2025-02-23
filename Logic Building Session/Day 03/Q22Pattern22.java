class Q22Pattern22 {
    public static void main(String[] args) {
        // Upper part
        for (int i = 9; i >= 1; i -= 2) {
            for (int k = 0; k < (9 - i) / 2; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // Lower part
        for (int i = 3; i <= 9; i += 2) {
            for (int k = 0; k < (9 - i) / 2; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
// Sample Output:
/*
*********
 *******
  *****
   ***
    *
   ***
  *****
 *******
*********
*/
