import java.util.*;

public class BucketSort {
	public static void sort(int[] array, int bucketSize) {
		int[] bucket = new int[bucketSize + 1];

		for (int i = 0; i < array.length; i++) {
			bucket[array[i]]++;
		}

		// tracks the position in the original array where
		// the next sorted element should be placed
		int currentSortPosition = 0;
		//outer loop - iterates through each index of the bucket array
		for (int i = 0; i < bucket.length; i++) {
			//inner loop - for each index in the bucket array represents
			//how many times the value i is present in the original array
			for (int j = 0; j < bucket[i]; j++) {
				array[currentSortPosition++] = i;
			}
		}
	}

	public static void main(String[] args) {
		int[] data = {5, 3, 0, 2, 4, 1, 0, 5, 2, 3, 1, 4}; // Example input
		System.out.println("Original Array: " + Arrays.toString(data));

		int maxVal = Arrays.stream(data).max().getAsInt();
		sort(data, maxVal);
		System.out.println("Sorted Array: " + Arrays.toString(data));
	}
}
