package repeat.array.leetcode_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> container = new ArrayList<>();
        getKSum(container, nums, 0, 4, target);
        return res;
    }

    private void getKSum(List<Integer> container, int[] nums, int index, int k, int target) {
        if (k > 2) {
            for (int i = index; i < nums.length - k + 1; i++) {
                container.add(nums[i]);
                getKSum(container, nums, i + 1, k - 1, target - nums[i]);
                container.remove(container.size() - 1);
                while (i < nums.length - 2 && nums[i] == nums[i + 1])i++;
            }
        } else {
            int left = index;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> elementToAdd = new ArrayList<>(container);
                    elementToAdd.add(nums[left]);
                    elementToAdd.add(nums[right]);
                    res.add(elementToAdd);
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1])right--;
                    left++;
                    right--;
                } else if (sum > target) right--;
                else left++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        Solution solution = new Solution();
        solution.fourSum(nums,0);
    }
}
