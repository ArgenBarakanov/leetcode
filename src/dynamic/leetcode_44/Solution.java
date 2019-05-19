package dynamic.leetcode_44;
//Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
//
//        '?' Matches any single character.
//        '*' Matches any sequence of characters (including the empty sequence).
//        The matching should cover the entire input string (not partial).
//
//        Note:
//
//        s could be empty and contains only lowercase letters a-z.
//        p could be empty and contains only lowercase letters a-z, and characters like ? or *.
//        Example 1:
//
//        Input:
//        s = "aa"
//        p = "a"
//        Output: false
//        Explanation: "a" does not match the entire string "aa".
//        Example 2:
//
//        Input:
//        s = "aa"
//        p = "*"
//        Output: true
//        Explanation: '*' matches any sequence.
//        Example 3:
//
//        Input:
//        s = "cb"
//        p = "?a"
//        Output: false
//        Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
//        Example 4:
//
//        Input:
//        s = "adceb"
//        p = "*a*b"
//        Output: true
//        Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
public class Solution {
    //    ""  *  a  *  b

    // ""  T  T  F  T  F

    // a   F  T  T  T  F

    // d   F  T  F  T  F

    // c   F  T  F  T  F

    //e    F  T  F  T  F

    //b    F  T  F  T  T
    // если буквы одинаковые или стоит знак вопроса то берем из предыдущей по диагонали тип не включаем  по символу из паттерна и текста
    // если звездочка то берем либо слева либо сверху так как либо звездочка это пустая строка либо включает в себя символ из текста
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[0][0]=true;
        for(int j=0;j<pLen;j++){
            if(p.charAt(j)=='*')dp[0][j+1]=dp[0][j];//первая строчка в матрице
        }
        for(int i=0;i<sLen;i++){
            for(int j=0;j<pLen;j++){
                if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')dp[i+1][j+1]=dp[i][j];
                else if(p.charAt(j)=='*')dp[i+1][j+1]=dp[i+1][j] || dp[i][j+1];
            }
        }
        return dp[sLen][pLen];
    }
}
