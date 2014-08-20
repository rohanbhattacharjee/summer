package rohan.interview.trees;

public class CheckBSTOptionOne {

	private static float lastValue = Float.NEGATIVE_INFINITY;
	
	public static void main(String[] args) {
		Node root = makeBST();
		System.out.println(isBST(root));

		root = makeNonBST();
		System.out.println(isBST(root));
	}

	private static Node makeNonBST() {
		Node node1 = new Node(6);
		Node node2 = new Node(3);
		Node node3 = new Node(9);
		Node node4 = new Node(1);
		
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		
		return node1;
	}

	private static Node makeBST() {
		Node node1 = new Node(6);
		Node node2 = new Node(3);
		Node node3 = new Node(9);
		Node node4 = new Node(1);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		
		return node1;
	}

	public static boolean isBST(Node root) {
		if (root == null) {
			return true;
		}
		
		if (!isBST(root.left)) {
			return false;
		}
		
		if (root.data < lastValue) {
			return false;
		}
		
		lastValue = root.data;
		
		return isBST(root.right);
	}
	
	private static class Node {
		float data;
		Node left;
		Node right;
		
		Node(float data) {
			this.data = data;
		}
	}
}
