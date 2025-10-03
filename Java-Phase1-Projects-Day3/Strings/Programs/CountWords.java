

import java.util.Scanner;

public class CountWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        // Split by spaces
        String[] words = sentence.trim().split("\\s+");
        System.out.println("Total words: " + words.length);

        sc.close();
    }
}

