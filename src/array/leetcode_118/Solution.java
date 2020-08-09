package array.leetcode_118;

import java.util.ArrayList;
import java.util.List;

//Given a non-negative integer numRows, generate the first numRows of Pascal's triangle
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();//базовые случаи
        if(numRows==0)
            return result;
        if(numRows==1) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            result.add(list);
            return result;
        }

        else
        {
            List<List<Integer>> temp = generate(numRows-1);//генерим для меньшего числа
            List<Integer> toadd = temp.get(temp.size()-1);//берем последнее и заполняем текущий уровень
            List<Integer> res = new ArrayList<>();
            res.add(1);
            for(int i = 0;i<toadd.size()-1;i++)
            {
                res.add(toadd.get(i)+toadd.get(i+1));
            }
            res.add(1);
            temp.add(res);//вставили текущий и положили в результат
            return temp;
        }
    }

    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++)
        {
            row.add(0, 1);
            for(int j=1;j<row.size()-1;j++)
                row.set(j, row.get(j)+row.get(j+1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generate2(5);
    }
}
