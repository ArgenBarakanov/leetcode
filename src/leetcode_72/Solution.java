package leetcode_72;

//Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
//
// You have the following 3 operations permitted on a word:
//
// Insert a character
// Delete a character
// Replace a character
// Example 1:
//
// Input: word1 = "horse", word2 = "ros"
// Output: 3
// Explanation:
// horse -> rorse (replace 'h' with 'r')
// rorse -> rose (remove 'r')
// rose -> ros (remove 'e')
public class Solution {
    public int minDistance(String word1, String word2) {
//тип от пустой строки к этому слову нужно добавить все эти символы
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i = 0; i <=word1.length();i++)
        {
            dp[i][0] = i;
        }

        for(int i = 0;i<=word2.length();i++)
        {
            dp[0][i] = i;
        }


//
        for(int i = 1;i<=word1.length();i++)
        {
            for(int j = 1 ;j<=word2.length();j++)
            {
                if(word1.charAt(i-1)==word2.charAt(j-1))//если смиволы совпали берем предыдущий строго снизу
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else //иначе минимум из этих трех
                {
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}