package string;

import java.util.*;

/**
 * 有一个字符串，由26个字母组成，每个字母出现次数未知，设计算法，将26个字母按出现的频率由高到低排序
 */
public class CharSort {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String s = "shdfuehfhrufhdheufhfsjfuqoweptumnbvfutiypeyasywhylmnzbvcajdiwu";
        process(s);

    }

    public static void process(String s) {
        List<String> list = new ArrayList<>();
        String[] str = s.split("");

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < str.length; i++) {
            if (map.containsKey(str[i])) {
                int count = map.get(str[i]);
                map.put(str[i], count + 1);
            } else {
                map.put(str[i], 1);
            }
        }
        MapValueComparator mapValueComparator = new MapValueComparator(map);
        Map<String, Integer> sortmap = new TreeMap<String, Integer>(mapValueComparator);
        sortmap.putAll(map);

        String key = null;
        Iterator iter = sortmap.keySet().iterator();
        while (iter.hasNext()) {
            key = (String) iter.next();
            System.out.println(key);
        }
    }

}

class MapValueComparator<T extends Comparable<T>> implements Comparator<String> {

    private Map<String, T> map = null;

    public MapValueComparator(Map<String, T> map) {
        this.map = map;
    }

    public int compare(String o1, String o2) {
        int r = map.get(o2).compareTo(map.get(o1));
        if (r == 0) {
            r = 1;
        }
        return r;
    }
}
