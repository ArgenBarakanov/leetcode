package array.leetcode_324;

import java.util.Arrays;

//Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
//
//        Example 1:
//
//        Input: nums = [1, 5, 1, 1, 6, 4]
//        Output: One possible answer is [1, 4, 1, 5, 1, 6].
//        Example 2:
//
//        Input: nums = [1, 3, 2, 2, 3, 1]
//        Output: One possible answer is [2, 3, 1, 3, 1, 2].
//        Note:
//        You may assume all input has valid answer.
public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) return;


        int n = nums.length;
        int mid = (n + 1) / 2;
        Arrays.sort(nums);

        int[] res = new int[n];
        int index = 0;
        for (int i = mid - 1, j = n - 1; j>=mid; i--, j--) {
            res[index] = nums[i];
            index++;
            res[index] = nums[j];
            index++;
        }

        if (n % 2 == 1) res[n-1] = nums[0];//если нечетное то последнее это первый элемент

        for (int i = 0; i<n; i++) {
            nums[i] = res[i];
        }
    }
}
