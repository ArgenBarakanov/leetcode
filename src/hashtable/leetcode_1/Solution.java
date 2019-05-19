package hashtable.leetcode_1;


import java.util.HashMap;
import java.util.Map;

//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//        Example:
//
//        Given nums = [2, 7, 11, 15], target = 9,
//
//        Because nums[0] + nums[1] = 2 + 7 = 9,
//        return [0, 1].
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] mas = new int[2];// результат записываем в массив
        Map<Integer, Integer> map = new HashMap<>();//мапу для хранения значений
        for (int i = 0; i < nums.length; i++) {
            int current = target - nums[i]; //разница цели и текущего элемента
            if (map.containsKey(current)) { //если такой есть в мапе то вернем индекс разницы и
                mas[0] = map.get(current);
                mas[1] = i; // текущего элемента
                return mas;
            } else
                map.put(nums[i], i);// в противном случае положим текущий элемент и его индекс
        }
        return mas;
    }
}
