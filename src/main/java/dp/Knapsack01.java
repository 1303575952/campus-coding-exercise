package dp;

public class Knapsack01 {
    /**
     * @param capacity 背包容积
     * @param w        商品体积数组
     * @param v        商品价值数组
     * @return 背包能容纳的最大价值
     */
    private int knapsack01(int capacity, int[] w, int[] v) {
        int[] w0 = new int[w.length + 1];
        w0[0] = 0;
        for (int i = 0; i < w.length; i++) {
            w0[i + 1] = w[i];
        }
        int[] v0 = new int[v.length + 1];
        v0[0] = 0;
        for (int j = 0; j < v.length; j++) {
            v0[j + 1] = v[j];
        }
        int[][] dp = new int[w0.length][capacity + 1];
        for (int i = 1; i < w0.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j < w0[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w0[i]] + v0[i]);
                }
            }
        }
        return dp[w.length][capacity];
    }

    public static void main(String[] args) {
        int capacity = 8;
        int[] w = {2, 3, 4, 5};
        int[] v = {3, 4, 5, 6};
        System.out.println(new Knapsack01().knapsack01(capacity, w, v));
    }
}
