package stringProblems;

/**
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class PrefixTree {

    private final Node root;

    /** Initialize your data structure here. */
    public PrefixTree() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(node.data[index] == null) {
                node.data[index] = new Node();
            }
            node = node.data[index];
            if(i == word.length() - 1) {
                node.endOfWord = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(root, word, false);
    }

    private boolean search(Node node, String word, boolean prefix) {
        if(node == null) {
            return false;
        }

        if(word.equals("")) {
            return prefix  || node.endOfWord;
        }

        node = node.data[(word.charAt(0) - 'a')];
        word = word.length() == 1 ? "" : word.substring(1);

        return search(node, word, prefix);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return search(root, prefix, true);
    }

    static class Node {
        Node[] data = new Node[26];
        boolean endOfWord;
    }
}
