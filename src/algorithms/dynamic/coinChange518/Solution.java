package algorithms.dynamic.coinChange518;

//You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
public class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];


        dp[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {


            dp[i][0] = 1;//чтобы из всяких монет вывести ничего у нас только один способ - ничего не делать

            for (int j = 1; j <= amount; j++) {

                int currentCoinValue = coins[i-1];//текущая монета


                int withoutThisCoin = dp[i-1][j];//количество способов получить без текущей монеты
                int withThisCoin = currentCoinValue <= j ? dp[i][j - currentCoinValue] : 0;//количество способов если добавим монету

                dp[i][j] = withoutThisCoin + withThisCoin;//наш ответ для подпроблемы
            }
        }

        for(int[] arr : dp){
            for(int i : arr) System.out.print(i+" ");
            System.out.println();
        }
        return dp[coins.length][amount];
    }

}
