package array.leetcode_84;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        // validate input
        if(heights == null || heights.length == 0) {
            return 0;
        }

        // init
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int result = 0;

        // build left
        left[0] = 0;
        for(int i = 1; i < n; i++) {//в данном массиве заполняются координаты столбоцов высота которых не ниже текущей i  слева от него
            int currentLeft = i-1;
            while(currentLeft >= 0 && heights[currentLeft] >= heights[i]) {//раз этот не ниже i то стоит пропустить промежуточные и искать те что не ниже чем этот левый стобец
                currentLeft = left[currentLeft]-1;
            }

            left[i] = currentLeft+1;
        }

        // build right
        right[n-1] = n-1;
        for(int i = n-2; i >= 0; i--) {// аналогично для тех что справа
            int currentRight = i+1;
            while(currentRight < n && heights[i] <= heights[currentRight]) {
                currentRight = right[currentRight]+1;
            }

            right[i] = currentRight-1;
        }
        // compare height
        for(int i = 0; i < n; i++) {

            result = Math.max(result, (right[i]-left[i]+1)*heights[i]);//ну тут все тривиально
        }



        // return
        return result;
    }

    public static void main(String[] args){
        int[] arr = {2,1,5,6,2,3};
        Solution solution = new Solution();
        int res = solution.largestRectangleArea(arr);
        System.out.println();
        System.out.println(res);
    }
}
