package array.leetcode_31;

//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//        If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
//        The replacement must be in-place and use only constant extra memory.
//
//        Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//
//        1,2,3 → 1,3,2
//        3,2,1 → 1,2,3
//        1,1,5 → 1,5,1
public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i>=0&&nums[i]>=nums[i+1])i--;//пока сохраняется убывающий порядок
        if(i>=0)
        {
            int j = nums.length-1;
            while(j>=i&&nums[j]<=nums[i])j--;//ищем ближайшее то которое меньше
            swap(i,j,nums);


            reverse(nums,i+1);//разворот последовательности
        }
        else
        {
            reverse(nums,0);
        }

    }
    public void swap(int left,int right,int[] array){
        int temp = array[left];
        array[left]=array[right];
        array[right]=temp;
    }
    public void reverse(int[] array,int start){
        int i = start;
        int j = array.length-1;
        while(i<j)
        {
            swap(i,j,array);
            i++;
            j--;
        }
    }
}
