package algorithms.string_primitive_integer.plus_one;

public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;//держим в уме
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + carry;//с конца начинаем.сначала добавим единицу а далее просто добавим
            if (i == digits.length - 1)  // то что у нас в уме
                digits[i] = digits[i] + 1;
            carry = digits[i] / 10; //переизбираем остаток в уме
            digits[i] = digits[i] % 10;
        }
        int[] res2 = new int[digits.length + 1];
        if (carry > 0) {//если то что в уме больше нуля то предвигаем и вставляем в начало 1
            res2[0] = carry;
            for (int i = 1; i < digits.length; i++) {
                res2[i] = digits[i];
            }
            return res2;
        }
        return digits;
    }
}
