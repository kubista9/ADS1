import java.util.Random;

public class RandomArrayGenerator {
	public static int[] generateRandomArray() {
		Random randomSize = new Random();
		int a = 30;
		int randomArraySize = randomSize.nextInt(a) + 1;
		int[] randomArray = new int[randomArraySize];
		return randomArray;
	}
}
