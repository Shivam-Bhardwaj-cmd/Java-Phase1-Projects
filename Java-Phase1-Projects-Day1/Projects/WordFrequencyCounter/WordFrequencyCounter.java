package Projects.WordFrequencyCounter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        // 1. Take input from user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = scanner.nextLine();

        // 2. Convert everything to lowercase for uniformity
        input = input.toLowerCase();

        // 3. Split sentence into words (by space)
        String[] words = input.split(" ");

        // 4. Create a HashMap to store word → frequency
        Map<String, Integer> wordCount = new HashMap<>();

        // 5. Go through each word
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                // If word already exists → increase its count
                int oldCount = wordCount.get(word);
                wordCount.put(word, oldCount + 1);
            } else {
                // If word is new → add it with count 1
                wordCount.put(word, 1);
            }
        }

        // 6. Print the result
        System.out.println("\nWord Frequency:");
        for (String key : wordCount.keySet()) {
            System.out.println(key + " : " + wordCount.get(key));
        }

        scanner.close();
    }
}
