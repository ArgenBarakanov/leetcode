package dynamic.leetcode_91;
//A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//        'A' -> 1
//        'B' -> 2
//        ...
//        'Z' -> 26
//        Given a non-empty string containing only digits, determine the total number of ways to decode it.
public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;//пустая строка может быть расшифрована как пустая строка
        dp[1] = s.charAt(0) != '0' ? 1 : 0;//если начинается с 0 тоэто 0.иначе это любая цифра
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));//текущее
            int second = Integer.valueOf(s.substring(i-2, i));//текущее и предыдущее в качестве двузначного
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];//если в промежутке от 1 до 9 то как на предыдущем шаге
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];//если входит в нужный диапазон то прибавляем с предпоследним
            }
        }
        return dp[n];
    }
}
