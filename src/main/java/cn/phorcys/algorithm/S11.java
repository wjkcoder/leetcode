package cn.phorcys.algorithm;

/**
 * @Author: Wonder
 * @Date: Created on 2021/11/1 下午2:42
 */
public class S11 {
    public int minArray(int[] numbers) {
        if (numbers.length == 0) return 0;
        if (numbers.length == 1) return numbers[0];
        if (numbers[0] < numbers[numbers.length - 1]) return numbers[0];
        /*左边*/
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[right] > numbers[mid]) {
                right = mid;
            } else if (numbers[right] < numbers[mid]) {
                left = mid + 1;
            } else left++;
        }
        return numbers[left];
    }
}
