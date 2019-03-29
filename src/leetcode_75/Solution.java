package leetcode_75;

import java.util.Arrays;
//Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//
//        Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//
//        Note: You are not suppose to use the library's sort function for this problem.
//
//        Example:
//
//        Input: [2,0,2,1,1,0]
//        Output: [0,0,1,1,2,2]
public class Solution {
    public void sortColors(int[] nums) {
        int i1 = 0;//для 0
        int i2 = nums.length-1;//для 2
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);//заполнить все отрицательными
        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                res[i1++] = 0;//слева нули справа двойки а те что остались то это единицы
            }
            if(nums[i]==2)
            {
                res[i2--]=2;
            }
        }
        for(int i =0;i<res.length;i++)
        {
            if(res[i]==-1){
                res[i]=1;
                nums[i]=res[i];
            }
            else
            {
                nums[i]=res[i];
            }
        }
    }
}
