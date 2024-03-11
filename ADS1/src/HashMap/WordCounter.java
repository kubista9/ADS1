package HashMap;

import java.util.Scanner;

public class WordCounter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a sentence: ");
		String sentence = scanner.nextLine();

		String[] words = sentence.split("\\s+"); // Split the sentence into words
		for (String word : words){
			// Remove punctuation and convert to lowercase for better counting
			word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
			// Update the word frequency in the map
			if(word != ""){
				// add the word to the map or if already present:
				// increment the number of occurrences of the word in the map
			}
		}
	}
}
