package leetcode_300;
//Given an unsorted array of integers, find the length of longest increasing subsequence.
//
//        Example:
//
//        Input: [10,9,2,5,3,7,101,18]
//        Output: 4
//        Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
public class Solution {
    public static void main(String... args){
        int[] array = {10,9,2,5,3,7,101,18};
        System.out.println(1<<3);
    }

    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        int[] dp = new int[nums.length];
        dp[0]=1; //как минимум  последовательность из одного числа возрастает
        int max = 1;
        int max1=0;
        for(int i =1;i<nums.length;i++){
            max1 = 0;//по умолчанию каждое число в массиве не имеет тех кто меньше чем оно само
            for(int j =0 ; j<i;j++){
                if(nums[i]>nums[j]){
                    max1 = Math.max(max1,dp[j]);//типа если он больше то восходящее как минимум такое же как у того что меньше чем он сам
                }//если число в массиве больше какого то своего предшественника
            }
            dp[i]=max1+1;//включаем текущее число
            max = Math.max(max,dp[i]);//обновляем максимум
        }
        return max;
    }
}
