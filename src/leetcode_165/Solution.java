package leetcode_165;
//Compare two version numbers version1 and version2.
//        If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
//
//        You may assume that the version strings are non-empty and contain only digits and the . character.
//
//        The . character does not represent a decimal point and is used to separate number sequences.
//
//        For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
//
//        You may assume the default revision number for each level of a version number to be 0. For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number. Its third and fourth level revision number are both 0.
//
//
//
//        Example 1:
//
//        Input: version1 = "0.1", version2 = "1.1"
//        Output: -1
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] levels1 = version1.split("\\.");//разбиваем на массив
        String[] levels2 = version2.split("\\.");

        int length = Math.max(levels1.length, levels2.length);
        for (int i=0; i<length; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;//если есть число то берем его
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;//иначе 0
            int compare = v1.compareTo(v2);//сравниваем два соответсвующих числа
            if (compare != 0) {//если все не равны то веренм число
                return compare;
            }
        }

        return 0;
    }
}
