package rohan.interview.trees;


public class InOrderSuccessor {
	private static Node node0;
	private static Node node1;
	private static Node node2;
	private static Node node3;
	private static Node node4;
	private static Node node5;
	
    public static class Node {
        public Node left;
        public Node right;
        public Node parent;
        public int data;
        
        Node(int data) {
        	this.data = data;
        }
    }
    
    public static void main(String[] args) {
        Node root = makeTestTree();
        
        Node nextNode = getNextInOrderSucc(root);
        System.out.println(String.format("Node next after %d is %d", node0.data, nextNode.data));
        
        nextNode = getNextInOrderSucc(node1);
        
        if (nextNode != null) {
            System.out.println(String.format("Node next after %d is %d", node1.data, nextNode.data));
        } else {
            System.out.println(String.format("No successor after %d", node1.data));
        }

        nextNode = getNextInOrderSucc(node2);
        
        if (nextNode != null) {
            System.out.println(String.format("Node next after %d is %d", node2.data, nextNode.data));
        } else {
            System.out.println(String.format("No successor after %d", node2.data));
        }

        nextNode = getNextInOrderSucc(node3);
        
        if (nextNode != null) {
            System.out.println(String.format("Node next after %d is %d", node3.data, nextNode.data));
        } else {
            System.out.println(String.format("No successor after %d", node3.data));
        }

        nextNode = getNextInOrderSucc(node4);
        
        if (nextNode != null) {
            System.out.println(String.format("Node next after %d is %d", node4.data, nextNode.data));
        } else {
            System.out.println(String.format("No successor after %d", node4.data));
        }

        nextNode = getNextInOrderSucc(node5);
        
        if (nextNode != null) {
            System.out.println(String.format("Node next after %d is %d", node5.data, nextNode.data));
        } else {
            System.out.println(String.format("No successor after %d", node5.data));
        }
    }

    public static Node getNextInOrderSucc(Node node) {
        if (node == null) {
            return null;
        }
        
        if (node.right != null) {
            Node successor = getLeftMostChild(node.right);
            return successor;
        }
        
        Node parentNode = node.parent;
        
        while (parentNode != null && node != parentNode.left) {
            node = parentNode;
            parentNode = node.parent;            
        }
        
        return parentNode;
    }

    public static Node getLeftMostChild(Node node) {
        if (node == null) {
            return null;
        }
        
        while (node.left != null) {
            node = node.left;
        }
        
        return node;
    }

    public static Node makeTestTree() {
        node0 = new Node(0);
        node1 = new Node(1);
        node2 = new Node(2);
        node3 = new Node(3);
        node4 = new Node(4);
        node5 = new Node(5);
        
        node0.left = node1;
        node0.right = node2;
        node1.parent = node0;
        node2.parent = node0;
        
        node1.left = node3;
        node3.parent = node1;
        
        node2.left = node4;
        node2.right = node5;
        node4.parent = node2;
        node5.parent = node2;
        
        return node0;
    }
}