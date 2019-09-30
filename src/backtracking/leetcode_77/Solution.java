package backtracking.leetcode_77;

import java.util.ArrayList;
import java.util.List;

//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
//        Example:
//
//        Input: n = 4, k = 2
//        Output:
//        [
//        [2,4],
//        [3,4],
//        [2,3],
//        [1,2],
//        [1,3],
//        [1,4],
//    допустим начнем с конца . есть 4  и еще 1 2 3. нужны комбинации с двумя числами.
//    4 с каждым из этих. а раз нам нужны комбинации 4 с остальными то нам надо получить комбинации из этих трех чисел
//    и на одну комбинацию меньше. 14 12 13.
//    плюс еще все комбинации из двух без 4. 12 13 23
//    если дошли до того что k=0 это означает что нам нужны комбинации из ничего то вернем один лист с ничего
//    если k<0 или k>n то вернем абсолютно ничего
//
//
//        ]
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k > n || k < 0) {
            return result;
        }
        if (k == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        result = combine(n - 1, k - 1);
        for (List<Integer> list : result) {
            list.add(n);
        }
        result.addAll(combine(n - 1, k));
        return result;
    }
}
