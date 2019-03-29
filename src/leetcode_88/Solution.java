package leetcode_88;

//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
//        Note:
//
//        The number of elements initialized in nums1 and nums2 are m and n respectively.
//        You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
//        Example:
//
//        Input:
//        nums1 = [1,2,3,0,0,0], m = 3
//        nums2 = [2,5,6],       n = 3
//
//        Output: [1,2,2,3,5,6]
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] workspace = new int[m+n];
        int i1 = 0;
        int i2 = 0;
        int j = 0;
        while(i1<m&&i2<n)//ока не один из них не выйдет за пределы
        {
            if(nums1[i1]<nums2[i2]) {

                workspace[j] = nums1[i1];//поочередно скидываем в новый массив большее
                j++;
                i1++;
            }
            else {

                workspace[j] = nums2[i2];
                j++;
                i2++;
            }
        }
        while(i1<m)//если он не вышел за пределы то пишем в новый массив
        {

            workspace[j]=nums1[i1];
            j++;
            i1++;
        }
        while(i2<n)//то же самое для второго массива
        {

            workspace[j]=nums2[i2];
            j++;
            i2++;
        }

        for(int k=0;k<workspace.length;k++)
        {
            nums1[k]=workspace[k];
        }
    }
}
