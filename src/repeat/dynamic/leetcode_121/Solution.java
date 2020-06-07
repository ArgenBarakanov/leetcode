package repeat.dynamic.leetcode_121;

public class Solution {
    public int maxProfit(int[] prices) {
       if(prices == null || prices.length == 0) return 0;
       int minPrice = prices[0];
       int maxProfit = 0;
       for(Integer i: prices){
           minPrice = Math.min(minPrice,i);
           maxProfit = Math.max(maxProfit, i - minPrice);
       }
       return maxProfit;
    }
}
