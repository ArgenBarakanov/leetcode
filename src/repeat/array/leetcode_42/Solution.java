package repeat.array.leetcode_42;

public class Solution {
    public int trap(int[] height) {
        int leftMax = 0;
        int[] leftTrap = new int[height.length];
        int i = 0;
        while(i < height.length){
            leftMax = Math.max(leftMax,height[i]);
            leftTrap[i] = leftMax - height[i];
            i++;
        }

        int rightMax = 0;
        int[] rightTrap = new int[height.length];
        int j = height.length - 1;
        while(j>=0){
            rightMax = Math.max(rightMax, height[j]);
            rightTrap[j] = rightMax - height[j];
            j--;
        }

        int sum = 0;
        int k = 0;
        while (k < height.length){
            sum = sum + Math.min(leftTrap[k],rightTrap[k]);
            k++;
        }
        return sum;
    }
}
