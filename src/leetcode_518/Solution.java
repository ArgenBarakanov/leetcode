package leetcode_518;

import java.util.*;

//You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
//
//
//
//        Example 1:
//
//        Input: amount = 5, coins = [1, 2, 5]
//        Output: 4
//        Explanation: there are four ways to make up the amount:
//        5=5
//        5=2+2+1
//        5=2+1+1+1
//        5=1+1+1+1+1
public class Solution {
    public static void main(String... args){
        Solution s = new Solution();
        int[] arr = {1,2,5};
        System.out.println(s.change(5,arr));
    }


    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];

  /*
    Max ways to make change for 0 will be 1, doing nothing.
  */
        dp[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {

    /*
      Set the subproblem for the amount of 0 to 1 when
      solving this row
    */
            dp[i][0] = 1;

            for (int j = 1; j <= amount; j++) {

                int currentCoinValue = coins[i-1];

      /*
        dp[i][j] will be the sum of the ways to make change not considering
        this coin (dp[i-1][j]) and the ways to make change considering this
        coin (dp[i][j] - currentCoinValue] ONLY if currentCoinValue <= j, otherwise
        this coin can not contribute to the total # of ways to make change at this
        sub problem target amount)
      */
                int withoutThisCoin = dp[i-1][j];
                int withThisCoin = currentCoinValue <= j ? dp[i][j - currentCoinValue] : 0;

                dp[i][j] = withoutThisCoin + withThisCoin;
            }
        }

  /*
    The answer considering ALL coins for the FULL amount is what
    we want to return as the answer
  */
        return dp[coins.length][amount];
    }



}
