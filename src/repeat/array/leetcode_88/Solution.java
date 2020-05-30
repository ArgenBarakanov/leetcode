package repeat.array.leetcode_88;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] workspace = new int[m + n];
        int mPointer = 0;
        int nPointer = 0;
        int k = 0;
        while (mPointer < m && nPointer < n) {
            if (nums1[mPointer] > nums2[nPointer]) {
                workspace[k++] = nums2[nPointer++];
            } else {
                workspace[k++] = nums1[mPointer++];
            }
        }

        while (mPointer < m) {
            workspace[k++] = nums1[mPointer++];
        }

        while (nPointer < n) {
            workspace[k++] = nums2[nPointer++];
        }

        for(int l = 0; l < m + n; l++){
            nums1[l] = workspace[l];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        Solution solution = new Solution();
        solution.merge(nums1, 3, nums2, 3);
    }

}
