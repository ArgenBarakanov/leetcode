package leetcode_198;

import java.util.Arrays;

//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//        Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
//
//        Example 1:
//
//        Input: [1,2,3,1]
//        Output: 4
//        Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//        Total amount you can rob = 1 + 3 = 4.
public class Solution {
    public static int rob(int[] nums) {
        int mas[] = new int[nums.length+1];
        Arrays.fill(mas,-1);
        return rob2(nums,nums.length-1,mas);
    }
    public static int rob2(int[] nums,int index,int[] mas) {
        if(index<0)
            return 0;//если вышли за пределы то веренм ноль
        if(mas[index]>=0)//если уже заполнен то вернем его значение
            return mas[index];
        int max =  Math.max(nums[index]+rob2(nums,index-2,mas),rob2(nums,index-1,mas));//максимум из текущего плюс предыдущее или перед последним
        mas[index]=max;//присваиваем
        return max;
    }
}
