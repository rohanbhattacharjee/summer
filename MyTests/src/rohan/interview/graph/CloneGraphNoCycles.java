package rohan.interview.graph;

import java.util.ArrayList;
import java.util.List;

public class CloneGraphNoCycles {
	public static void main(String[] args) {
		Node startNode = makeGraph();
		printGraph(startNode, 0);
		Node copyOfStart = Node.cloneGraph(startNode);
		printGraph(copyOfStart, 0);
	}
	
	private static Node makeGraph() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		
		node1.neighbors.add(node2);
		node1.neighbors.add(node3);
	
		node3.neighbors.add(node4);
		return node1;
	}
	
	private static void printGraph(Node node, int level) {

		StringBuffer sb = new StringBuffer();
		
		for (int i = 1; i <= level; i++) {
			sb.append("\t");
		}

		sb.append(node.id);
		System.out.println(sb.toString());

		for (Node neighbor : node.neighbors) {
			printGraph(neighbor, level + 1);
			System.out.println();
		}
	}
}

class Node {
    public List<Node> neighbors;
    public int id;
    
    public Node(int id) {
        this.neighbors = new ArrayList<Node>();
        this.id = id;
    }
    
    // Can clone only the connected component
    // Does not handle loops in the graph.
    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        Node copyOfNode = new Node(100 +  node.id);
        
        for (Node neighbor : node.neighbors) {
            Node copyOfNeighbor = cloneGraph(neighbor);
            
            if (copyOfNeighbor != null) {
                copyOfNode.neighbors.add(copyOfNeighbor);            
            }
        }
        
        return copyOfNode;
    }
}
