package math.leetcode_7;

//Надо вернуть палиндром числа без участия String
class Solution {
    public int reverse(int x) {
        int result = 0;//записываем результат здесь

        while (x != 0)
        {
            int tail = x % 10;//цифра справа
            int newResult = result * 10 + tail;//перемещаем ее влево
            if ((newResult - tail) / 10 != result)// в случае переполнения int вернем ноль
            { return 0; }
            result = newResult;//если все в порядке то присваиваем нове значение нашему ответу
            x = x / 10;//избавляемся от левого числа
        }
        return result;
    }
}