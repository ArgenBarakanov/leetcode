package algorithms.string_primitive_integer.dutch_flag_problem;
//в массиве даны три числа. нужно их отсортировать за время n
public class Solution {
    public void sortColors2(int[] nums) {

        int len = nums.length;
        if(len < 2)
            return;

        int left = 0;
        int right = len - 1;
        int current = 0;
        while(current <= right) {
            if(nums[current] == 0){//если текущий элемент равен 0 то его смещаем налево и увеличиваем счетчик
                swap(nums, left, current);
                left++;
                current++;
            }
            else if(nums[current] == 1) {
                current++;//если равен 1 то продолжаем
            }
            else {// если равно 2 то его смещаем на правый конец
                swap(nums, right, current);
                right--;
            }
        }
    }

    public void swap(int[] mas,int first,int second){
        int temp = mas[first];
        mas[first] = mas[second];
        mas[second]=temp;
    }
}
