package backtracking.leetcode_39;

import java.util.ArrayList;
import java.util.List;

//Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
//
//        The same repeated number may be chosen from candidates unlimited number of times.
//
//        Note:
//
//        All numbers (including target) will be positive integers.
//        The solution set must not contain duplicate combinations.
//        Example 1:
//
//        Input: candidates = [2,3,6,7], target = 7,
//        A solution set is:
//        [
//        [7],
//        [2,2,3]
//        ]
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();//результат который мы вернем
        List<Integer> path = new ArrayList<>();//текущий набор  элементов
        dfs(candidates, target, res, path, 0);
        return res;
    }
    private void dfs(int[] cand, int target, List<List<Integer>> res, List<Integer> path, int idx) {
        for (int i = idx; i < cand.length; i++) {//для каждого  из списка
            if (target - cand[i] >= 0)  {//если цель после вычета текущего положительна то мы добавляем в путь
                path.add(cand[i]);
                if (target - cand[i] == 0) {//если равна нулю  то добавляем
                    res.add(new ArrayList(path));
                } else {
                    dfs(cand, target - cand[i], res, path, i);//для последующих вызовов функций меняем значение цели  и индекс
                }
                path.remove(path.size() - 1);//удаляем из пути
            }
        }
    }
}
