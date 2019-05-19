package hashtable.leetcode_30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
//
//        Example 1:
//
//        Input:
//        s = "barfoothefoobarman",
//        words = ["foo","bar"]
//        Output: [0,9]
//        Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
//        The output order does not matter, returning [9,0] is fine too.
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();

        if (words.length == 0 || words[0].isEmpty() || words[0].length() > s.length())
            return result;
        int size = words[0].length();
        for(String word:words){
            map.put(word,!map.containsKey(word)?1:map.get(word)+1);//складываем в наш карту все слова и количество его появлений
        }
        for(int i=0;i+size*words.length<=s.length();i++){//начиная синдекса 0 до индекса который упрется в длину слов массива
            if(map.containsKey(s.substring(i,i+size))){//если есть такой отрывок в карте то создаем новую карту и заполняем его.
                Map<String,Integer> current = new HashMap<>();
                for(int j=0;j<words.length;j++){
                    String word = s.substring(i+j*size,i+(j+1)*size);
                    current.put(word,!current.containsKey(word)?1:current.get(word)+1);
                }
                if(current.equals(map))result.add(i);//в конце временную карту сравниваем с эталоном. если совпали то пишем индекс в результат
            }

        }

        return result;
    }
}
