public class BucketSort {
	public void sort(int[] array, int bucketSize) {
		int[] bucket = new int[bucketSize + 1];

		for (int i = 0; i < array.length; i++) {
			bucket[array[i]]++;
		}

		int currentSortPosition = 0; // tracks the position in the original array where the next sorted element should be placed
		//outer loop - iterates through each index of the bucket array
		for (int i = 0; i < bucket.length; i++) {
			//inner loop - for each index in the bucket array represents how many times the value i is present in the original array
			for (int j = 0; j < bucket[i]; j++) {
				array[currentSortPosition++] = i;
			}
		}
	}
}
