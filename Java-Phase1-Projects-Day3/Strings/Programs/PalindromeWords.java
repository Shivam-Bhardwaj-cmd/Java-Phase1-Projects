import java.util.Scanner;

public class PalindromeWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word or sentence: ");
        String input = sc.nextLine();

        // Clean input: remove non-alphanumeric characters and lowercase
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Reverse string
        String reversed = new StringBuilder(cleaned).reverse().toString();

        // Check palindrome
        if (cleaned.equals(reversed)) {
            System.out.println("It is a palindrome!");
        } else {
            System.out.println("Not a palindrome.");
        }

        sc.close();
    }
}

