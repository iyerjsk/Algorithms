package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class BinaryLevelOrderTraversal_2 {
    public List<List<Integer>> levelOrderBottom(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(Node node, int level, List<List<Integer>> list) {
        // return if the node is null
        if(node == null) {
            return;
        }

        //This is the start of new level
        if(level >= list.size()) {
            list.add(0, new ArrayList<>());
        }

        //Navigate to right and left node which is the next level
        dfs(node.left, level + 1, list);
        dfs(node.right, level + 1, list);

        list.get(list.size() -1 - level).add(node.val);
    }
}
