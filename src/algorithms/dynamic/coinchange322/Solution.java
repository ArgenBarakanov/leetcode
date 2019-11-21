package algorithms.dynamic.coinchange322;

import java.util.Arrays;

//You are given coins of different denominations and a total amount of money amount.
//        Write a function to compute the fewest number of coins that you need to make up that amount.
//        If that amount of money
//        cannot be made up by any combination of the coins, return -1.
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount+1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,max);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j =0;j<coins.length;j++){
                if(coins[j]<=i){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]==max?-1:dp[amount];
    }
}
