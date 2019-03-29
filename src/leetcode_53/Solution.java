package leetcode_53;

//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//
//        Example:
//
//        Input: [-2,1,-3,4,-1,2,1,-5,4],
//        Output: 6
//        Explanation: [4,-1,2,1] has the largest sum = 6.
public class Solution {
    public int maxSubArray(int[] nums) {
        int curentMax = nums[0];//нужна для динамического программирования
        int maxSum =nums[0];//переменная которая хрнаит результат
        for(int i = 1;i<nums.length;i++)
        {
            if(curentMax<0)//если текущая сумма меньше нуля то стоит завести новую переменную
                curentMax = nums[i];
            else
            {
                curentMax+=nums[i];//иначе просто увеличиваем на элемент массива
            }
            maxSum = Math.max(curentMax,maxSum);//выбираем максимум из двух

        }
        return maxSum;
    }
}