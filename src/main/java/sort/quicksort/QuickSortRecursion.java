package sort.quicksort;

import java.util.Arrays;

/**
 * 快速排序递归
 */
public class QuickSortRecursion {

    private static void quicksort(int[] arr) {
        int n = arr.length;
        quicksort(arr, 0, n - 1);
    }

    private static void quicksort(int[] arr, int start, int end) {
        if (arr == null || start >= end) {
            return;
        }
        int i = start, j = end;
        int pivotKey = arr[start];
        while (i < j) {
            while (i < j && arr[j] >= pivotKey) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i] <= pivotKey) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = pivotKey;
        quicksort(arr, start, i - 1);
        quicksort(arr, i + 1, end);
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 3};
        quicksort(arr);
        System.out.println(Arrays.toString(arr)); // [2, 3, 5, 10]
    }
}
