package Day02.Assignment1;

public class Q1 {
    static void SeriesOfNumbers(int n) {
        if (n == 0) {
            return;
        } else {
            SeriesOfNumbers(n - 1);
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        int n=15;
        SeriesOfNumbers(n);
    }
}
