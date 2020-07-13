package binarytree;


/**
 *  Print root node at the beginning
 *  Then print all the left nodes and then right nodes
 */
public class PreOrderTraversal {

    public void printTree (Node node) {
        if(node == null) {
            return;
        }
        System.out.println(node.val);
        printTree(node.left);
        printTree(node.right);
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.left = new Node(15);
        head.left.left = new Node(3);
        head.left.left.left = new Node(5);
        head.left.right = new Node(6);
        head.right = new Node(30);
        head.right.right = new Node(2);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(8);

        new PreOrderTraversal().printTree(head);
    }
}
