package repeat.dynamic.leetcode_96;

public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;//при нуле одно дерево
        dp[1]=1;// при одном тоже одно дерево


        for(int i = 2 ;i<=n;i++)
        {
            for(int k = 1;k<=i;k++)
            {
                dp[i]+=dp[i-k]*dp[k-1];// к это корневой узел k -1 это узлы слева от него i - k узлы справа
            }
        }
        return dp[n];
    }
}
