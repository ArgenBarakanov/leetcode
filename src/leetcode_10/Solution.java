package leetcode_10;
//Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
//
//        '.' Matches any single character.
//        '*' Matches zero or more of the preceding element.
//        The matching should cover the entire input string (not partial).
//
//        Note:
//
//        s could be empty and contains only lowercase letters a-z.
//        p could be empty and contains only lowercase letters a-z, and characters like . or *.
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
//        p = "a*"
//        Output: true
//        Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
//        Example 3:
//
//        Input:
//        s = "ab"
//        p = ".*"
//        Output: true
//        Explanation: ".*" means "zero or more (*) of any character (.)".
//        Example 4:
//
//        Input:
//        s = "aab"
//        p = "c*a*b"
//        Output: true
//        Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
public class Solution {
    //  ""  c  *  a  *  b
    //"" T  F  T  F  T  F

    //a  F  F  F  T  T  F

    //a  F  F  F  F  T  F

    //b  F  F  F  F  F  T
    //если встречаем точку то заносим значение будто бы нет последнего символа в паттерне и тексте
    // если две буквы равны то то же самое что и для точки
    //если звездочка то у нас три варианта :
    //1) буквы не равны и в паттерне на этом месте не точка .не учитваем в паттерне два последних символа и смотрим истинно ли значение в этой ячейке
    //2) буквы равны и тогда условие или для паттерна без двух букв и текста без последней буквы
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];

        dp[0][0] = true;
        for(int j = 1; j <= m; j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-2];
            }
        }

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++){
                if(p.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    // the preceding element not matches
                    if(p.charAt(j-2) != '.' && p.charAt(j-2) != s.charAt(i-1)){
                        dp[i][j] = dp[i][j-2];
                    }else{
                        dp[i][j] =  dp[i][j-2] || dp[i-1][j];
                    }
                }else{
                    dp[i][j] = dp[i-1][j-1] && s.charAt(i-1) == p.charAt(j-1);
                }
            }
        }
        return dp[n][m];
    }
}
