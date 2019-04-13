package leetcode_128;

import java.util.HashSet;
import java.util.Set;

//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//        Your algorithm should run in O(n) complexity.
//
//        Example:
//
//        Input: [100, 4, 200, 1, 3, 2]
//        Output: 4
//        Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);//заносим в хэшсет для быстрого доступа к числам
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) {//убедимся что это число первое в текущем стриме
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {// увеличиваем текущий стрим  пока числа отличаются на 1
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);//обновляем максимум
            }
        }

        return longestStreak;
    }
}
