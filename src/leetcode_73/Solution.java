package leetcode_73;

//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
//
//        Example 1:
//
//        Input:
//        [
//        [1,1,1],
//        [1,0,1],
//        [1,1,1]
//        ]
//        Output:
//        [
//        [1,0,1],
//        [0,0,0],
//        [1,0,1]
//        ]
public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean rows[] = new boolean[matrix.length];
        boolean cols[] = new boolean[matrix[0].length];
        for(int i = 0;i<rows.length;i++)
        {
            for(int j =0;j<cols.length;j++)
            {
                if(matrix[i][j]==0)
                {
                    rows[i] = true;//тупо запоминаем есть ли в столбце или колонке ноль и помечаем его
                    cols[j] = true;
                }
            }
        }

        for(int i = 0;i<rows.length;i++)
        {
            for(int j =0;j<cols.length;j++)
            {
                if(rows[i]||cols[j])//если есть трушные колонки или столбцы то выставляем нолик
                {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
