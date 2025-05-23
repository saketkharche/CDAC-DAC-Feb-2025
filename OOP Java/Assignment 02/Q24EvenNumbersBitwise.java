public class Q24EvenNumbersBitwise {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if ((i & 1) == 0) {  // Even numbers only
                System.out.print(i + " ");
            }
        }
    }
}
