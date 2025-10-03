package Strings.Programs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take user input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Step 2: Remove spaces for counting letters only (optional)
        String cleanedInput = input.replaceAll("\\s", "").toLowerCase();

        // Step 3: Create a HashMap to store character counts
        Map<Character, Integer> charCount = new HashMap<>();

        // Step 4: Count characters
        for (char c : cleanedInput.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Step 5: Print results
        System.out.println("\nCharacter Frequency:");
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        sc.close();
    }
    
}
