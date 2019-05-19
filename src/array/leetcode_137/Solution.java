package array.leetcode_137;

import java.util.Arrays;

//Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
//
//        Note:
//
//        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
public class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);//отсортирован  и просто....ну все и так понятно же
        for (int i = 0; i < nums.length; i += 3) {
            if(i+2 > nums.length || nums[i] != nums[i+2]) return nums[i];
        }
        return 0;
    }
}
