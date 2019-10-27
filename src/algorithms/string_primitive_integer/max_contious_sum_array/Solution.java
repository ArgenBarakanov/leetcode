package algorithms.string_primitive_integer.max_contious_sum_array;
/*
 [-2,1,-3,4,-1,2,1,-5,4]
 мы для каждого элемента ищем наилучший исход
 если сумма предыдущая меньше нуля то она в любом случае ухудшит текущую сумму : уменьшит положительное или ухудшит и без того отрицательное
 если же сумма предыдущая положительная то в любом случае она улучшит положение. после надо будет выбрать из текущего элемента плюс предыдущая
 сумма или же текущий элемент. который из них больше
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int curentMax = nums[0];
        int maxSum =nums[0];
        for(int i = 1;i<nums.length;i++)
        {
            if(curentMax<0)
                curentMax = nums[i];
            else
            {
                curentMax+=nums[i];
            }
            maxSum = Math.max(curentMax,maxSum);

        }
        return maxSum;
    }

    //второе решение. мы на каждом шаге решаем включать ли предыдущий результат для текущего или начать новый отсчет
    public int maxSubArray2(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++){
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);// текущий максимум из нынешнего или нынешний плюс предыдущий результат

            maxSoFar = Math.max(maxSoFar, maxEndingHere);//глобальный максимум. выбираем из предыдущего значения глобального либо из текущего
        }

        return maxSoFar;
    }
}
