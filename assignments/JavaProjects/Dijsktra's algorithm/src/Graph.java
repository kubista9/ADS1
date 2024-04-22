import java.util.*;

class Graph {
	public Map<String, List<Edge>> adjacencyList;

	public Graph() {
		// Adjacency list - list of nodes that are directly connected to a given node.
		// The key is a unique identifier for each value in the map. In the context of a graph, the
		// key represents a node, and the value represents list of nodes that are directly connected to the key node.
		this.adjacencyList = new HashMap<>(); //for nodes - represented sa keys in the HashMap
	}

	// When a new node is added to the graph, it is first checked if the node already exists in the HashMap.
	// If not, a new entry is created with the node as the key and an empty list as the value.
	public void addNode(String node) {
		if (!adjacencyList.containsKey(node)) {
			adjacencyList.put(node, new ArrayList<>());
		}
	}

	public void addEdge(String node1, String node2, int weight) { //between two nodes
		addNode(node1);
		addNode(node2);
		adjacencyList.get(node1).add(new Edge(node2, weight));
		adjacencyList.get(node2).add(new Edge(node1, weight)); // For undirected graph
	}

	public List<Edge> getAdjacentNodes(String node) {
		return adjacencyList.get(node);
	}

	class Edge {
		String node;
		int weight;

		public Edge(String node, int weight) {
			this.node = node;
			this.weight = weight;
		}
	}
}
