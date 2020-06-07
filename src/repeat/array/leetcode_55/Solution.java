package repeat.array.leetcode_55;

public class Solution {
    public boolean canJump(int[] nums) {
        int currentJumpCout = nums[0];
        int i = 0;
        while (true){
            if(currentJumpCout == 0 && i != nums.length-1) return false;
            if(i == nums.length -1) break;
            currentJumpCout--;
            i++;
            currentJumpCout = Math.max(nums[i],currentJumpCout);
        }
        return true;
    }
}
