package leetcode_55;

//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//        Each element in the array represents your maximum jump length at that position.
//
//        Determine if you are able to reach the last index.
//
//        Example 1:
//
//        Input: [2,3,1,1,4]
//        Output: true
//        Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
public class Solution {
    public boolean canJump(int[] nums) {
        int i =0;
        int max = nums[0];//максимум которого можно достичь из этой точки
        while(true)
        {
            if(max==0)
                break;//если истек максимум то все капут
            if(i==nums.length-1)
                break;
            i++;
            max--;
            max=Math.max(max,nums[i]);//все время берем большее на каждом этапе

        }
        return i==nums.length-1;
    }
}
