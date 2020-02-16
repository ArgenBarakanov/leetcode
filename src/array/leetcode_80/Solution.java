package array.leetcode_80;
//Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
//
//        Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
//
//        Example 1:
//
//        Given nums = [1,1,1,2,2,3],
//
//        Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
//
//        It doesn't matter what you leave beyond the returned length.
public class Solution {
    // представьте что заполняете не этот массив заново а другой. разницы никакой нет.
    public int removeDuplicates(int[] nums) {
     int i = 0;//тот что быстрее
     int j = 0;// тот что медленнее
     while (i < nums.length){
         int copy = nums[i];//копируем число
         int k = 0;// количество дубликатов
         while (i<nums.length && nums[i] == copy){
             k++;//инкрементим быстрого и количество дубликатов пока не найдем другое число или конец массива
             i++;
         }
         if(k > 1){//если количество повторов больше 1 то заполняем сохраненным числом клетки медленным указателем два раза
             nums[j++] = copy;
             nums[j++] = copy;
         }else {
             nums[j++] = copy;//иначе один раз
         }
     }
     return j;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 2, 2};
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(nums));
        for (Integer i : nums) System.out.print(i + " ");
    }
}
