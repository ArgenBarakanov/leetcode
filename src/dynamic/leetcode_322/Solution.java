package dynamic.leetcode_322;

import java.util.Arrays;

//You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
//
//        Example 1:
//
//        Input: coins = [1, 2, 5], amount = 11
//        Output: 3
//        Explanation: 11 = 5 + 5 + 1
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount+1;//максимум по умолчанию
        int[] dp = new int[amount+1];
        Arrays.fill(dp,max);
        dp[0]=0;//для нулевой суммы
        for(int i=1;i<=amount;i++){//для каждой суммы
            for(int j =0;j<coins.length;j++){
                if(coins[j]<=i){//если монета меньше чем сумма текущая
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);//максимум из текущего и текущий минус минимум  плюс один
                }
            }
        }
        return dp[amount]==max?-1:dp[amount];
    }
}
