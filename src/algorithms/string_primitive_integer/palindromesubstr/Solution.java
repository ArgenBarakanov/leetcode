package algorithms.string_primitive_integer.palindromesubstr;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> decompositions = new ArrayList();
        decomposeString(0, s, new ArrayList<>(), decompositions);
        return decompositions;
    }

    private void decomposeString(
            int workingIndex,
            String s,
            List<String> partialDecomposition,
            List<List<String>> decompositions
    ) {
  /*
     индекс равен длине строки то мы перебрали все и надо вернуть все варианты
  */
        if (workingIndex == s.length()) {
            decompositions.add(new ArrayList<>(partialDecomposition));
            return;
        }

  /*
   делаем скриншот каждой подстроки
  */
        for (int i = workingIndex; i < s.length(); i++) {
    /*
      проверяем является ли палиндромом
    */
            if (isPalindrome(workingIndex, i, s)) {

                // если палиндром то добавляем в наш путь
                String palindromicSnippet = s.substring(workingIndex, i + 1);
                partialDecomposition.add(palindromicSnippet);

      /*
        babab разбиваем на b и abab.abab передаем в следующий вызов рекурсивной функции
        bab ab
        babab пустая строка
         ba и baba не являются палиндромами поэтому мы не делаем рекурсию
      */
                decomposeString(i + 1, s, partialDecomposition, decompositions);

      /*
       раз мы уже передали эту подстроку то ее надо убрать из пути так как она лишняя и будет повторяться
      */
                partialDecomposition.remove(partialDecomposition.size() - 1);
            }
        }
    }

    /*
      является ли палиндромом
    */
    public boolean isPalindrome(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        List<List<String>> palindrome = solution.partition("babab");
        for(List<String> l: palindrome){
            for (String s:l) {
                System.out.print(s+" ");
            }
            System.out.println();
        }
    }
}
