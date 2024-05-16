import java.util.ArrayList;
import java.util.Arrays;

public class SortAndPrintRuntime {
	private long[] evenRuntimes;
	private long[] unevenRuntimes;
	private int evenIndex = 0;
	private int unevenIndex = 0;

	public SortAndPrintRuntime(int numberOfEvenArrays, int numberOfUnevenArrays){
		this.evenRuntimes = new long[numberOfEvenArrays];
		this.unevenRuntimes = new long[numberOfUnevenArrays];
	}
	public void addEvenRuntime(long runtime) {
		if (evenIndex < evenRuntimes.length) {
			evenRuntimes[evenIndex++] = runtime;
		} else {
			System.out.println("Attempted to add more even runtimes than the initial array size.");
		}
	}

	public void addUnevenRuntime(long runtime) {
		if (unevenIndex < unevenRuntimes.length) {
			unevenRuntimes[unevenIndex++] = runtime;
		} else {
			System.out.println("Attempted to add more uneven runtimes than the initial array size.");
		}
	}

	public long[] getEvenRuntimes() {
		return evenRuntimes;
	}

	public long[] getUnevenRuntimes() {
		return unevenRuntimes;
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

	protected void sortAndPrintRuntime(ArrayList<int[]> arrays, BucketSort bucketSort, boolean isEven) {

		for (int[] array : arrays) {
			int maxVal = getMaxValue(array);
			long startTime = System.nanoTime();
			bucketSort.sort(array, maxVal);
			long endTime = System.nanoTime();
			long runtime = endTime - startTime;

			if (isEven) {
				addEvenRuntime(runtime);
			} else {
				addUnevenRuntime(runtime);
			}

			System.out.println("Sorted Array: " + Arrays.toString(array) + " - Runtime: " + runtime + " nanoseconds");
			double avgRuntimePerElement = (double) runtime / array.length;
			System.out.printf("Average runtime per element: %.2f nanoseconds for %d elements.%n", avgRuntimePerElement, array.length);
		}
	}
}
