package thread;

/**
 * 两个猴子，n个苹果，一个一次拿两个，一个一次拿三个，直到苹果不够两个人中的任何一个拿的时候就停止
 */
public class SubInTurn {
    private static int appleCount = 1234;

    private synchronized void getApple2() {
        while (appleCount >= 2) {
            appleCount = appleCount - 2;
            System.out.println("猴子拿了2个，还剩" + appleCount);
            this.notify();
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void getApple3() {
        while (appleCount >= 3) {
            appleCount = appleCount - 3;
            System.out.println("猴子拿了3个，还剩" + appleCount);
            this.notify();
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SubInTurn subInTurn = new SubInTurn();
        Thread t2 = new Thread(subInTurn::getApple2);
        Thread t3 = new Thread(subInTurn::getApple3);
        t2.start();
        t3.start();
    }
}
