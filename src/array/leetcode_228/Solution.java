package array.leetcode_228;

import java.util.ArrayList;
import java.util.List;

//Given a sorted integer array without duplicates, return the summary of its ranges.
//
//        Example 1:
//
//        Input:  [0,1,2,4,5,7]
//        Output: ["0->2","4->5","7"]
//        Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums==null||nums.length==0)
            return res;

        for(int i=0;i<nums.length;i++){
            int start = nums[i];//помечаем старт каждым элементом массива
            while(i+1<nums.length&&nums[i]+1==nums[i+1])//продолжаем стрим пока не закончится последовательность
            {
                i++;
            }
            if(start!=nums[i]){
                res.add(start+"->"+nums[i]);//заносим в результат
            }else{
                res.add(start+"");
            }

        }
        return res;
    }
}
