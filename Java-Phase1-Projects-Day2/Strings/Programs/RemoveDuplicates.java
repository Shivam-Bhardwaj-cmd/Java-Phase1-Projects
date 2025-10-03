package Strings.Programs;

import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Step 2: Use StringBuilder to store result
        StringBuilder result = new StringBuilder();

        // Step 3: Loop through input string
        for (int i = 0; i < input.length(); i++) {
            // Add the first character always
            if (i == 0 || input.charAt(i) != input.charAt(i - 1)) {
                result.append(input.charAt(i));
            }
        }

        // Step 4: Show output
        System.out.println("After removing consecutive duplicates: " + result.toString());

        sc.close();
    }
}
