
import java.util.Scanner;

class Q5{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number :");
        int a = sc.nextInt();

        System.out.println("Enter second number :");
        int b = sc.nextInt();

        a += b;
        b = a-b;
        a -= b;
        System.out.println("After Swapping");
        System.out.println("First number is :"+a);
        System.out.println("Second number is :"+b);

    }
}