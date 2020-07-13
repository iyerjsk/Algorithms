package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class levelOrderTraversal {

    public void printLevelOrderTree (Node head) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.left != null ) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
            System.out.println(node.val);
        }
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.left = new Node(3);
        head.left.left = new Node(2);
        head.left.left.right = new Node(4);
        head.right = new Node(7);
        head.right.right = new Node(9);
        head.right.left = new Node(5);

        new levelOrderTraversal().printLevelOrderTree(head);
    }
}
