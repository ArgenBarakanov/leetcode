package leetcode_48;

//You are given an n x n 2D matrix representing an image.
//
//        Rotate the image by 90 degrees (clockwise).
//
//        Note:
//
//        You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
//
//        Example 1:
//
//        Given input matrix =
//        [
//        [1,2,3],
//        [4,5,6],
//        [7,8,9]
//        ],
//
//        rotate the input matrix in-place such that it becomes:
//        [
//        [7,4,1],
//        [8,5,2],
//        [9,6,3]
//        ]
public class Solution {
    public void rotate(int[][] matrix) {
        for(int i =0;i<matrix.length;i++){
            for(int j =i;j<matrix[0].length;j++){//транспонируем матрицу. т.е. строки делаем столбцами и соответсвенно наоборот
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        for(int i =0;i<matrix.length;i++){
            for(int j = 0;j<matrix.length/2;j++){//свапаем либо вертикально либо горизонтально смотря как транспонировали
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}