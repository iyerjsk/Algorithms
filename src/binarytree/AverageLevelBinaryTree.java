package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * Note:
 * The range of node's value is in the range of 32-bit signed integer.
 */
public class AverageLevelBinaryTree {

    public List<Double> averageOfLevels(Node root) {
        if(root == null) {
            return null;
        }
        List<Double> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        double total = 0.0;
        int number = 0 ;
        while (!queue.isEmpty()) {
            Node Node = queue.poll();
            if(Node == null) {
                if(!queue.isEmpty()) {
                    queue.offer(null);
                }
                result.add(total/number);
                total = 0;
                number = 0;
            } else {
                total += Node.val;
                ++number;
                if(Node.left != null) {
                    queue.offer(Node.left);
                }
                if(Node.right != null) {
                    queue.offer(Node.right);
                }

            }

        }
        return result;


    }
}
