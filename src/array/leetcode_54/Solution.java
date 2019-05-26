package array.leetcode_54;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> answer = new ArrayList<>();
        if ( matrix.length == 0) return answer;


        int left = 0;
        int top = 0;
        int right = matrix[0].length;
        int bottom = matrix.length;

        while(left <  right && top < bottom){//легче нарисовать и вынести из рисунка формулу
            for (int i = left; i < right; i++){
                answer.add(matrix[top][i]);
            }
            top ++;
            if(top>= bottom) break;

            for (int i = top; i < bottom; i++){
                answer.add(matrix[i][right-1]);
            }
            right--;
            if(left>= right) break;

            for(int i = right-1; i>= left; i--){
                answer.add(matrix[bottom-1][i]);
            }
            bottom--;
            for (int i = bottom-1; i >= top; i--){
                System.out.println(left+" "+i);
                answer.add(matrix[i][left]);
            }
            left++;
        }
        return answer;

    }
}
