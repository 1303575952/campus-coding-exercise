package array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 合并k个有序数组
 */
class Element {
    public int row, col, val;

    Element(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}

public class MergeKArray {
    // 从小到大排序
    private Comparator<Element> ElementComparator = new Comparator<Element>() {
        public int compare(Element left, Element right) {
            return left.val - right.val;
        }
    };

    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    public int[] mergekSortedArrays(int[][] arrays) {
        if (arrays == null) {
            return new int[0];
        }

        int total_size = 0;
        // 默认由小到大顺序
        Queue<Element> Q = new PriorityQueue<Element>(
                arrays.length, ElementComparator);

        // 初始化
        // 把每一行的第一个元素加入 PriorityQueue
        // 顺便统计元素总量
        for (int i = 0; i < arrays.length; i++) {
            // 当前行长度不为 0
            if (arrays[i].length > 0) {
                Element elem = new Element(i, 0, arrays[i][0]);
                Q.add(elem);
                total_size += arrays[i].length;
            }
        }

        int[] result = new int[total_size];
        int index = 0;
        while (!Q.isEmpty()) {
            Element elem = Q.poll();
            result[index++] = elem.val;
            // 当前结点被 PriorityQueue 抛出来后，当前行的第二个结点加入 PriorityQueue
            if (elem.col + 1 < arrays[elem.row].length) {
                elem.col += 1;
                elem.val = arrays[elem.row][elem.col];
                Q.add(elem);
            }
        }

        return result;
    }
}