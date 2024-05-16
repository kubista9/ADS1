import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequencyCounter {

	public static void main(String[] args) {
		// Get a sentence from the user
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a sentence: ");
		String sentence = scanner.nextLine();

		// Process the sentence
		String[] words = sentence.split("\\s+");
		Map<String, Integer> wordFrequency = new HashMap<>();

		for (String word : words) {
			// Remove punctuation and convert to lowercase for better counting
			word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
			// Update the word frequency in the map
			if (!word.isEmpty()) {
				wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
			}
		}

		// Display words along with their frequencies
		System.out.println("Word frequencies:");
		for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}
