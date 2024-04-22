public class Main {
	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "C", 3);
		graph.addEdge("B", "C", 2);
		graph.addEdge("B", "D", 5);
		graph.addEdge("C", "D", 1);

		Dijkstra.dijkstra(graph, "A");
	}
}
