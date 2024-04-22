public class Main {
	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addEdge("A", "B", 2);
		graph.addEdge("A", "E", 9);
		graph.addEdge("A", "D", 7);
		graph.addEdge("A", "C", 1);
		graph.addEdge("B", "E", 1);
		graph.addEdge("D", "E", 3);
		graph.addEdge("C", "F", 6);
		graph.addEdge("C", "G", 12);
		graph.addEdge("F", "G", 2);
		graph.addEdge("D", "G", 2);
		graph.addEdge("E", "G", 8);
		graph.addEdge("E", "H", 7);
		graph.addEdge("G", "H", 1);

		Dijkstra.dijkstra(graph, "A");
	}
}
