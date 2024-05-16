import java.util.*;

class Dijkstra {

	// Initially, the distance to the source node is set to 0, and the distance to all other nodes is set to infinity.
	public static void dijkstra(Graph graph, String startNode) {
		Map<String, Integer> distances = new HashMap<>();
		Map<String, String> previousNodes = new HashMap<>();

		// to select the next node to visit based on the shortest distance. This queue is initialized with the source node.
		PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

		// initializes the distances from the source node to all other nodes in the graph to Integer.MAX_VALUE - infinity
		for (String node : graph.adjacencyList.keySet()) { //graph.adjacencyList.keySet() method retrieves all the nodes in the graph
			distances.put(node, Integer.MAX_VALUE);
		}
		distances.put(startNode, 0); //sets the distance from the start node to itself as 0
		queue.add(startNode); //adds the start node to the priority queue. Priority queue is used to select the next node to visit based on the shortest distance

		// It repeatedly selects the node with the smallest distance from the priority queue, updates the
		// distances of its adjacent nodes, and adds them to the priority queue. This process continues
		// until the priority queue is empty, indicating that all reachable nodes have been visited.


		while (!queue.isEmpty()) {
			String currentNode = queue.poll(); // Removes the node with the smallest distance from the priority queue. Returns the head of the queue.
			for (Graph.Edge edge : graph.getAdjacentNodes(currentNode)) {
				int newDistance = distances.get(currentNode) + edge.weight;

				if (newDistance < distances.get(edge.node)) {
					distances.put(edge.node, newDistance); //updates the previousNodes map, which keeps track of the node that leads to the shortest path to each node.
					previousNodes.put(edge.node, currentNode);
					queue.add(edge.node);
				}
			}
		}

		printShortestPaths(distances, previousNodes, startNode);
	}

	private static void printShortestPaths(Map<String, Integer> distances, Map<String, String> previousNodes, String startNode) {
		for (String node : distances.keySet()) {
			System.out.println("Distance from " + startNode + " to " + node + ": " + distances.get(node));
			System.out.println("Path: " + startNode);
			String currentNode = node;
			while (previousNodes.containsKey(currentNode)) {
				System.out.print(" -> " + previousNodes.get(currentNode));
				currentNode = previousNodes.get(currentNode);
			}
			System.out.println();
		}
	}
}
