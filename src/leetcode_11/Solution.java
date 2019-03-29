package leetcode_11;

//Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
//
//        Note: You may not slant the container and n is at least 2.
public class Solution {
    public int maxArea(int[] height) {
        int l=0,r = height.length-1;
        int maxArea = 0;//наибольшая площадь изначальна равна нулю
        while(l<r)
        {
            maxArea = Math.max(maxArea,(r-l)*Math.min(height[l],height[r]));//обновляем площадь если новая больше
            if(height[r]>height[l])
                l++;//если высота правой больше то надо сдвинуть вправо левый индекс
            else
            {
                r--;//и наоборот
            }
        }
        return maxArea;
    }
}
