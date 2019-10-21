package array;

/**
 * 给定一个数组，除了一个数字出现一次，其他都出现三次，求出现一次的数。
 */
public class SingleNumberOtherTriple {
    public int singleNumber(int[] arr) {
        int[] bitCountForOne = new int[32];
        int res = 0;
        for (int i = 0; i < 32; i++) {
            for (int ii = 0; ii < arr.length; ii++) {
                bitCountForOne[i] += (arr[ii] >> i & 1);
            }

            res |= (bitCountForOne[i] % 3) << i;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 8, 3, 3, 1, 4, 6, 8, 6, 8, 1, 3};
        System.out.println(new SingleNumberOtherTriple().singleNumber(arr));
    }
}
