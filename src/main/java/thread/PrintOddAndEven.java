package thread;

/**
 * 交替打印奇偶数
 */
public class PrintOddAndEven {
    private int value = 0;

    private synchronized void printOdd() {
        while (value <= 100) {
            if (value % 2 == 1) {
                System.out.println(Thread.currentThread() + ": -" + value++);
                this.notify();
            } else {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    private synchronized void printEven() {
        while (value <= 100) {
            if (value % 2 == 0) {
                System.out.println(Thread.currentThread() + ": --" + value++);
                this.notify();
            } else {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PrintOddAndEven print = new PrintOddAndEven();
        Thread t1 = new Thread(print::printOdd);
        Thread t2 = new Thread(print::printEven);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
