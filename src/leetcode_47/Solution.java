package leetcode_47;

import java.util.ArrayList;
import java.util.List;
//Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
//        Example:
//
//        Input: [1,1,2]
//        Output:
//        [
//        [1,1,2],
//        [1,2,1],
//        [2,1,1]
//        ]
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        return permute2(nums,0);
    }
    public  List<List<Integer>> permute2(int[] nums,int index) {

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
                        temp.add(i, nums[index]);
                        if(res.contains(temp))//то же самое что и в 46 но скипаем одинаковые списки
                            continue;
                        res.add(temp);

                    }
                }
            }
            return res;
        }

    }
}
