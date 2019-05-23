package sort.quicksort;

import java.util.Arrays;
import java.util.Stack;

/**
 * 快速排序非递归
 */
public class QuickSortNonRecursion {
    private static void quicksort(int[] arr) {
        int n = arr.length - 1;
        quicksort(arr, 0, n);
    }

    // start和end为前闭后闭
    private static void quicksort(int[] arr, int start, int end) {
        // 用栈模拟
        Stack<Integer> stack = new Stack<>();
        if (start < end) {
            stack.push(end);
            stack.push(start);
            while (!stack.isEmpty()) {
                int l = stack.pop();
                int r = stack.pop();
                int index = partition(arr, l, r);
                if (l < index - 1) {
                    stack.push(index - 1);
                    stack.push(l);
                }
                if (r > index + 1) {
                    stack.push(r);
                    stack.push(index + 1);
                }
            }
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        while (start < end) {
            while (start < end && arr[end] >= pivot)
                end--;
            arr[start] = arr[end];
            while (start < end && arr[start] <= pivot)
                start++;
            arr[end] = arr[start];
        }
        arr[start] = pivot;
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 3};
        quicksort(arr);
        System.out.println(Arrays.toString(arr)); // [2, 3, 5, 10]
    }
}