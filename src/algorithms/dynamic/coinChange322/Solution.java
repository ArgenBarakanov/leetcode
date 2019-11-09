package algorithms.dynamic.coinChange322;

//You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1
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
