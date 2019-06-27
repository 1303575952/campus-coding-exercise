package math;

/**
 * 打印101~200之间的所有素数并统计个数
 */
public class Prime {
    private boolean judgePrime(int num) {
        if (num <= 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Prime prime = new Prime();
        for (int i = 101; i <= 200; i++) {
            if (prime.judgePrime(i)) {
                System.out.println(i);
            }
        }
    }
}
