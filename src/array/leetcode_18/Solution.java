package array.leetcode_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
//
//        Note:
//
//        The solution set must not contain duplicate quadruplets.
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
    public  List<List<Integer>> kSum(int[] nums, int target,int index,int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(k==2)//если k=2 то суммируем два числа с концов и сравниваем с таргет
        {
            int i = index;
            int j = nums.length-1;
            while(i<j)
            {
                int sum = nums[i]+nums[j];
                if(sum==target)
                {
                    List<Integer> temp = new ArrayList<>();

                    temp.add(nums[i]); //добавляем в локальный лист
                    temp.add(nums[j]);
                    result.add(temp);
                    while(i<j && nums[i]==nums[i+1]) i++; //пропустить дубликаты
                    while(i<j && nums[j-1]==nums[j]) j--;//пропустить дубликаты
                    i++;
                    j--;
                }
                else if(sum<target)
                    i++;
                else
                    j--;

            }
        }
        else
        {//иначе рекурсивно вызываем с другими параметрами
            for(int i = index;i<nums.length-k+1;i++)
            {
                List<List<Integer>> temp = kSum(nums,target-nums[i],i+1,k-1);
                if(temp!=null)
                {
                    for (List<Integer> t : temp) {
                        t.add(0, nums[i]);//добавляем к текущему результату
                    }
                    result.addAll(temp);// все в резалт и скипаем одинаковые числа
                }
                while (i < nums.length-1 && nums[i] == nums[i+1]) {
                    //skip duplicated numbers
                    i++;
                }
            }
        }
        return result;
    }
}
