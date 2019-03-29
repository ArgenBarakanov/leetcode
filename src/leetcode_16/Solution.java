package leetcode_16;

import java.util.Arrays;

//16. 3Sum Closest
//        Medium
//
//        857
//
//        63
//
//        Favorite
//
//        Share
//        Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
//        Example:
//
//        Given array nums = [-1, 2, 1, -4], and target = 1.
//
//        The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];//результат равен по дефолту крч понятно же
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;//левая граница
            int high = nums.length - 1; //правая граница
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum < target)//если сумма больше желаемой
                    low++;
                else
                    high--;// если меньше
                int temp = Math.abs(target-sum);
                if(temp<Math.abs(target-result)) {//обновляем результат при необходимости
                    result = sum;

                }
            }
        }
        return result;
    }
}
