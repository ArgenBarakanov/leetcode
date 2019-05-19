package string.leetcode_38;

//Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
//        You may assume no duplicates in the array.
//
//        Example 1:
//
//        Input: [1,3,5,6], 5
//        Output: 2
//        Example 2:
//
//        Input: [1,3,5,6], 2
//        Output: 1
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int position = -1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>=target)//если больше или равен то вернем этот индекс
            {
                position=i;
                break;
            }
        }
        if(position==-1)
            return nums.length;
        else if(position==0)
            return 0;
        return position;
    }
}
