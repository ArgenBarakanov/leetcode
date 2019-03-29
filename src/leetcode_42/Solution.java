package leetcode_42;

//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//        Output: 6
public class Solution {
    public int trap(int[] height) {
        int leftMax =0;
        int i = 0;
        int[] lefttrap = new int[height.length];//смотрим как бы слева направо меняя левый максимум и записываем в евый массив
        while(i<height.length){
            leftMax = Math.max(height[i],leftMax);
            lefttrap[i]=leftMax-height[i];
            i++;
        }
        int[] righttrap=new int[height.length];//то же самое для правой стороны
        int j=height.length-1;
        int rightMax =0;
        while(j>=0){
            rightMax = Math.max(height[j],rightMax);
            righttrap[j]=rightMax-height[j];
            j--;
        }
        int index =0;
        int sum = 0;
        while(index<height.length){
            sum+=Math.min(lefttrap[index],righttrap[index]);//выбираем минимум из двух
            index++;
        }
        return sum;
    }
}
