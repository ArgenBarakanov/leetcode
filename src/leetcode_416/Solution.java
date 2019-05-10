package leetcode_416;

import java.util.Arrays;

//Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
//
//        Note:
//
//        Each of the array element will not exceed 100.
//        The array size will not exceed 200.
//
//
//        Example 1:
//
//        Input: [1, 5, 11, 5]
//
//        Output: true
//
//        Explanation: The array can be partitioned as [1, 5, 5] and [11].
public class Solution {
    public static  boolean canPartition(int[] nums) {
        int sum = 0;
        int target = 0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0)return false;
        target=sum/2;//половина суммы массива нужно найти
        Arrays.sort(nums);
        return dfs(nums,target,0);
    }

    public static boolean dfs(int[] nums,int target,int index){
        if(target==0)return true;
        for(int i=index;i<nums.length&&nums[i]<=target;i++){
            if(i>index&&nums[i]==nums[i-1])continue;//лишние вызовы функции
            if(dfs(nums,target-nums[i],i+1)){
                return true;
            }
        }
        return false;
    }
}
