import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		EvenlyDistributedArrayGenerator evenlyDistributedArrayGenerator = new EvenlyDistributedArrayGenerator();
		UnevenlyDistributedArrayGenerator unevenlyDistributedArrayGenerator = new UnevenlyDistributedArrayGenerator();
		SortAndPrintRuntime sortAndPrintRuntime = new SortAndPrintRuntime(4,4);
		BucketSort bucketSort = new BucketSort();
		ChartHelper chartHelper = new ChartHelper();

		ArrayList<int[]> evenlyDistributedArrays = evenlyDistributedArrayGenerator.generateEvenlyDistributedArray(4);
		System.out.println("-----------------------------------");

		ArrayList<int[]> unevenlyDistributedArrays = unevenlyDistributedArrayGenerator.generateUnevenlyDistributedArray(4);
		System.out.println("-----------------------------------");

		System.out.println("Unevenly Distributed Arrays runtime:");
		sortAndPrintRuntime.sortAndPrintRuntime(evenlyDistributedArrays, bucketSort, true);

		System.out.println("-----------------------------------");

		System.out.println("Unevenly Distributed Arrays runtime:");
		sortAndPrintRuntime.sortAndPrintRuntime(unevenlyDistributedArrays, bucketSort, false);

		System.out.println("-----------------------------------");
		System.out.println("Graphs");
		chartHelper.createRuntimeChart(evenlyDistributedArrays, sortAndPrintRuntime.getEvenRuntimes(), unevenlyDistributedArrays, sortAndPrintRuntime.getUnevenRuntimes(), "Evenly vs Unevenly Distributed Array Runtimes" );
	}
}

