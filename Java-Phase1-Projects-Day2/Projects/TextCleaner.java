package Projects;

import java.util.Scanner;

public class TextCleaner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take input
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        // Step 2: Remove special characters (keep letters, numbers, and spaces)
        String cleaned = input.replaceAll("[^a-zA-Z0-9\\s]", "");

        // Step 3: Replace multiple spaces with single space
        cleaned = cleaned.replaceAll("\\s+", " ").trim();

        // Step 4: Convert to lowercase
        cleaned = cleaned.toLowerCase();

        // Step 5: Display cleaned text
        System.out.println("Cleaned text: " + cleaned);

        sc.close();
    }
}
