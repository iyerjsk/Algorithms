package stringProblems;

import java.util.HashMap;
import java.util.Map;

public class AddAndSearchWord {
    private TrieNode root = new TrieNode();

    /** Initialize your data structure here. */
    public AddAndSearchWord() {

    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(int i=0; i < word.length(); i++) {
            node  = node.data.computeIfAbsent(word.charAt(i), k -> new TrieNode());
            if(i == word.length() - 1) {
                node.endOfWord = true;
            }

        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(root, word);
    }

    private boolean search (TrieNode node, String word) {
        if(node == null) {
            return false;
        }
        if(word.length() == 0) {
            return node.endOfWord;
        }

        String remainingWord  = word.length() == 1 ? "" : word.substring(1);
        if(word.charAt(0) == '.') {
            for(TrieNode trieNode: node.data.values()) {
                boolean res = search(trieNode, remainingWord);
                if(res) {
                    return true;
                }
            }
            return false;
        } else {
            return search(node.data.get(word.charAt(0)), remainingWord);
        }
    }

    class TrieNode {
        Map<Character, TrieNode> data = new HashMap<>();
        boolean endOfWord;
    }
}
