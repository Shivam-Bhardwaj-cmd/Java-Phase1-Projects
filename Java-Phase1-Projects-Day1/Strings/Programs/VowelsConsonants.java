package Strings.Programs;
import java.util.Scanner;
public class VowelsConsonants {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine().toLowerCase();  // convert to lowercase

        int vowels = 0, consonants = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {  // consider only alphabet characters
                if ("aeiou".indexOf(ch) != -1) vowels++;
                else consonants++;
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);

        sc.close();
    }

    
}
