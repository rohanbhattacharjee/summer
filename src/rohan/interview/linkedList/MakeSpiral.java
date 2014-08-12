package rohan.interview.linkedList;

import java.util.Stack;

public class MakeSpiral {

	public static void main(String[] args) {
		Node head = makeLinkedList(5);
		printLinkedList(head);

		Node newHead = makeSpiral(head);
		printLinkedList(newHead);
		
		head = makeLinkedList(6);
		printLinkedList(head);

		newHead = makeSpiral(head);
		printLinkedList(newHead);
	}

	private static void printLinkedList(Node node) {
		if (node == null) {
			System.out.println("Empty list");
		}
		
		while (node != null) {
			System.out.print(node.id);
			
			if (node.next != null) {
				System.out.print(" -> ");
			}
			
			node = node.next;
		}
		
		System.out.println();
	}
	
	private static Node makeLinkedList(int nodeCount) {
		Node head = null;
		Node previous = null;
		
		for (int i = 1; i <= nodeCount; i++) {
			Node node = new Node(i);
			
			if (head == null) {
				head = node;
			}
			
			if (previous != null) {
				previous.next = node;
			}
			
			previous = node;
		}
		
		return head;
	}

	private static Node makeSpiral(Node head) {
	    if (head == null | head.next == null) {
	        return head;
	    }

	    int length = findLength(head);
	    Node node = head;

	    Stack<Node> stack = new Stack<Node>();
	    
	    for (int i = 0; i < length / 2; i++) {
	        stack.push(node);
	        node = node.next;       
	    }
	    
	    if (length % 2 == 0) {
	        stack.push(null);
	    }
	    else {
	        stack.push(node);
	        Node temp = node;
	        node = node.next;
	        temp.next = null;
	    }
	    
	    while (node != null) {
	        Node temp = node.next;
	        node.next = stack.pop();
	        
	        stack.peek().next = node;
	        node = temp;
	    }
	    
	    return head;
	}

	private static int findLength(Node node) {
	    int length = 0;
	    
	    while (node != null) {
	        length++;
	        node = node.next;
	    }
	    
	    return length;
	}
	
	static class Node {
	    int id;
	    Node next;
	    
	    Node(int id) {
	    	this.id = id;
	    }
	}
}
