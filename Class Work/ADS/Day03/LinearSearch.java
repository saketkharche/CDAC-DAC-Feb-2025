package Day03;

import java.util.Scanner;

//Linear Search in java
public class LinearSearch {
    public static int linearSearch(int[] arr, int key) {
        //Go through each number in the array
        for (int i= 0;i<arr.length;i++) {
            if (arr[i] == key) {//if number found ,return its position
                return i;
            }
        }
        return -1;//if number not found, return -1
    }

    public static void main(String[] args) {
        int[] number = {8, 5, 7, 9, 2, 4, 6, 1, 3};//list of number
        System.out.println("Enter the number to be searched: ");
        Scanner sc = new Scanner(System.in);

        int target = sc.nextInt();//number to find

        int index = linearSearch(number, target);

        if (index != -1) {
            System.out.println("Number " + target + " found at index " + index);
        } else {
            System.out.println("Number " + target + " not found!");
        }
    }
}
