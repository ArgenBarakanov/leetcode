package algorithms.string_primitive_integer.kmp_search_string;
/*
 префикс функция нужна чтобы узнать длину равных префиксов и суффиксов в образе
indexof   0  1  2  3  4  5  6  7  8
pattern   d  s  d  w  a  d  s  d  s
presuff   0  0  1  0  0  1  2  3  2

префикс ds повторяется два раза в образе.  dsd так же является суффиксом начиная с индекса 5. следующий символ префикса w не совпадает
с следующим символом суффикса s. так как указатель на префикс уже сдвинут нам надо посмотреть  на предыдущий совпадающий префикс.
вдруг s суффикса есть в префиксе меньшего размера. так и есть. s идет после первой d.ds с 0 по 1 совпадет с 7 8 индексами
перекатываем к предыдущему индексу массива и кладем его значение в указатель префикса и начинаем сравнение не с d а с s .

в основной функции при совпадении двигаем указатели вперед. при промахе мы как бы не откатываем весь прогресск началу образа а к предыдущему совпащему
отрезку.
легче всего на бумаге попробовать следовать алгоритму и становится ясно как он работает
 */
public class Solution {
    public int[] lps(String pattern) {
        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        int r = 1;
        int l = 0;
        while (r < pattern.length()) {
            if (pattern.charAt(l) != pattern.charAt(r)) {
                if (l == 0) {
                    lps[r] = 0;
                    r++;
                } else {
                    l = lps[l - 1];
                }
            } else {
                l++;
                lps[r] = l;
                r++;
            }
        }
        return lps;
    }

    public int strStr(String str, String pattern) {
        if (str == null || pattern == null || str.length() < pattern.length()) {
            return -1;
        } else if (pattern.isEmpty()) {
            return 0;
        }
        int[] lps = lps(pattern);
        int r = 0;
        int l = 0;
        while (r < str.length()) {
            if (str.charAt(r) == pattern.charAt(l)) {
                r++;
                l++;
                if (l == pattern.length()) return r - l;
            } else {
                if (l == 0) {
                    r++;
                } else {
                    l = lps[l - 1];
                }
            }
        }
        return -1;
    }
}
