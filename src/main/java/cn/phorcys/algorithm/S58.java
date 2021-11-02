package cn.phorcys.algorithm;

import javax.crypto.spec.PSource;

/**
 * @Author: Wonder
 * @Date: Created on 2021/10/29 下午3:27
 */
public class S58 {
    /*左旋转字符串*/
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        reverse(chars, 0, n - 1);
        reverse(chars, n, length - 1);
        reverse(chars, 0, length - 1);
        return new String(chars);
    }

    public void reverse(char[] chars, int start, int end) {
        int length = chars.length;
        if (end >= length || start >= end) {
            return;
        }
        int sum = start + end;
        for (int i = start; i <= end && 2 * i < sum; i++) {
            char temp = chars[i];
            chars[i] = chars[sum - i];
            chars[sum - i] = temp;
        }
    }

    public static void main(String[] args) {
        String out = new S58().reverseLeftWords("abcdefg", 2);
        System.out.println(out);
    }
}
