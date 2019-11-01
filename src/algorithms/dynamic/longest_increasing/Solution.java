package algorithms.dynamic.longest_increasing;
/*

 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1; //базовый случай.
        int max = 1;
        for( int i = 1 ; i < nums.length; i++){
            dp[i] = 1;//для одного элемнта ответ всегда 1
            for(int j = 0; j < i; j++){
              if(nums[j]<nums[i]){//если есть числа меньшие чем текущее то мы для текущего обновляем максимум.
                  dp[i] = Math.max(dp[i],dp[j]+1);//предыдущее плюс 1 . легче нарисовать
              }
            }
            max = Math.max(max,dp[i]);//обновляем глобальный максимум
        }
        return max;
    }
}
