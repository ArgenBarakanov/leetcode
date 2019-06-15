package binarysearch.leetcode_162;

public class Solution {//бинарный поииск работает. почему - на рисунке видно
    public int findPeakElement(int[] nums) {
        if(nums.length==1)
            return 0;
        int l = 0,r = nums.length-1;
        while(l<r)
        {
            int mid = (l+r)/2;
            if(nums[mid]<nums[mid+1])
                l = mid+1;
            else
                r = mid;
        }
        return l;
    }
}
