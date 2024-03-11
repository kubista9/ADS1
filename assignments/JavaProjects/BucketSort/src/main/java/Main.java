import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		EvenlyDistributedArrayGenerator evenlyDistributedArrayGenerator = new EvenlyDistributedArrayGenerator();
		UnevenlyDistributedArrayGenerator unevenlyDistributedArrayGenerator = new UnevenlyDistributedArrayGenerator();
		SortAndPrintRuntime sortAndPrintRuntime = new SortAndPrintRuntime(8);
		BucketSort bucketSort = new BucketSort();
		ChartHelper chartHelper = new ChartHelper();

		ArrayList<int[]> evenlyDistributedArrays = evenlyDistributedArrayGenerator.generateEvenlyDistributedArray(4);
		System.out.println("-----------------------------------");

		ArrayList<int[]> unevenlyDistributedArrays = unevenlyDistributedArrayGenerator.generateUnevenlyDistributedArray(4);
		System.out.println("-----------------------------------");

		System.out.println("Unevenly Distributed Arrays runtime:");
		sortAndPrintRuntime.sortAndPrintRuntime(evenlyDistributedArrays, bucketSort);

		System.out.println("-----------------------------------");

		System.out.println("Unevenly Distributed Arrays runtime:");
		sortAndPrintRuntime.sortAndPrintRuntime(unevenlyDistributedArrays, bucketSort);

		System.out.println("-----------------------------------");
		System.out.println("Graphs");
		chartHelper.createRuntimeChart(evenlyDistributedArrays, sortAndPrintRuntime.getRuntimes(), "Evenly Distributed Array Runtimes" );
	}
}

