package string;

/**
 * 某物流派送员p，需要给 a、b、c、d. 4个快递点派送包裹，请问派送员需要选择什么样的路线，才能完成最短路程的派送。
 * 假设派送员的起点坐标(0,0)，派送路线只能沿着图中的方格边行驶，每个小格都是正方形，且边长为1，如p到d的距离就是4。
 * 随机输入n个派送点坐标，求输出最短派送路线值（从起点开始完成n个点派送并回到起始点的距离）。
 */

import java.util.Scanner;


/**
 * 节点定义
 */
class Point {
    // x坐标点
    int px;
    // y坐标点
    int py;

    public Point(int px, int py) {
        this.px = px;
        this.py = py;
    }

    /**
     * 两个点的距离计算
     */
    public int getLength(Point p) {
        return Math.abs(px - p.px) + Math.abs(py - p.py);
    }
}

/**
 * 主的实现类
 */
public class CourierShortestPath {

    static final Point START = new Point(0, 0);
    static int minPath = Integer.MAX_VALUE;

    public static int calMin(Point[] points, int n) {
        if (n == points.length) {

            int sum = points[0].getLength(START);
            for (int i = 1; i < points.length; i++) {
                sum = sum + points[i - 1].getLength(points[i]);
            }
            sum = sum + points[points.length - 1].getLength(START);
            minPath = Math.min(minPath, sum);
            return minPath;
        }
        for (int i = n; i < points.length; i++) {
            swap(points, n, i);
            calMin(points, n + 1);
            swap(points, n, i);
        }
        return minPath;
    }

    public static void swap(Point[] points, int i, int j) {
        if (i == j) return;
        Point temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //行数
        int pnum = Integer.parseInt(input.nextLine().trim());
        Point[] points = new Point[pnum];
        for (int i = 0; i < pnum; i++) {
            String[] locations = input.nextLine().trim().split(",");
            points[i] = new Point(Integer.parseInt(locations[0]), Integer.parseInt(locations[1]));
        }
        minPath = calMin(points, 0);
        System.out.println(minPath);
    }
}

