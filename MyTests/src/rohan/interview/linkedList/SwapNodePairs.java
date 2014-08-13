package rohan.interview.linkedList;

public class SwapNodePairs {

	public static void main(String[] args) {
		Node head = makeLinkedList();
		printLinkedList(head);
		
		System.out.println();
		
		Node newHead = swapNodePairs(head);
		printLinkedList(newHead);
	}

	private static void printLinkedList(Node head) {
		if (head == null) {
			System.out.println("Empty list");
			return;
		}
		
		while (head != null) {
			System.out.print(head.id);
			
			if (head.next != null) {
				System.out.print(" -> ");
			}
			
			head = head.next;
		}
		
	}

	private static Node makeLinkedList() {
		Node node0 = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		
		node0.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		return node0;
	}

	private static Node swapNodePairs(Node node) {
	    if (node == null || node.next == null) {
	        return node;
	    }
	    
	    Node ptr1 = node;
	    Node ptr2 = node.next;
	    Node ptr3 = node.next.next;

	    ptr2.next = ptr1;
	    
	    ptr1.next = swapNodePairs(ptr3);

	    return ptr2;    
	}
	
	static class Node {
	    Node next;
	    int id;
	    
	    public Node(int id) {
	        this.id = id;
	    }
	}
}

