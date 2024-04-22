import java.util.*;

class Dijkstra {
	public static void dijkstra(Graph graph, String startNode) {
		Map<String, Integer> distances = new HashMap<>();
		Map<String, String> previousNodes = new HashMap<>();
		PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

		for (String node : graph.adjacencyList.keySet()) {
			distances.put(node, Integer.MAX_VALUE);
		}
		distances.put(startNode, 0);
		queue.add(startNode);

		while (!queue.isEmpty()) {
			String currentNode = queue.poll();
			for (Graph.Edge edge : graph.getAdjacentNodes(currentNode)) {
				int newDistance = distances.get(currentNode) + edge.weight;
				if (newDistance < distances.get(edge.node)) {
					distances.put(edge.node, newDistance);
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
