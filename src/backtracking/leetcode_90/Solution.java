package backtracking.leetcode_90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
//
//        Note: The solution set must not contain duplicate subsets.
//
//        Example:
//
//        Input: [1,2,2]
//        Output:
//        [
//        [2],
//        [1],
//        [1,2,2],
//        [2,2],
//        [1,2],
//        []
//        ]
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length==0)
            return null;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        List<Integer> l = new ArrayList<>();
        l.add(nums[0]);
        result.add(l);
        for(int i = 1; i < nums.length;i++)
        {
            int j = result.size();
            for(int k = 0; k<j;k++)
            {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.addAll(result.get(k));
                if(!result.contains(temp))//если такие  уже есть то пропускаем а в остальном так же как и в предыдущем примере на подмножества
                {
                    result.add(temp);
                }
            }
        }
        return result;
    }
}
