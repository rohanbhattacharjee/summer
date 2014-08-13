package rohan.interview.linkedList;

public class ReverseList {

	public static void main(String[] args) {
		Node head = makeLinkedList();
		printLinkedList(head);
		
		System.out.println();
		
		Node newHead = reverseList(head);
		printLinkedList(newHead);
	}

	private static Node reverseList(Node head) {
	    if (head == null || head.next == null) {
	        return head;
	    }
	    
	    Node ptr1 = null;
	    Node ptr2 = head;
	    Node ptr3 = head.next;
	    
	    while (ptr2 != null) {
	        ptr2.next = ptr1;

	        ptr1 = ptr2;
	        ptr2 = ptr3;
	        
	        if (ptr3 != null) {
	            ptr3 = ptr3.next;
	        }
	    }
	    
	    return ptr1;
	}

	private static void printLinkedList(Node node) {
		if (node == null) {
			System.out.println("Empty List");
		}
		
		while (node != null) {
			System.out.print(node.id);
			if (node.next != null) {
				System.out.print(" -> ");
			}
			
			node = node.next;
		}
	}

	private static Node makeLinkedList() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		return node1;
	}

	static class Node {
	    int id;
	    Node next;
	    
	    Node(int id) {
	        this.id = id;
	    }
	}

}
