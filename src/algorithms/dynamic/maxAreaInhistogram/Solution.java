package algorithms.dynamic.maxAreaInhistogram;

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
        left[0] = 0;//для каждого элемента ищем элемент слева который меньше текущего элемента(граница прямоугольника слева)
        for(int i = 1; i < n; i++) {
            int currentLeft = i-1;
            while(currentLeft >= 0 && heights[currentLeft] >= heights[i]) {
                currentLeft = left[currentLeft]-1;//можно брать current --; но это долго
            }

            left[i] = currentLeft+1;
        }

        // build right
        right[n-1] = n-1;
        for(int i = n-2; i >= 0; i--) {//то же самое справа
            int currentRight = i+1;
            while(currentRight < n && heights[i] <= heights[currentRight]) {
                currentRight = right[currentRight]+1;
            }

            right[i] = currentRight-1;
        }

        // compare height
        for(int i = 0; i < n; i++) {

            result = Math.max(result, (right[i]-left[i]+1)*heights[i]);//считаем площадь так будто бы текущий элемент минимальный в этом отрезке
        }



        // return
        return result;
    }
}
