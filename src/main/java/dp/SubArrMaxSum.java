package dp;

/**
 * 数组里连续子序列和最大值
 * <p>
 * {6, -3, -2, 7, -1, 5, -8}符合条件子数组为{6, -3, -2, 7, -1, 5}
 */
public class SubArrMaxSum {
    /**
     * 空间复杂度O(n)
     *
     * @param arr
     * @return
     */
    private int getMaxSum1(int[] arr) {
        int max = Integer.MIN_VALUE;
        int[] cur = new int[arr.length];
        cur[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            cur[i] = Math.max(cur[i - 1] + arr[i], arr[i]);
        }
        for (int i = 0; i < cur.length; i++) {
            max = max > cur[i] ? max : cur[i];
        }
        return max;
    }

    /**
     * 时间复杂度o(1)
     *
     * @param arr
     * @return
     */
    private int getMaxSum2(int[] arr) {
        int max = Integer.MIN_VALUE;
        int cur = arr[0];
        for (int i = 1; i < arr.length; i++) {
            cur = Math.max(cur + arr[i], arr[i]);
            max = max > cur ? max : cur;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new SubArrMaxSum().getMaxSum2(new int[]{6, -3, -2, 7, -1, 5, -8}));
    }
}
