package Strings.Programs;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;


public class UniqueCharacters {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);

        System.out.print("Enter a String : ");
        String input = sc.nextLine();

       Set<Character> uniqueChars=new LinkedHashSet<>();
       for (char c : input.toCharArray()){
        uniqueChars.add(c);

       }
       StringBuilder result =new StringBuilder();
       for (char c : uniqueChars ) {
        result.append(c);

       }

       System.out.println("Unique characters: "+ result.toString());
       sc.close();
    }
    
}
