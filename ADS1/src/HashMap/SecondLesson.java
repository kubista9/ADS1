package HashMap;

import java.util.*;

public class SecondLesson {
	public static void main(String[] args) {
		final int numberOfElements = 25;
		Map<String, Integer> hashMap = new HashMap<>();

		Map<Integer, Integer> treeMap = new TreeMap<>();

		long startTime = System.nanoTime();
		for (int i = 0; i < numberOfElements; i++){
			hashMap.put(String.valueOf(i),i);
		}
		long endTime = System.nanoTime();
		System.out.println("It tooked the system " + (endTime - startTime) + " ns to put into HashMap");

		startTime = System.nanoTime();
		for (int i = 0; i < numberOfElements; i++) {
			treeMap.put(i, i);
		}
		endTime = System.nanoTime();
		System.out.println("It tooked the system " + (endTime - startTime) + " ns to put into TreeMap");

		Random random = new Random();
		int randomKey = random.nextInt(numberOfElements);

		startTime = System.nanoTime();
		hashMap.get(randomKey);
		endTime = System.nanoTime();
		System.out.println("Time taken to get from HashMap: " + (endTime - startTime) + " ns");

		startTime = System.nanoTime();
		treeMap.get(randomKey);
		endTime = System.nanoTime();
		System.out.println("Time taken to get from TreeMap: " + (endTime - startTime) + " ns");

	}
}
