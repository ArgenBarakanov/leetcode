package leetcode_96;

//Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
//
// Example:
//
// Input: 3
// Output: 5
// Explanation:
// Given n = 3, there are a total of 5 unique BST's:
//
// 1 3 3 2 1
// \ / / / \ \
// 3 2 1 1 3 2
// / / \ \
// 2 1 2 3
public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;//при нуле одно дерево
        dp[1]=1;// при одном тоже одно дерево


        for(int i = 2 ;i<=n;i++)
        {
            for(int k = 1;k<=i;k++)
            {
                dp[i]+=dp[i-k]*dp[k-1];//поочереди крч перемещаем справо налево числа и считаем произведене. легче нарисовать
            }
        }
        return dp[n];
    }
}
