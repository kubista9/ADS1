import java.util.ArrayList;
import java.util.Arrays;

public class SortAndPrintRuntime {
	private long[] runtimes;

	public SortAndPrintRuntime(int numberOfArrays){
		this.runtimes = new long[numberOfArrays];
	}
	public void addRuntime(long runtime) {
		int index = 0;
		if (index < runtimes.length) {
			runtimes[index + 1] = runtime;
		} else {
			System.out.println("Attempted to add more runtimes than the initial array size.");
		}
	}
	public long[] getRuntimes() {
		return runtimes;
	}

	private int getMaxValue(int[] array) {
		int maxVal = array[0];
		for (int val : array) {
			if (val > maxVal) {
				maxVal = val;
			}
		}
		return maxVal;
	}

	protected void sortAndPrintRuntime(ArrayList<int[]> arrays, BucketSort bucketSort) {

		for (int[] array : arrays) {
			int maxVal = getMaxValue(array);
			long startTime = System.nanoTime();
			bucketSort.sort(array, maxVal);
			long endTime = System.nanoTime();
			long runtime = endTime - startTime;

			addRuntime(runtime);

			System.out.println("Sorted Array: " + Arrays.toString(array) + " - Runtime: " + runtime + " nanoseconds");
			double avgRuntimePerElement = (double) runtime / array.length;
			System.out.printf("Average runtime per element: %.2f nanoseconds for %d elements.%n", avgRuntimePerElement, array.length);
		}
	}
}
