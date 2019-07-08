package string.leetcode_158;

public class Solution extends Reader4 {
}
class Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int buffPtr = 0;
    private int buffCnt = 0;
    private char[] buff = new char[4];

    public int read(char[] buf, int n) {
        int ptr = 0;//индекс в буффере в который мы читаем данные
        while (ptr < n) {
            if (buffPtr == 0) {//если в промежуточном буффере индекс на нуле то мы читаем новые данные
                buffCnt = read4(buff);
            }
            if (buffCnt == 0) {
                break;//это в случае если в файле ничего не осталось
            }
            while (ptr < n && buffPtr < buffCnt) {
                buf[ptr++] = buff[buffPtr++];//копируем из прослойки в основной массив
            }
            if (buffPtr >= buffCnt) {//если мы вычитали все из прослойки то вновь начинаем чтение
                buffPtr = 0;
            }
        }
        return ptr;
    }


    public int read4(char[] buf) {
        return 4;
    }
}
