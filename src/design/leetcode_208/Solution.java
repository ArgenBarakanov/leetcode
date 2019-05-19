package design.leetcode_208;
//Implement a trie with insert, search, and startsWith methods.
//
//        Example:
//
//        Trie trie = new Trie();
//
//        trie.insert("apple");
//        trie.search("apple");   // returns true
//        trie.search("app");     // returns false
//        trie.startsWith("app"); // returns true
//        trie.insert("app");
//        trie.search("app");     // returns true
class TrieNode {
    private final int R = 26;
    TrieNode[] children ;
    private boolean isEnd;

    public TrieNode() {
        children = new TrieNode[R];
    }
    public boolean containsKey(char ch) {
        return children[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return children[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        children[ch -'a'] = node;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd() {
        isEnd = true;
    }
}

class Trie{
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new TrieNode());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }else
                return null;
        }
        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node!=null&&node.isEnd();
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix)!=null;
    }
}

public class Solution {
}
