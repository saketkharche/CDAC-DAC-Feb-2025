package Day02.Assignment1;

import java.util.Scanner;

public class Q4 {
    static int fibo(int n) {
        if (n <= 1) {
            return n;
        }
        int last = fibo(n - 1);
        int secondlast = fibo(n - 2);
        return last + secondlast;
    }
    public static void main(String[] args) {

        System.out.println("Enter the number : ");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {

            System.out.print(fibo(i) + " ");
        }

    }
}
