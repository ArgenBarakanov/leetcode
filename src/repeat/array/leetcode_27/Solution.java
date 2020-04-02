package repeat.array.leetcode_27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for(int right = 1; right < nums.length; right++){
            if(val != nums[right]){
                nums[left] = nums[right];
                left++;
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        Solution solution = new Solution();
        solution.removeElement(nums,3);
    }
}
