import java.util.*;

public class BucketSort {

	public static ArrayList<int[]> generateEvenlyDistributedArray(int numberOfArrays) {
		ArrayList<int[]> arrayListOfArrays = new ArrayList<>();

		for (int i = 0; i < numberOfArrays; i++) {
			int[] randomArray = generateRandomArray();
			int randomArraySize = randomArray.length;
			Random randomElement = new Random();

			// Fill the random array with random elements
			for (int j = 0; j < randomArraySize; j++) {
				int randomCoefficient = 3;
				int coefficient = randomElement.nextInt(randomCoefficient);
				randomArray[j] = j + coefficient;
			}
			arrayListOfArrays.add(randomArray);
		}

		for (int[] array : arrayListOfArrays) {
			System.out.println("Content of the arrayList: " + Arrays.toString(array));
		}
		return arrayListOfArrays;
	}

	public static int[] generateRandomArray() {
		Random randomSize = new Random();
		int a = 30;
		int randomArraySize = randomSize.nextInt(a) + 1;
		int[] randomArray = new int[randomArraySize];
		return randomArray;
	}

	public static void sort(int[] array, int bucketSize) {
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

	public static void main(String[] args) {
//		int[] unevenlyDistributedArray = {20, 0, 40, 60, 80, 5, 25, 45, 65, 85, 10, 30, 50, 70, 90, 15, 35, 55, 75, 95};
//		System.out.println("Original unevenly distributed Array: " + Arrays.toString(unevenlyDistributedArray));
//		int unevenMaxValue = Arrays.stream(unevenlyDistributedArray).max().getAsInt();
//		sort(unevenlyDistributedArray, unevenMaxValue);
//		System.out.println("Sorted unevenly distributed array: " + Arrays.toString(unevenlyDistributedArray));
//
//		int[] evenlyDistributedArray = {203, 3, 51, 10, 200, 77, 202, 10, 204, 76, 2, 10, 3, 50, 4, 75, 201, 78, 21, 20};
//		System.out.println("Original evenly distributed Array: " + Arrays.toString(evenlyDistributedArray));
//		int evenMaxValue = Arrays.stream(evenlyDistributedArray).max().getAsInt();
//		sort(evenlyDistributedArray, evenMaxValue);
//		System.out.println("Sorted evenly distributed Array: " + Arrays.toString(evenlyDistributedArray));

		generateEvenlyDistributedArray(3);
	}
}

