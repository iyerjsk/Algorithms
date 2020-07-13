package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(Node root) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        listPaths(root, new ArrayList<>(), result);
        return result;
    }

    public void listPaths(Node node, List<Integer> tmp, List<String> list) {
        if(node == null) {
            return;
        }
        tmp.add(node.val);
        if(node.left == null && node.right == null) {
            list.add(tmp.stream().map(Object::toString).collect(Collectors.joining("->")));
            tmp.remove(tmp.size() - 1);
            return;
        }
        listPaths(node.left, tmp, list);
        listPaths(node.right, tmp, list);
        tmp.remove(tmp.size() - 1);
    }
}
