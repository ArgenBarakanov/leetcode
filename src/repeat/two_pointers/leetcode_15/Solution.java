package repeat.two_pointers.leetcode_15;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sums = new LinkedList();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i==0 || nums[i] != nums[i-1]){//пропускаем дубликаты
                int goal = 0 - nums[i];
                int lo = i+1;
                int hi = nums.length-1;
                while(lo < hi){
                    int sum = nums[lo] + nums[hi];
                    if(sum == goal){
                        sums.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while(lo < hi && nums[lo] == nums[lo+1]) lo++;//пропускаем дубликаты
                        while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++; hi--;
                    }else if(sum < goal) lo++;
                    else hi--;
                }
            }
        }
        return sums;
    }
}
