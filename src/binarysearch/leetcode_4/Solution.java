package binarysearch.leetcode_4;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) throw new IllegalArgumentException("ex");
        if (nums1.length == 0 && nums2.length == 0) throw new IllegalArgumentException("ex");
        if (nums1.length == 0) return getMadian(nums2);
        if (nums2.length == 0) return getMadian(nums1);

        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length, n = nums2.length;
        int[] A = nums1, B = nums2;
        int half = (m + n + 1)/2; // so j == half - i
        int iMin = 0, iMax = m;
        while(iMin<=iMax){
            int i = iMin+(iMax-iMin)/2;
            int j = half-i;
            if(i<m&&B[j-1]>A[i]){
                iMin  = i+1;
            }else if (i > 0 && A[i-1] > B[j]) {// should be  A[i-1] <= B[j], if  A[i-1] > B[j] => i is too big
                iMax = i - 1;
            }
            else {
                int maxLeft = 0;
                if (i == 0) maxLeft = B[j-1];
                else if (j == 0) maxLeft = A[i-1];
                else maxLeft = Math.max(A[i-1], B[j-1]);

                if ((n+m)%2 == 1) return maxLeft;

                int minRight = 0;
                if (i == m) minRight = B[j];
                else if (j == n) minRight = A[i];
                else minRight = Math.min(A[i], B[j]);

                return (maxLeft + minRight)/2.0;
            }
        }
        return 0.0;
    }

    public double getMadian(int[] nums) {
        return (nums.length%2) == 1 ? nums[nums.length/2] : (nums[nums.length/2] + nums[nums.length/2 - 1])/2.0;
    }
}
