import java.util.Scanner;

public class Q15SwapOddEvenBits {
    public static int swapBits(int x) {
        int evenBits = x & 0xAAAAAAAA; // Mask even bits
        int oddBits = x & 0x55555555;  // Mask odd bits
        return (evenBits >> 1) | (oddBits << 1); // Swap odd and even bits
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int x = scanner.nextInt();
        scanner.close();

        System.out.println("Number after swapping odd and even bits: " + swapBits(x));
    }
}
