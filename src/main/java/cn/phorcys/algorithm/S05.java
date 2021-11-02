package cn.phorcys.algorithm;

import java.util.Arrays;

/**
 * @Author: Wonder
 * @Date: Created on 2021/10/29 上午10:23
 */
public class S05 {
    public String replaceSpace(String s) {
        char[] newArr = new char[s.length() * 3];
        int point = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                newArr[point] = '%';
                newArr[point + 1] = '2';
                newArr[point + 2] = '0';
                point += 3;
            } else {
                newArr[point] = c;
                point += 1;
            }
        }
        return new String(newArr).substring(0, point);
    }

    public String replaceSpace2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
