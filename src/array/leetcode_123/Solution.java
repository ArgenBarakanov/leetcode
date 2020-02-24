package array.leetcode_123;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[3][prices.length];
        for (int k = 1; k <= 2; k++) {
            int min = prices[0];// для каждой транзакции
            for (int i = 1; i < prices.length; i++) {
                //находим так чтобы цена была наименьшей а первая транзакция наибольшей
                min = Math.min(min, prices[i] - dp[k - 1][i - 1]);
                // мы находим такую цену чтоб если от нее отнять первую транзакцию то получим максимальный минимум. это означает что
                //с такой ценой продав ее в будущем мы найдем наиболее подходящий день для продажи. крч очень сложно. на вью если спросят сделай попроще а затем вспомнишь
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min);//эта штука необязательно меняется каждую итерацию
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[2][prices.length - 1];
    }

    public static void main(String[] args) {
        int[] price = {3, 3, 5, 0, 3, 1, 4};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(price));
    }
}
