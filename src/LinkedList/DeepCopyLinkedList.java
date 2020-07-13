package LinkedList;

public class DeepCopyLinkedList {
	
	public static class Node {
		public int data;
		public Node next;
		
		Node (int data) { this.data = data; }
	}
	
	public static void printLinkedList(Node head) {
		if(head == null ) return;
		
		Node current = head;
		
		while(current !=  null) {
			System.out.println(" " + current.data);
			current = current.next;
		}
	}
	
	public static Node deepCopy(Node head) {
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
		
		boolean startingNodeVisited = false;
		Node newHead = new Node(head.data);
		Node newLoopStartNode = null;
		current = head;
		Node newNode = newHead;	
		while (current.next != null) {
			current = current.next;
			if(current == fast) {
				if(startingNodeVisited) {
					newNode.next = newLoopStartNode;
					break;
				} else {
					startingNodeVisited = true;
					newNode.next = new Node(current.data);
					newNode = newNode.next;
					newLoopStartNode = newNode;
				}
			} else {
				newNode.next = new Node(current.data);
				newNode = newNode.next;
			}
			
		}
		
		return newHead;
		
		
	}
	
	public static void main (String[] args) {
		
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
		
		DeepCopyLinkedList.printLinkedList(head);
		
		Node newList = DeepCopyLinkedList.deepCopy(head);
		node1.data = 100;
		node5.data = 1000;
		
	    System.out.println("---------------------------------------------");
	    
	    DeepCopyLinkedList.printLinkedList(head);
	    
	    System.out.println("---------------------------------------------");
	    
	    DeepCopyLinkedList.printLinkedList(newList);
	    
	    node1.data = 20;
		node5.data = 60;
		node6.next = node2;
		
		newList = DeepCopyLinkedList.deepCopy(head);
		
		node1.data = 100;
		node5.data = 1000;
		
		 System.out.println("---------------------------------------------");
		
		
	}

}
