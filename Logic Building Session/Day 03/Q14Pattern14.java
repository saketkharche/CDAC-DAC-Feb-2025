class Q14Pattern14 {
    public static void main(String[] args) {
        for (int i = 1; i <= 7; i += 2) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
// Sample Output:
// *
// ***
// *****
// *******
