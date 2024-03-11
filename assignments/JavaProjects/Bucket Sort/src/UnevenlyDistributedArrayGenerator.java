import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class UnevenlyDistributedArrayGenerator {
	private RandomArrayGenerator randomArrayGenerator = new RandomArrayGenerator();
	public ArrayList<int[]> generateUnevenlyDistributedArray(int numberOfArrays) {
		ArrayList<int[]> arrayListOfArrays = new ArrayList<>();
		Random randomElement = new Random();

		for (int i = 0; i < numberOfArrays; i++) {
			int[] randomArray = randomArrayGenerator.generateRandomArray();

			// Fill the random array unevenly with random elements
			for (int j = 0; j < randomArray.length; j++) {
				if (j % 2 == 0) {
					randomArray[j] = j + randomElement.nextInt(5);
				} else {
					randomArray[j] = j * randomElement.nextInt(5);
				}
			}
			arrayListOfArrays.add(randomArray);
		}

		arrayListOfArrays.forEach(array -> System.out.println("Content of the UNEVENLY distributed arrayList: " + Arrays.toString(array)));
		return arrayListOfArrays;
	}
}
