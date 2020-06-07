package repeat.dynamic.leetcode_91;

public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
// к примеру  строка 2  1  3
//                 1 1  2  3
// мы можем рассматривать 3 как букву С и тогда мы можем расшифровать 213 как BAC или UC
// и если 13 в паре с предыдущей 1  то можем рассматривать как M   тогда есть варианты уже 3
// BAC UC BM