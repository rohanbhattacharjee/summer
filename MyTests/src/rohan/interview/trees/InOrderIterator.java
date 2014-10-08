package rohan.interview.trees;

import java.util.Iterator;
import java.util.Stack;

public class InOrderIterator implements Iterator<TreeNode> {

	private TreeNode current;
	private Stack<TreeNode> stack;
	
	InOrderIterator(TreeNode root) {
		this.current = root;
		this.stack = new Stack<TreeNode>();
	}
	
	public static void main(String[] args) {
		TreeNode root = makeTree();

		InOrderIterator iter = new InOrderIterator(root);
		
		while (iter.hasNext()) {
			System.out.print(iter.next().value);
			System.out.print(" -> ");
		}
	}

	@Override
	public boolean hasNext() {
		if (current != null || stack.size() > 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public TreeNode next() {
		if (! hasNext()) {
			return null;
		}

		while (current != null) {
			stack.push(current);
			current = current.left;
		}
		
		current = stack.pop();
		TreeNode node = current;
		current = current.right;				
		
		return node;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
	
	private static TreeNode makeTree() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		
		node1.left = node2;
		node1.right = node3;		
		node2.left = node4;		
		node3.right = node5;
		
		return node1;
	}
}

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int value) {
		this.value = value;
	}
}
