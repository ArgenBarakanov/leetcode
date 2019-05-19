package twopointers.leetcode_15;

import java.util.*;

//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
//        Note:
//
//        The solution set must not contain duplicate triplets.
//
//        Example:
//
//        Given array nums = [-1, 0, 1, 2, -1, -4],
//
//        A solution set is:
//        [
//        [-1, 0, 1],
//        [-1, -1, 2]
//        ]
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2;i++)
        {
            int low = i+1;//левая граница всегда на один больше
            int high = nums.length-1;//правый край скраю
            while(low<high)
            {
                int sum = nums[i]+nums[low]+nums[high];//сумма трех элементов
                if(sum==0)
                {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(nums[i]);
                    list1.add(nums[low]);
                    list1.add(nums[high]);
                    if(set.add(list1))
                    {
                        list.add(list1);
                    }

                    low++;//двигаем оба указателя
                    high--;
                }
                else if(sum>0)//если сумма больше надо уменьшить правый индекс
                    high--;
                else
                    low++;//и наоборот
            }
        }
        return list;
    }
}
