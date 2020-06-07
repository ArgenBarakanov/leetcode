package repeat.dynamic.leetcode_44;

public class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[0][0]=true;
        for(int j=0;j<pLen;j++){
            if(p.charAt(j)=='*')dp[0][j+1]=dp[0][j];//если * то  можем игнорировать  ее как пустую строку
            // и заносим предыдущий результат
        }
        for(int i=0;i<sLen;i++){
            for(int j=0;j<pLen;j++){
                if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')dp[i+1][j+1]=dp[i][j];// если совпадают или можем подставить ? то затираем у паттерна и у строки
                else if(p.charAt(j)=='*')dp[i+1][j+1]=dp[i+1][j] || dp[i][j+1];// иначе мы либо вносим символ в *, либо * пустая строка
            }
        }
        return dp[sLen][pLen];
    }
}
