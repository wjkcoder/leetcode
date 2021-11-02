package cn.phorcys.algorithm;

/**
 * @Author: Wonder
 * @Date: Created on 2021/10/31 下午3:07
 */
public class S53 {
    public int search(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                while (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                    i++;
                    count++;
                }
                return count;
            }
        }
        return 0;
    }

    public int missingNumber(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length==1)return nums[0]==0?1:0;
        if(nums[0]==1)return 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1] - 1) return nums[i] + 1;
        }
        return nums[nums.length - 1] + 1;
    }
}
