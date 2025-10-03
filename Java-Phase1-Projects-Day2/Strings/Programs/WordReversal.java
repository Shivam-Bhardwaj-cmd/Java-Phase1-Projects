package Strings.Programs;

import java.util.Scanner;

public class WordReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take input
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        // Step 2: Split sentence into words
        String[] words = input.split("\\s+");

        // Step 3: Reverse each word
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(new StringBuilder(word).reverse().toString()).append(" ");
        }

        // Step 4: Print reversed sentence
        System.out.println("Reversed words: " + result.toString().trim());

        sc.close();
    }
}



