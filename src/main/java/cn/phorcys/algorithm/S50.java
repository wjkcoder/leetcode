package cn.phorcys.algorithm;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Author: Wonder
 * @Date: Created on 2021/10/31 下午3:35
 */
public class S50 {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                Integer old = map.get(c);
                map.put(c, old + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return ' ';
    }

    public static void main(String[] args) {
        char leetcode = new S50().firstUniqChar("leetcode");
        System.out.println(leetcode);
    }
}
