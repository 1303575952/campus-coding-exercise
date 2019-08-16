package dp;

import java.util.Arrays;

/**
 * 最长递增子序列
 * <p>
 * {1, 3, 5, 2, 4, 6, 7, 8}的最长子序列为{1, 3, 4, 6, 7, 8}
 */
public class SubArrIncrease {
    private int getLength(int[] arr) {
        int[] longest = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            longest[i] = 1;
        }
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < j; i++) {
                if (arr[j] > arr[i]) {
                    longest[j] = longest[j] > (longest[i] + 1) ? longest[j] : (longest[i] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(longest));
        return longest[longest.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new SubArrIncrease().getLength(new int[]{1, 3, 5, 2, 1, 4, 6, 7, 8}));
    }
}
