package dp;

/**
 * 切割杆，现有长度为len的杆，价值数组是p[]，数组长度是len+1，已知长度i对应的价值是p[i]，
 * len为整数，杆仅能被切割为整数长度。
 * 比如长度1对应的价值数是p[1]。将其切割，求杆被切割后的最大价值。
 */
public class CutPole {
    private int findMaxValue(int len, int[] p) {
        int[] maxValue = new int[len + 1];
        if (len < 0) {
            throw new RuntimeException("杆的长度不可小于0");
        }
        if (len == 1) {
            return p[1];
        }
        maxValue[0] = 0;
        maxValue[1] = p[1];
        for (int i = 2; i <= len; i++) {
            int cutMax = 0;
            for (int j = 1; j <= i / 2; j++) {
                cutMax = cutMax > (maxValue[j] + maxValue[i - j]) ? cutMax : (maxValue[j] + maxValue[i - j]);
            }
            maxValue[i] = Math.max(p[i], cutMax);
        }
        for (int i = 0; i <= len; i++) {
            System.out.println(maxValue[i] + " ");
        }
        return maxValue[len];
    }

    public static void main(String[] args) {
        System.out.print(new CutPole().findMaxValue(10, new int[]{0, 2, 5, 6, 7, 10, 11, 11, 13, 13, 14}));
    }
}
