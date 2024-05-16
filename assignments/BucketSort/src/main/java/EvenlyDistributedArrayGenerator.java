import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class EvenlyDistributedArrayGenerator {
	private RandomArrayGenerator randomArrayGenerator = new RandomArrayGenerator();
	public ArrayList<int[]> generateEvenlyDistributedArray(int numberOfArrays) {
		ArrayList<int[]> arrayListOfArrays = new ArrayList<>();

		for (int i = 0; i < numberOfArrays; i++) {
			int[] randomArray = randomArrayGenerator.generateRandomArray();
			Random randomElement = new Random();

			// Fill the random array evenly with random elements
			for (int j = 0; j < randomArray.length; j++) {
				int randomCoefficient = 3;
				int coefficient = randomElement.nextInt(randomCoefficient);
				randomArray[j] = j + coefficient;
			}
			arrayListOfArrays.add(randomArray);
		}

		arrayListOfArrays.forEach(array -> System.out.println("Content of the EVENLY distributed arrayList: " + Arrays.toString(array)));
		return arrayListOfArrays;
	}
}
