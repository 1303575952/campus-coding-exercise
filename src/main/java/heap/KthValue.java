package heap;

import java.util.PriorityQueue;

/**
 * 找无序数组中第k大值
 */
public class KthValue {
    private int getKthValueInArr(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
        }
        for (int j = 0; j < k - 1; j++) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        System.out.println(new KthValue().getKthValueInArr(new int[]{4, 3, 2, 1}, 2));
    }
}
