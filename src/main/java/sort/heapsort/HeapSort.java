package sort.heapsort;

import java.util.Arrays;

public class HeapSort {

    public static void heapsort(int[] arr) {
        int n = arr.length;
        // 注意，此时我们的堆是从0开始索引的
        // 从(最后一个元素的索引-1)/2开始
        // 最后一个元素的索引 = n-1
        for (int i = (n - 1 - 1) / 2; i >= 0; i--)
            shiftDown(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            shiftDown(arr, i, 0);
        }
    }

    // 交换堆中索引为i和j的两个元素
    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 优化的shiftDown过程, 使用赋值的方式取代不断的swap,
    // 该优化思想和我们之前对插入排序进行优化的思路是一致的
    private static void shiftDown(int[] arr, int n, int k) {

        int e = arr[k];
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j + 1] - arr[j] > 0)
                j += 1;

            if (e - arr[j] >= 0)
                break;

            arr[k] = arr[j];
            k = j;
        }
        arr[k] = e;
    }

    // 测试 HeapSort
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 3};
        heapsort(arr);
        System.out.println(Arrays.toString(arr)); // [2, 3, 5, 10]
    }
}
