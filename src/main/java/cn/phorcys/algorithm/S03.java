package cn.phorcys.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Wonder
 * @Date: Created on 2021/10/31 下午3:04
 */
public class S03 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> repeatSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!repeatSet.add(nums[i])) return nums[i];
        }
        return -1;
    }
}
