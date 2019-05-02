package leetcode_279;

import java.util.Arrays;

//Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
//
//        Example 1:
//
//        Input: n = 12
//        Output: 3
//        Explanation: 12 = 4 + 4 + 4.
//        Example 2:
//
//        Input: n = 13
//        Output: 2
//        Explanation: 13 = 4 + 9.
public class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i=1;i<=n;i++){
            int sqrt = (int)Math.sqrt(i);
            if(i==sqrt*sqrt){dp[i]=1;//идеальное совпадение
                continue;
            }
            for(int j = 1;j<=sqrt;j++){//если же нет то перебираем все квадраты до текущего квадрата и выбираем минимум из разницы плюс один
                int diff = i-j*j;
                dp[i]=Math.min(dp[i],dp[diff]+1);
            }
        }
        return dp[n];
    }
}
