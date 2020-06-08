package repeat.dynamic.leetcode_115;

import java.util.Arrays;

public class Solution {
    public int numDistinct(String S, String T) {
        //для примера приведем rara и ra
        //    ""  r  a  r  a
        //  "" 1  1  1  1  1
        //  r  0  1  1  1  2
        //  a  0  0  1  1  ---> 3 --> это из двух permutations rar и ra (1 match) AND rar и r . добавляем a в обоих строках ra и ra
        // array creation
        int[][] mem = new int[T.length()+1][S.length()+1];

        // filling the first row: with 1s
        for(int j=0; j<=S.length(); j++) {
            mem[0][j] = 1;
        }

        for(int i=0; i<T.length(); i++) {
            for(int j=0; j<S.length(); j++) {
                if(T.charAt(i) == S.charAt(j)) {
                    mem[i+1][j+1] = mem[i][j] + mem[i+1][j];//  rar и r . r встречается дважды. когда во второй строке a  из rA совпадает с rarA
                    //  это означает что a можно вставить в две предыдущие r
                } else {
                    mem[i+1][j+1] = mem[i+1][j];
                }
            }
        }

        return mem[T.length()][S.length()];
    }

    int [][] dp = null;

    public int numDistinct2(String S, String T) {
        dp = new int[S.length() + 1][T.length() + 1];
        for(int [] arr : dp) Arrays.fill(arr, -1);
        return dfs(S, T, 0, 0);
    }

    public int dfs(String s, String t, int i, int j) {
        if(j >= t.length()) return 1;
        if(i >= s.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int sol = dfs(s, t, i + 1, j); // ara и ra
        if(s.charAt(i) == t.charAt(j))
            sol += dfs(s, t, i + 1, j + 1);// ara и a

        dp[i][j] = sol;
        return sol;
    }
}
