import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		EvenlyDistributedArrayGenerator evenlyDistributedArrayGenerator = new EvenlyDistributedArrayGenerator();
		UnevenlyDistributedArrayGenerator unevenlyDistributedArrayGenerator = new UnevenlyDistributedArrayGenerator();
		SortAndPrintRuntime sortAndPrintRuntime = new SortAndPrintRuntime();
		BucketSort bucketSort = new BucketSort();

		ArrayList<int[]> evenlyDistributedArrays = evenlyDistributedArrayGenerator.generateEvenlyDistributedArray(2);
		System.out.println("-----------------------------------");

		ArrayList<int[]> unevenlyDistributedArrays = unevenlyDistributedArrayGenerator.generateUnevenlyDistributedArray(2);
		System.out.println("-----------------------------------");

		System.out.println("Unevenly Distributed Arrays runtime:");
		sortAndPrintRuntime.sortAndPrintRuntime(evenlyDistributedArrays, bucketSort);

		System.out.println("-----------------------------------");

		System.out.println("Unevenly Distributed Arrays runtime:");
		sortAndPrintRuntime.sortAndPrintRuntime(unevenlyDistributedArrays, bucketSort);
	}
}

