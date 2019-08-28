package array.leetcode_268;

public class Solution {
    public int missingNumber(int[] nums) {
        int[] copy = new int[nums.length+1];
        int res = 0 ;
        for(int i =0;i<nums.length;i++)
        {
            copy[nums[i]]=nums[i];//копируем в новый массив значение по индексу
        }
        for(int i=0;i<copy.length;i++)
        {
            if(i!=copy[i])//если не совпадает индекс и его значение вернем результат
            {
                res=i;
                break;
            }
        }

        return res;
    }
}
