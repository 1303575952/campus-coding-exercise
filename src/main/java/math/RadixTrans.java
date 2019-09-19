package math;

import java.util.*;

/**
 * 给定一个十进制正数M，以及需要转换的进制数N。 将十进制数M转化为N进制数
 * 输入描述: 输入为一行，M(32位整数)、N(2 ≤ N ≤** 16)，以空格隔开
 * 输出描述: 为每个测试实例输出转换后的数，每个输出占一行。 如果N大于9，则对应的数字规则参考16进制（比如，10用A表示，等等）
 */
public class RadixTrans {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        if (M > 0 && N > 0) {
            convert(M, N);
        }
    }

    public static void convert(int m, int n) {
        // 创建一个map对象，用来存储对应的字符
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "A");
        map.put(11, "B");
        map.put(12, "C");
        map.put(13, "D");
        map.put(14, "E");
        map.put(15, "F");

        // 如果是10进制，直接输出结束
        if (n == 10) {
            System.err.println(m);
            return;
        }

        // 创建一个栈
        Stack list = new Stack();

        // 对输入的数值进行计算，直到这个值=1
        // 这里主要使用短除法
        while (m > 0) {
            // 计算余数，7%2=1
            int yushu = m % n;
            // 如果是小于10的进制
            if (n < 10) {
                list.push(yushu);
            } else {
                // 如果大于10的进制，取出余数，并且找到对应的字母
                list.push((yushu > 9 ? map.get(yushu) : yushu));
            }
            m = m / n;
        }

        // 输出
        if (!list.isEmpty()) {
            Enumeration items = list.elements();
            while (items.hasMoreElements()) {
                System.out.print(list.pop());

            }
        }
    }
}
