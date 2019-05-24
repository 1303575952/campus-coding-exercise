package array;

/**
 * 先递增后递减数组找到最大值
 */
public class ArrayPeak {
    private static int findPeak(int[] nums){
        if (nums != null && nums.length > 0) {
            if (nums.length == 1) {
                return 0;
            }
            if (nums[0] > nums[1]) {//数组单调递减
                return 0;
            }
            int index = nums.length-1;
            if (nums[index] > nums[index-1]) {//数组单调递增
                return index;
            }
            int i = 0, j = index;
            int mid = 0;
            while (i < j) {//二分查找
                mid = (i + j) / 2;
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (nums[mid] > nums[mid + 1]) {//处于下坡段, 即递减段
                    j = mid - 1;
                } else if (nums[mid] > nums[mid - 1]) {//处于上坡段, 即递增段
                    i = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findPeak(new int[]{3,2}));
    }
}
