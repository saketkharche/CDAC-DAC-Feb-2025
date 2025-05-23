package Day09;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;

class ForkSimulation extends Thread {
    int i;

    public ForkSimulation(int i) {
        this.i = i;
    }

    public void run() {
        System.out.println("[" + Thread.currentThread().getId() + "] i=" + i);
    }
}

class ParallelMergeSort extends RecursiveAction {
    private int[] arr;
    private int left, right;

    public ParallelMergeSort(int[] arr, int left, int right) {
        this.arr = arr;
        this.left = left;
        this.right = right;
    }

    protected void compute() {
        if (left < right) {
            int mid = (left + right) / 2;

            ParallelMergeSort leftTask = new ParallelMergeSort(arr, left, mid);
            ParallelMergeSort rightTask = new ParallelMergeSort(arr, mid + 1, right);

            invokeAll(leftTask, rightTask);

            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            arr[k++] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }
}

public class ForkAndMergeSort {
    public static void main(String[] args) {
        // Fork Simulation
        System.out.println("=== Fork Simulation ===");
        for (int i = 0; i < 3; i++) {
            new ForkSimulation(i).start();
        }

        // Parallel Merge Sort
        System.out.println("\n=== Parallel Merge Sort ===");
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Before Sorting: " + Arrays.toString(arr));

        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new ParallelMergeSort(arr, 0, arr.length - 1));

        System.out.println("After Sorting: " + Arrays.toString(arr));
    }
}
