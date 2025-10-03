package Strings.Programs;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        if (str1.length() != str2.length()) {
            System.out.println("Not an anagram");
            sc.close();
            return;
        }

        char[] a1 = str1.toLowerCase().toCharArray();
        char[] a2 = str2.toLowerCase().toCharArray();

        Arrays.sort(a1);
        Arrays.sort(a2);

        if (Arrays.equals(a1, a2)) {
            System.out.println("Strings are anagrams");
        } else {
            System.out.println("Strings are not anagrams");
        }

        sc.close();
    }
}
