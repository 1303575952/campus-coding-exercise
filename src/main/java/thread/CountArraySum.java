package thread;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/**
 * 5个线程分别计算一个数组的和，主线程汇总结果
 */
public class CountArraySum {
    private static final int totalThread = 5;
    private static Vector<int[]> arrList = new Vector<int[]>(totalThread);

    static {
        arrList.add(new int[]{1, 1, 1});
        arrList.add(new int[]{2, 2, 2});
        arrList.add(new int[]{3, 3, 3});
        arrList.add(new int[]{4, 4, 4});
        arrList.add(new int[]{5, 5, 5});
    }

    private static Vector<Integer> list = new Vector<Integer>();
    public static CountDownLatch countDownLatch = new CountDownLatch(totalThread);

    static class CountThread extends Thread {
        private int[] arr;

        @Override
        public void run() {
            arr = arrList.get(0);
            arrList.remove(0);
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            list.add(sum);
            countDownLatch.countDown();
        }

    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < totalThread; i++) {
            CountThread countThread = new CountThread();
            countThread.start();
        }
        countDownLatch.await();
        int arrSum = 0;
        for (int i = 0; i < totalThread; i++) {
            arrSum += list.get(i);
        }
        System.out.println(arrSum);
    }
}
