package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder_1(Node root) {
        if(root == null) {
        return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);
        queue.offer(null);

        List<Integer> list = new ArrayList<>();

        while(!queue.isEmpty()) {

            Node tmpNode = queue.poll();

            if(tmpNode == null) {
              if(!queue.isEmpty()) {
                  queue.offer(null);
              }

              result.add(list);
              list = new ArrayList<>();
            } else {
              list.add(tmpNode.val);

              if(tmpNode.left != null) {
                  queue.offer(tmpNode.left);
              }

              if(tmpNode.right != null) {
                  queue.offer(tmpNode.right);
              }
            }
        }

        return result;
    }

    public List<List<Integer>> levelOrder_2(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs (Node node, int level, List<List<Integer>> list) {
        if(node == null) {
            return;
        }

        if(level >= list.size()) {
            list.add(new ArrayList<>());
        }

        list.get(level).add(node.val);

        dfs(node.left, level + 1, list);
        dfs(node.right, level + 1, list);
    }
}
