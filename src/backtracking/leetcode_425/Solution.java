package backtracking.leetcode_425;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    Trie trie;
    int size;

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        if (words == null || words.length == 0) return result;

        trie = Trie.fromArray(words);
        size = words[0].length();

        List<String> answerBuilder = new ArrayList<>();
        for (String w : words) {
            answerBuilder.add(w);
            backTrack(result, answerBuilder);
            answerBuilder.remove(w);
        }
        return result;
    }

    private void backTrack(List<List<String>> result, List<String> answerBuilder) {
        if (answerBuilder.size() == size) {
            result.add(new ArrayList<>(answerBuilder));
            return;
        }
        String prefix = buildPrefix(answerBuilder);
        List<String> options = trie.getByPrefix(prefix);
        for(String w : options) {
            answerBuilder.add(w);
            backTrack(result, answerBuilder);
            answerBuilder.remove(w);
        }
    }

    private String buildPrefix(List<String> answerBuilder) {
        int index = answerBuilder.size();
        StringBuilder sb = new StringBuilder();
        for (String w : answerBuilder) {
            sb.append(w.charAt(index));
        }
        return sb.toString();
    }
}
