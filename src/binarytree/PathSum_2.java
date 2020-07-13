package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSum_2 {
    public List<List<Integer>> pathSum(Node root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, result, new ArrayList<>(), sum);
        return result;
    }

    private void pathSum(Node node, List<List<Integer>> result, List<Integer> cList, int target) {
        if(node == null) {
            return;
        }

        cList.add(node.val);
        if(node.left == null && node.right == null) {
            if(node.val == target) {
                List<Integer> tmp = new ArrayList<>(cList);
                result.add(tmp);
                cList.remove(cList.size() - 1);
                return;
            }
        }
        pathSum(node.left, result, cList, (target- node.val));
        pathSum(node.right, result, cList, (target - node.val));
        cList.remove(cList.size() - 1);
    }
}
