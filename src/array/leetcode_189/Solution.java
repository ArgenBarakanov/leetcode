package array.leetcode_189;
//Given an array, rotate the array to the right by k steps, where k is non-negative.
//
//        Example 1:
//
//        Input: [1,2,3,4,5,6,7] and k = 3
//        Output: [5,6,7,1,2,3,4]
//        Explanation:
//        rotate 1 steps to the right: [7,1,2,3,4,5,6]
//        rotate 2 steps to the right: [6,7,1,2,3,4,5]
//        rotate 3 steps to the right: [5,6,7,1,2,3,4]
public class Solution {
    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            temp[(i+k)%nums.length] = nums[i];//в временный массив засунем со сдвигом по остатку на длину массива
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=temp[i];//копиуем в исходный массив
        }
    }
}
