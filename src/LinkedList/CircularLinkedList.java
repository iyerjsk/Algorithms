package LinkedList;

public class CircularLinkedList {
	
	public static class Node {
		public int data;
		public Node next;
		
		Node (int data) { this.data = data; }
	}
	
	public Node getStartingNodeForCircularLinkedList (Node head) {
		if(head == null) return null;
		
		Node current = head.next;
		Node fast = head.next != null ? head.next.next : null;
		
		while (fast != null) {
			if(fast == current) {
				break;
			}
			current = current.next;
			fast = fast.next != null? fast.next.next: null;
		}
		
		if(fast != null) {
			current =  head;
			while (current != fast) {
				current = current.next;
				fast = fast.next;
			}
		}
		return fast;
		
	}
	
	public void printLinkedList(Node head) {
		if(head == null ) return;
		
		Node current = head;
		
		while(current !=  null) {
			System.out.println(" " + current.data);
			current = current.next;
		}
	}
	
	public static void main (String[] args) {
		// creating the instance of the class
		CircularLinkedList circularLinkedList = new CircularLinkedList();
		
		//Creating nodes
		Node head  = new Node(10);
		Node node1 = new Node(20);
		Node node2 = new Node(30);
		Node node3 = new Node(40);
		Node node4 = new Node(50);
		Node node5 = new Node(60);
		Node node6 = new Node(70);
		
		
		//Creating linked list with above nodes
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		circularLinkedList.printLinkedList(head);
		
		Node startingNode = circularLinkedList.getStartingNodeForCircularLinkedList(head);
		
		System.out.println("Starting loop node value is " + (startingNode != null ? startingNode.data : "No Loop"));
		
		node6.next = node3;
		startingNode = circularLinkedList.getStartingNodeForCircularLinkedList(head);
		System.out.println("Starting loop node value is " + (startingNode != null ? startingNode.data : "No Loop"));
		
		node6.next = node4;
		startingNode = circularLinkedList.getStartingNodeForCircularLinkedList(head);
		System.out.println("Starting loop node value is " + (startingNode != null ? startingNode.data : "No Loop"));
		
		node6.next = node2;
		startingNode = circularLinkedList.getStartingNodeForCircularLinkedList(head);
		System.out.println("Starting loop node value is " + (startingNode != null ? startingNode.data : "No Loop"));
		
	}

}
