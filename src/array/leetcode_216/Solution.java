package array.leetcode_216;

import java.util.ArrayList;
import java.util.List;

//Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
//
//        Note:
//
//        All numbers will be positive integers.
//        The solution set must not contain duplicate combinations.
//        Example 1:
//
//        Input: k = 3, n = 7
//        Output: [[1,2,4]]
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=1;i<10;i++)
        {
            List<Integer> list = new ArrayList<>();
            list.add(i);//для каждой запускаю дфс
            combs(i+1,k-1,n-i,result,list);

        }
        return result;
    }

    public void combs(int start,int k,int target,List<List<Integer>> result,List<Integer> list){
        if(k==1)
        {
            for(int i=start;i<10;i++)
            {
                if(i==target)//если уже есть два числа и это последняя и она равна цели то добавляем в результат
                {
                    list.add(i);
                    result.add(new ArrayList<>(list));
                    list.remove(list.size()-1);

                }
            }
        }
        else
        {
            for(int i = start;i<10;i++)
            {
                list.add(i);//добавили очередное число
                combs(i+1,k-1,target-i,result,list);//спускаемся вниз по рекурсии далее
                list.remove(list.size()-1);// и удаляем это же число
            }
        }
    }
}
