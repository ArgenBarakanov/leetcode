package repeat.dynamic.leetcode_10;

public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < dp[0].length; i++) {
            // пустая строка может сматчиться с паттерном если  она в виде a*b*
            if (p.charAt(i - 1) == '*') dp[0][i] = dp[0][i - 2];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                char pChar = p.charAt(j - 1);
                char sChar = s.charAt(i - 1);
                if (pChar == '.' || pChar == sChar) {
                    //если символы в паттерне и строке совпадают то нужно проверить совпадают ли паттерн и строка без последних символов
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(pChar == '*') {
                    // если же в паттерне звездочка
                    // то мы игнорируем его и предшествующий символ надеясь что паттерн до этих двух символов совпадудт
                    // или если предыдущий символ из паттерна и символ из строки совпадают или точка
                    // то мы как бы учитваем символ из строки и надеемся что предыдущие символы матчились с паттерном
                    // как бы мы учитваем что символ из строки в последовательноти символов из предыдущей буквы и нужно чтоб сматчились остальные
                    char prevChar = p.charAt(j - 2);
                    dp[i][j] = dp[i][j - 2] || ((prevChar == sChar || prevChar == '.') && dp[i - 1][j]);
                }
            }
        }
        return dp[s.length() + 1][p.length() + 1];

    }

    public boolean isMatch2(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (p.length() > 1 && p.charAt(1) == '*') {  // second char is '*'
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            if(s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
                return isMatch(s.substring(1), p);
            }
            return false;
        } else {                                     // second char is not '*'
            if(s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
                return isMatch(s.substring(1), p.substring(1));
            }
            return false;
        }
    }
}
