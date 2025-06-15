public class arrayprac {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };// array start with 0;
        System.out.println(arr.length);

        int a= arr.indexOf(7);
        System.out.println(a);
        System.out.println(arr[5]);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}