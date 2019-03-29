package leetcode_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
//
//        Each number in candidates may only be used once in the combination.
//
//        Note:
//
//        All numbers (including target) will be positive integers.
//        The solution set must not contain duplicate combinations.
//        Example 1:
//
//        Input: candidates = [10,1,2,7,6,1,5], target = 8,
//        A solution set is:
//        [
//        [1, 7],
//        [1, 2, 5],
//        [2, 6],
//        [1, 1, 6]
//        ]
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>res = new ArrayList<>();// result set
        Arrays.sort(candidates);
        solver(res, candidates, new ArrayList<>(), target, 0);
        return res;
    }

    public void solver(List<List<Integer>>res, int[] candidates, List<Integer>tmp, int target, int stIndex){
        if (target < 0) return; //базовый случай .выход из рекурсии
        else if (target == 0)   res.add(new ArrayList<>(tmp));//удачно нашли комбинацию.
        else
            for (int i = stIndex; i < candidates.length; i++){
                if (i > stIndex && candidates[i] == candidates[i - 1])  continue;//пропускаем одинаковые числа
                if (target - candidates[i] < 0) break;//если меньше  нуля то гарантированно лезть дальше нет смысла
                tmp.add(candidates[i]);//добавим в временную переменную
                solver(res, candidates, tmp, target - candidates[i], i + 1);// рекурсивно вызываем
                tmp.remove(tmp.size() - 1);//удаляем внесенную
            }
    }
}
