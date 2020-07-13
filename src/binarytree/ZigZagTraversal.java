package binarytree;

import java.util.*;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * Accepted
 */
public class ZigZagTraversal {
    // Approach using  queue and reverse counter
    public List<List<Integer>> zigzagLevelOrder(Node root) {

        if(root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue  = new LinkedList<>();
        ArrayList<Integer> level = new ArrayList<>();
        int reverse = 1;

        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            Node Node = queue.poll();
            if(Node == null) {
                if(reverse == -1) {
                    Collections.reverse(level);
                }
                result.add(level);
                reverse *= -1;
                level =  new ArrayList<>();
                if(!queue.isEmpty()) {
                    queue.offer(null);
                }
            }
            else {
                level.add(Node.val);
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

    // Approach using 2 stacks
//    public List<List<Integer>> zigzagLevelOrder(Node root) {
//
//        if(root == null) return new ArrayList<>();
//
//        List<List<Integer>> result = new ArrayList<>();
//        Stack<Node> stack1  = new Stack<>();
//        Stack<Node> stack2 = new Stack<>();
//
//        stack1.push(root);
//
//        while (!stack1.isEmpty() || !stack2.isEmpty()) {
//            ArrayList<Integer> level = new ArrayList<>();
//            if(!stack1.isEmpty()) {
//                while(!stack1.isEmpty()) {
//                    Node node = stack1.pop();
//
//                    level.add(node.val);
//
//                    if(node.left != null) {
//                        stack2.push(node.left);
//                    }
//
//                    if(node.right != null) {
//                        stack2.push(node.right);
//                    }
//                }
//            } else {
//                while(!stack2.isEmpty()) {
//                    Node node = stack2.pop();
//
//                    level.add(node.val);
//
//                    if(node.right != null) {
//                        stack1.push(node.right);
//                    }
//
//                    if(node.left != null) {
//                        stack1.push(node.left);
//                    }
//                }
//            }
//
//            result.add(level);
//        }
//
//        return result;
//
//    }
}
