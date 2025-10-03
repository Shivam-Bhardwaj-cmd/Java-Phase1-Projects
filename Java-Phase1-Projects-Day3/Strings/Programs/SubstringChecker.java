

import java.util.Scanner;

public class SubstringChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the main string: ");
        String mainStr = sc.nextLine();

        System.out.print("Enter the substring to check: ");
        String subStr = sc.nextLine();

        if (mainStr.contains(subStr)) {
            System.out.println("'" + subStr + "' is a substring of the main string.");
        } else {
            System.out.println("'" + subStr + "' is NOT a substring of the main string.");
        }

        sc.close();
    }
}
