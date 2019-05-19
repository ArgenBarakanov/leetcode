package array.leetcode_238;
//Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
//
//        Example:
//
//        Input:  [1,2,3,4]
//        Output: [24,12,8,6]
//        Note: Please solve it without division and in O(n).
//
//        Follow up:
//        Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];//произведение всех чисел слева и
        // справа от числа в массиве
        int[] left = new int[nums.length];
        left[0]=1;//базовый случай
        int[] right = new int[nums.length];
        right[nums.length-1]=1;
        for(int i =1;i<nums.length;i++){
            left[i]=nums[i-1]*left[i-1];//считаем произведение со всех сторон (слевой и справой)
        }
        for(int i=nums.length-2;i>=0;i--){
            right[i]=nums[i+1]*right[i+1];
        }
        for(int i=0;i<res.length;i++){
            res[i]=left[i]*right[i];// в конце перемножаем левую и правую части
        }
        return res;
    }
}
