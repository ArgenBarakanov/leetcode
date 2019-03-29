package leetcode_46;

import java.util.ArrayList;
import java.util.List;

//Given a collection of distinct integers, return all possible permutations.
//
//        Example:
//
//        Input: [1,2,3]
//        Output:
//        [
//        [1,2,3],
//        [1,3,2],
//        [2,1,3],
//        [2,3,1],
//        [3,1,2],
//        [3,2,1]
//        ]
public class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        return permute2(nums,0);
    }
    public static List<List<Integer>> permute2(int[] nums,int index) {

        List<List<Integer>> res = new ArrayList<>();//локальный результат
        if(index==nums.length-1)//если дошли до крайнего то просто добавим в результат один лист с одним элементом
        {

            List<Integer> temp = new ArrayList<>();
            temp.add(nums[index]);
            res.add(temp);
            return res;
        }
        else
        {

            List<List<Integer>> lists = permute2(nums,index+1);//если же нет то передаем дальше
            if(lists!=null)//если предыдущий результат не равен нулю
            {
                for(List<Integer> l:lists)//для каждого
                {
                    for(int i = 0 ;i<l.size()+1;i++)// пихаем текущий элемент во все позиции
                    {
                        List<Integer> temp = new ArrayList<>();
                        temp.addAll(l);
                        temp.add(i,nums[index]);
                        res.add(temp);
                    }
                }
            }
            return res;
        }

    }
}
