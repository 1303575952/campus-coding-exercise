package dp;

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
                    longest[j] = longest[i] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (longest[i] > max) {
                max = longest[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new SubArrIncrease().getLength(new int[]{1, 3, 5, 2, 4, 6, 7, 8}));
    }
}
