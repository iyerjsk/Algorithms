package binarytree;

/**
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
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
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {
    
    public boolean hasPathSum(Node root, int sum) {
        return hasSum(root, sum);
    }

    private boolean hasSum(Node node, int target) {
        if(node == null) {
            return false;
        }
        if(node.left == null && node.right == null) {
            return node.val == target;
        }
        boolean result = false;
        result = hasSum(node.left, (target - node.val));
        if(!result) {
            result = hasSum(node.right, (target - node.val));
        }
        return result;
    }
}
