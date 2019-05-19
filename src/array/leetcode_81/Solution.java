package array.leetcode_81;
//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//        (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
//
//        You are given a target value to search. If found in the array return true, otherwise return false.
//
//        Example 1:
//
//        Input: nums = [2,5,6,0,0,1,2], target = 0
//        Output: true
//        Example 2:
//
//        Input: nums = [2,5,6,0,0,1,2], target = 3
//        Output: false
public class Solution {

        public boolean search(int[] nums, int target) {
            if(nums.length==1&&nums[0]!=target)
                return false;
            int l = 0, h = nums.length-1;
            while(l <= h){
                int mid = l + (h-l)/2;
                if(nums[mid] == target)     return true;//совпадение
                else if(nums[mid]<nums[h])//если справа отсортировано
                {
                    if(nums[mid]<target&&target<=nums[h])//если цель справа то сужаем подтягивая l  вверх
                        l = mid+1;
                    else
                        h = mid-1;//иначе наоборот
                }
                else if(nums[mid]>nums[h])
                {
                    if(nums[mid]>target&&target>=nums[l])
                    {
                        h = mid -1;
                    }
                    else
                    {
                        l = mid +1;
                    }
                }
                else{
                    h = mid;
                    h--;
                }//если нашли совпадение
            }
            return false;
        }
}
