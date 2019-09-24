package algorithms.string_primitive_integer.reverse_integer;

public class Solution {
    public int reverse(int x) {
        int res = 0;

        while (x != 0)// пока не превратится в ноль
        {
            int tail = x % 10;//выделяем хвост
            int newResult = res * 10 + tail;//промежуточный результат равен результат умножаем на 10 и прибавляем хвост
            if ((newResult - tail) / 10 != res)//это на случай переполнения
            { return 0; }
            res = newResult;//если все нормально то присваиваем результату промежуточный
            x = x / 10;//уменьшаем на 1 разряд
        }
        return res;
    }
}
