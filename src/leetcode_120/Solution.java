package leetcode_120;

import java.util.List;

//Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//
//        For example, given the following triangle
//
//        [
//        [2],
//        [3,4],
//        [6,5,7],
//        [4,1,8,3]
//        ]
//        The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] mas = new int[triangle.size()+1];
        for(int i = triangle.size()-1;i>=0;i--)//в массив записываем //минимум из двух ближайших плюс необходимая ячейка из текущего списка
        {
            List<Integer> tmp = triangle.get(i);
            for(int j=0;j<tmp.size();j++)
            {
                mas[j]=Math.min(mas[j],mas[j+1])+tmp.get(j);
            }
        }

        return mas[0];
    }
}
