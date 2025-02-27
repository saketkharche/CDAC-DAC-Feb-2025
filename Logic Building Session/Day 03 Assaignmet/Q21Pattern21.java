class Q21Pattern21 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            int num = 1; // Reset num for each row
            for (int j = 1; j <= i; j++) {
                System.out.print(num);
                if (j < i) {
                    System.out.print("*");
                }
                num += 2; // Increment by 2
            }
            System.out.println();
        }
    }
}
// Sample Output:
// 1
// 1*3
// 1*3*5
// 1*3*5*7
// 1*3*5*7*9
