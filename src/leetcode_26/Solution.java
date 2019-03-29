package leetcode_26;

//Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
//
//        Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0)
        {
            return 0;
        }
        int i =0;//начальный индекс
        for(int j=1;j<nums.length;j++)//начинаем со второго так как он стопудово уникальный в ответе
        {
            if(nums[j]!=nums[i])//если второй не равен первому то заисываем во второй новое значение иначе ищем элемент неравный первому
            {
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
}