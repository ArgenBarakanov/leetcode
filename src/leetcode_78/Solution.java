package leetcode_78;

import java.util.ArrayList;
import java.util.List;

//Given a set of distinct integers, nums, return all possible subsets (the power set).
//
//        Note: The solution set must not contain duplicate subsets.
//
//        Example:
//
//        Input: nums = [1,2,3]
//        Output:
//        [
//        [3],
//        [1],
//        [2],
//        [1,2,3],
//        [1,3],
//        [2,3],
//        [1,2],
//        []
//        ]
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0)
            return null;
        List<List<Integer>> result = new ArrayList<>();//пустоемножество
        result.add(new ArrayList<>());
        List<Integer> l = new ArrayList<>();
        l.add(nums[0]);
        result.add(l);//первый элемент
        for(int i = 1; i < nums.length;i++)
        {
            int j = result.size();//запоминаем размер листа
            for(int k = 0; k<j;k++)
            {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);// и к каждому добавляем число из массива
                temp.addAll(result.get(k));
                result.add(temp);
            }
        }
        return result;
    }
}
