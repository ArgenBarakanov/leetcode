package repeat.backtracking.leetcode_46;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        return permute2(nums,0);
    }
    public static List<List<Integer>> permute2(int[] nums,int index) {

        List<List<Integer>> res = new ArrayList<>();
        if(index==nums.length-1)
        {

            List<Integer> temp = new ArrayList<>();
            temp.add(nums[index]);
            res.add(temp);
            return res;
        }
        else
        {

            List<List<Integer>> lists = permute2(nums,index+1);
            if(lists!=null)
            {
                for(List<Integer> l:lists)
                {
                    for(int i = 0 ;i<l.size()+1;i++)
                    {
                        List<Integer> temp = new ArrayList<>();
                        temp.addAll(l);
                        temp.add(i,nums[index]);
                        res.add(temp);
                    }
                }
            }
            return res;
        }

    }
}
