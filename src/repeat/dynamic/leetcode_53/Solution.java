package repeat.dynamic.leetcode_53;

public class Solution {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentMax = nums[0];
        for(int i = 1; i < nums.length; i++){
            // если к текущей сумме добавить текущий элемент то либо мы увеличим текущую сумму либо уменьшим
            // если уменьшим то нужно начать новый отсчет подмассива и его суммы
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            // обновить глобальный максимум
            max = Math.max(max, currentMax);
        }
        return max;
    }
}
