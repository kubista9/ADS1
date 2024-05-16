import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapTreeMap {

	public static void main(String[] args) {
		// Creating HashMap and TreeMap
		Map<Integer, String> hashMap = new HashMap<>();
		Map<Integer, String> treeMap = new TreeMap<>();

		// Measure time to put elements into HashMap
		long startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			hashMap.put(i, "Value" + i);
		}
		long endTime = System.nanoTime();
		long hashMapPutTime = endTime - startTime;
		System.out.println("Time taken to put elements into HashMap: " + hashMapPutTime + " nanoseconds");

		// Measure time to put elements into TreeMap
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			treeMap.put(i, "Value" + i);
		}
		endTime = System.nanoTime();
		long treeMapPutTime = endTime - startTime;
		System.out.println("Time taken to put elements into TreeMap: " + treeMapPutTime + " nanoseconds");

		// Measure time to perform get operation in HashMap
		startTime = System.nanoTime();
		hashMap.get(50000); // Get an element from the middle
		endTime = System.nanoTime();
		long hashMapGetTime = endTime - startTime;
		System.out.println("Time taken to perform get operation in HashMap: " + hashMapGetTime + " nanoseconds");

		// Measure time to perform get operation in TreeMap
		startTime = System.nanoTime();
		treeMap.get(50000); // Get an element from the middle
		endTime = System.nanoTime();
		long treeMapGetTime = endTime - startTime;
		System.out.println("Time taken to perform get operation in TreeMap: " + treeMapGetTime + " nanoseconds");
	}
}
