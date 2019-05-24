package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中第一个出现次数最多的字符
 */
public class MostCharInString {
    private static char calMostChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char ch = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
                if (map.get(str.charAt(i)) > map.get(ch)) {
                    ch = str.charAt(i);
                }
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        return ch;
    }

    public static void main(String[] args) {
        System.out.println(calMostChar("fjnsdkjfhxwjdhdd"));
    }
}
