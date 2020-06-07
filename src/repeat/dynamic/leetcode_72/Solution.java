package repeat.dynamic.leetcode_72;

public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i = 0; i <=word1.length();i++)
        {
            dp[i][0] = i;
        }

        for(int i = 0;i<=word2.length();i++)
        {
            dp[0][i] = i;
        }

        for(int i = 1;i<=word1.length();i++)
        {
            for(int j = 1 ;j<=word2.length();j++)
            {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else
                {
                    int replace = dp[i - 1][j - 1];//берем  предыдущий результат (как бы не учитываем текущие символы из обоих слов) и если они не совпадат типа размениваем их
                    int delete = dp[i - 1][j]; // вставка в word1 букву из word2
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
