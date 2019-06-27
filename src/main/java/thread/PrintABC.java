package thread;

/**
 * 三个线程轮流打印
 */
class PrintTask implements Runnable {
    private int times = 0;

    @Override
    public void run() {
        while (times < 30) {
            synchronized (this) {
                if (times % 3 == 0) {
                    if ("a".equals(Thread.currentThread().getName())) {
                        System.out.print("a");
                        times++;
                        this.notifyAll();
                    } else {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (times % 3 == 1) {
                    if ("b".equals(Thread.currentThread().getName())) {
                        System.out.print("b");
                        times++;
                        this.notifyAll();
                    } else {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (times % 3 == 2) {
                    if ("c".equals(Thread.currentThread().getName())) {
                        System.out.print("c");
                        times++;
                        this.notifyAll();
                    } else {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

public class PrintABC {
    public static void main(String[] args) {
        PrintTask task = new PrintTask();
        Thread a = new Thread(task);
        a.setName("a");
        Thread b = new Thread(task);
        b.setName("b");
        Thread c = new Thread(task);
        c.setName("c");
        a.start();
        b.start();
        c.start();
    }
}