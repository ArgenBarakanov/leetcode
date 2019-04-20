package leetcode_209;
//Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
//
//        Example:
//
//        Input: s = 7, nums = [2,3,1,2,4,3]
//        Output: 2
//        Explanation: the subarray [4,3] has the minimal length under the problem constraint.
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int sum =0;
        int slow=0,fast =0;
        int min = Integer.MAX_VALUE;
        while(fast<nums.length)//два поинтера. правый идет до тех пор пока сумма меньше цели если уже выше то двигаем левый . в обоих случаях  обновляю минимум
        {
            if(sum<s)
            {
                sum+=nums[fast++];
                if(fast==nums.length)
                {
                    while(sum>=s)
                    {
                        min = Math.min(min,fast-slow);
                        sum-=nums[slow++];
                    }
                }
            }
            if(sum>=s)
            {
                min = Math.min(min,fast-slow);
                sum-=nums[slow++];
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
