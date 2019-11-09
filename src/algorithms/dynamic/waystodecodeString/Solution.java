package algorithms.dynamic.waystodecodeString;

import java.util.Arrays;

public class Solution {


    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return explore(s,0,dp);
    }

    public int explore(String str, int idx,int[] dp) {
        if (str.length() <= idx) {
            return 1;
        }

        if(dp[idx]>-1)return dp[idx];
        int totalWays = 0;
        for (int i = 1; i <= 2; i++) {
            if (idx + i <= str.length()) {
                String snippet = str.substring(idx, idx + i);//берем каждую возможность. это один символ и два символа
                if (valid(snippet)) {//если это валидное значение
                    totalWays+=explore(str, idx + i,dp);
                }
            }
        }
        dp[idx] = totalWays;
        return dp[idx];
    }

    public boolean valid(String snippet) {
        if (snippet.length() == 0 || snippet.charAt(0) == '0') {
            return false;
        }

        int value = Integer.parseInt(snippet);

        return value >= 1 && value <= 26;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDecodings("222"));
    }
}
