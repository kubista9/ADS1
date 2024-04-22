import java.util.*;

class Graph {
	public Map<String, List<Edge>> adjacencyList;

	public Graph() {
		this.adjacencyList = new HashMap<>();
	}

	public void addNode(String node) {
		if (!adjacencyList.containsKey(node)) {
			adjacencyList.put(node, new ArrayList<>());
		}
	}

	public void addEdge(String node1, String node2, int weight) {
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
