package algorithms.dynamic.binarySearch;

public class Solution {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {// в этом месте мы подставляем j в корень дерева и считаем сколько комбинаций поддеревьев есть слева и справа
                G[i] += G[j - 1] * G[i - j];//j-1 кол во деревьев для тех что слева от j. i-j для деревьев справа от корня j
            }
        }
        return G[n];
    }
}
