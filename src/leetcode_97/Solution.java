package leetcode_97;
//Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
//
//        Example 1:
//
//        Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//        Output: true
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        Boolean[][] memo = new Boolean[n][m];
        if (n + m != s3.length()) {
            return false;
        }
        return helper(s1, 0, s2, 0, s3, 0, memo);
    }
    boolean helper(String s1, int p1, String s2, int p2, String s3, int p3, Boolean[][] memo) {
        if (p1 == s1.length()) {
            return s2.substring(p2).equals(s3.substring(p3));
        }
        if (p2 == s2.length()) {
            return s1.substring(p1).equals(s3.substring(p3));
        }
        if (memo[p1][p2] != null) {
            return memo[p1][p2];//мемоизация
        }
        boolean res = false;
        res = (s1.charAt(p1) == s3.charAt(p3) && helper(s1, p1 + 1, s2, p2, s3, p3 + 1, memo))//сравниваемпоочередно по одной букве
                || (s2.charAt(p2) == s3.charAt(p3) && helper(s1, p1, s2, p2 + 1, s3, p3 + 1, memo));//и  остальная часть строк
        memo[p1][p2] = res;//заносим в память
        return res;
    }
}
