package repeat.array.leetcode_16;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
      Arrays.sort(nums);
      int res = nums[0] + nums[1] + nums[nums.length-1];
      for(int i = 0; i < nums.length - 2; i++){
          int right = nums.length - 1;
          int left = i + 1;
          while (left < right){
              int sum = nums[i] + nums[left] + nums[right];
              if(sum > target)right--;
              else left++;

              int temp = Math.abs(sum - target);
              if(temp < Math.abs(res - target))res = sum;
          }
      }
      return res;
    }

    public static void main(String[] args){
        int[] nums = {1,1,1,0};
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(nums,100));
    }
}
