package array;

import java.util.Arrays;

/**
 * 合并两个有序数组
 */
public class Merge2Array {
    public static int[] merge(int[] a, int[] b) {

        int[] answer = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length)
            answer[k++] = a[i] < b[j] ? a[i++] : b[j++];

        while (i < a.length)
            answer[k++] = a[i++];


        while (j < b.length)
            answer[k++] = b[j++];

        return answer;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 8, 9};
        int[] b = {2, 3, 4, 5};
        System.out.println(Arrays.toString(merge(a, b)));
    }
}
