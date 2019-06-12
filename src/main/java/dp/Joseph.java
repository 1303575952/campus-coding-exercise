package dp;

/**
 * 约瑟夫环
 * <p>
 * f(1,m) = 0;            (n=1)
 * f(n,m)=(f(n-1,m)+m)%n; (n>1)
 */
public class Joseph {
    public int getResult(int n, int m) {
        if (n < 0 || m < 0) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; ++i) {
            last = (last + m) % i;
        }
        // 因为实际编号为(1~n)
        return (last + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Joseph().getResult(5, 3));
    }
}