package LinkedList;

import java.util.Stack;

import LinkedList.CircularLinkedList.Node;

public class PalindromLinkedList {
	
	public static class Node {
	    public final int val;
	    public Node next;

	    public Node(int val) {
	        this.val = val;
	    }
	}
	
    public boolean isPalindrome(Node head) {
        Stack<Integer> stack = new Stack<>();
        Node current = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            stack.push(current.val);
            fast = fast.next.next;
            current = current.next;
        }

        if(fast != null) current = current.next;

        while(current != null && current.next != null) {
            if(current.val != stack.pop()) {
                return false;
            }
            current = current. next;
        }

        return true;
    }

    public static void main(String[] args) {
		//Creating nodes
		Node head  = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		Node node3 = new Node(3);
		Node node4 = new Node(2);
		Node node5 = new Node(1);
		Node node6 = new Node(4);
		
		
		//Creating linked list with above nodes
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

        System.out.println(new PalindromLinkedList().isPalindrome(head));

        
        head.next = node1;
		node1.next = node3;
		node3.next = node4;
		node4.next = node5;

        System.out.println(new PalindromLinkedList().isPalindrome(head));

        
        head.next = node1;
		node1.next = node3;
		node3.next = node6;
		node6.next = node5;

        System.out.println(new PalindromLinkedList().isPalindrome(head));

        head.next = node1;
		node1.next = node2;
		node2.next = node6;
		node6.next = node4;
		node4.next = node5;


        System.out.println(new PalindromLinkedList().isPalindrome(head));
    }
}
